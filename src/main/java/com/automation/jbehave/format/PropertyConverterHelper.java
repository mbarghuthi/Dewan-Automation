package com.automation.jbehave.format;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
final class PropertyConverterHelper {

	private PropertyConverterHelper() {
	}

	private static final String OPEN_PARAM_CHAR = "\uff5f";
	private static final String CLOSE_PARAM_CHAR = "\uff60";
	private static final String TABLE_SEPARATOR = "|";
	private static final String SPLITTER = "[|]";
	private static final String PROP_INDICATOR = "jbehave.converters.property_indicator_prefix";

	private static String convertParameterIntoValue(final Environment properties, String parameter) {
		String propertyIndicatorPrefix = properties.getProperty(PROP_INDICATOR, "p:");
		if (parameter == null) {
			return null;
		}

		parameter = parameter.trim();

		if (parameter.startsWith(propertyIndicatorPrefix)) {
			String key = parameter.substring(
					parameter.indexOf(propertyIndicatorPrefix) + propertyIndicatorPrefix.length()
			);

			String value = properties.getProperty(key);

			// keep original token if property not found
			return value != null ? value : parameter;
		}

		return parameter;
	}

	static String convert(final Environment properties, String convertible) {
		if (convertible == null) {
			return null;
		}

		convertible = convertible.replaceAll("\\[.*?\\]", "").trim();

		if (convertible.contains(TABLE_SEPARATOR)) {
			String[] slices = convertible.split(SPLITTER);
			StringBuilder sb = new StringBuilder();
			sb.append(TABLE_SEPARATOR);

			for (int slice = 0; slice < slices.length; slice++) {
				String originalSlice = slices[slice];
				String newSlice = convertParameterIntoValue(properties, originalSlice);

				if (StringUtils.isEmpty(newSlice)) {
					newSlice = originalSlice;
				}

				sb.append(slices.length != slice + 1 ? newSlice + TABLE_SEPARATOR : newSlice);
			}

			return sb.toString();

		} else if (convertible.contains(properties.getProperty(PROP_INDICATOR, "p:"))) {
			List<String> slices = Arrays.asList(convertible.split("\\s+"));

			for (String slice : slices) {
				if (slice.contains(properties.getProperty(PROP_INDICATOR, "p:"))) {
					String firstUniCode = String.valueOf(slice.charAt(0));
					String lastUniCode = String.valueOf(slice.charAt(slice.length() - 1));

					if ((OPEN_PARAM_CHAR.equals(firstUniCode) || "'".equals(firstUniCode) || "(".equals(firstUniCode))
							&& (CLOSE_PARAM_CHAR.equals(lastUniCode) || "'".equals(lastUniCode) || ")".equals(lastUniCode))) {

						String cleanSlice = slice.substring(
								slice.indexOf(firstUniCode) + 1,
								slice.lastIndexOf(lastUniCode)
						);

						String convertedValue = convertParameterIntoValue(properties, cleanSlice);

						if (convertedValue == null) {
							convertedValue = cleanSlice;
						}

						convertible = convertible.replace(cleanSlice, convertedValue);
					} else {
						String convertedValue = convertParameterIntoValue(properties, slice);

						if (convertedValue == null) {
							convertedValue = slice;
						}

						convertible = convertible.replace(slice, convertedValue);
					}
				}
			}

			return convertible;
		}

		return convertible;
	}

	static Map<String, String> convertExampleMap(final Environment properties, Map<String, String> tableRow) {
		Map<String, String> convertedMap = new HashMap<>();

		for (Map.Entry<String, String> entry : tableRow.entrySet()) {
			String originalValue = entry.getValue();
			String convertedValue = convertParameterIntoValue(properties, originalValue);

			if (convertedValue == null) {
				convertedValue = originalValue;
			}

			convertedMap.put(entry.getKey(), convertedValue);
		}

		return convertedMap;
	}
}