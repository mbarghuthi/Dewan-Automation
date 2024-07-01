package com.automation.jbehave.format;

import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.springframework.core.env.Environment;

public class CustomConfigurationFormat extends Format {

    private Environment properties;

    public CustomConfigurationFormat(final Environment properties) {
        super("HTML");
        this.properties = properties;
    }

    @Override
    public StoryReporter createStoryReporter(FilePrintStreamFactory factory,
                                             StoryReporterBuilder storyReporterBuilder) {
        factory.useConfiguration(storyReporterBuilder.fileConfiguration("html"));
        return new PropertyConverter(factory.createPrintStream(), storyReporterBuilder.keywords(), properties).doReportFailureTrace(
                storyReporterBuilder.reportFailureTrace()).doCompressFailureTrace(
                storyReporterBuilder.compressFailureTrace());
    }
}