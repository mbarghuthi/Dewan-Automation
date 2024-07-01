package com.automation.jbehave;

import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.springframework.core.env.Environment;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyExamplesTableConverter extends ExamplesTableConverter {

    private String propertyIndicatorPrefix;
    private Environment properties;

    public PropertyExamplesTableConverter(Environment properties) {
        this.propertyIndicatorPrefix = properties.getProperty(
                "jbehave.converters.property_indicator_prefix", "p:");
        this.properties = properties;
    }

    /**
     * Search for property indicator pattern (defaults to "p:") and replace with actual value
     * obtained from the properties file
     */
    @Override
    public Object convertValue(String value, Type type) {

        String patternString = this.propertyIndicatorPrefix + "[\\w.]+";
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            String propertyValue = properties.getProperty(
                    matcher.group().substring(propertyIndicatorPrefix.length()));

            value = value.replaceAll(matcher.group(), propertyValue);

        }
        return super.convertValue(value, type);
    }
}