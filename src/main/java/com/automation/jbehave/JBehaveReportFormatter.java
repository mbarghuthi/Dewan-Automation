package com.automation.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.reporters.Format;

import com.automation.configuration.AbstractStoryConfiguration;
import com.automation.jbehave.format.CustomConfigurationFormat;

public abstract class JBehaveReportFormatter extends AbstractStoryConfiguration {

    public JBehaveReportFormatter() {
    }

    public Configuration configuration() {
        return super.configuration();
    }

    @Override
    protected Format[] storyFormat() {
        return new Format[]{Format.IDE_CONSOLE, Format.XML, new CustomConfigurationFormat(this.getContextInstance().getEnvironment())};
    }
}