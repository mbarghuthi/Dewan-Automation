package com.automation.jbehave;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.steps.ParameterConverters;
import org.springframework.core.env.Environment;

import java.lang.reflect.Type;

public class PropertyParameterConverter implements ParameterConverters.ParameterConverter {

    private static final Logger log = Logger.getLogger(PropertyParameterConverter.class);

    private String propertyIndicatorPrefix;
    private Environment properties;

    public PropertyParameterConverter(Environment properties) {
        this.propertyIndicatorPrefix = properties.getProperty(
                "jbehave.converters.property_indicator_prefix", "p:").trim();
        this.properties = properties;
    }

    public boolean accept(Type type) {
        return type instanceof Class<?> && String.class.isAssignableFrom((Class<?>) type);
    }

    public Object convertValue(String value, Type type) {
        if (StringUtils.isBlank(value) || !value.startsWith(propertyIndicatorPrefix)) {
            return value;
        }
        String convertedValue = properties.getProperty(value.substring(propertyIndicatorPrefix.length()));
        log.info("Parameter converted:[" + value + "] >> [" + convertedValue + "]");

        return convertedValue;
    }
}