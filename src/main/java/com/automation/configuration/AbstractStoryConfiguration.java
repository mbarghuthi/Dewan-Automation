package com.automation.configuration;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.springframework.context.ApplicationContext;

import com.automation.jbehave.ConsoleLogger;
import com.automation.jbehave.PropertyExamplesTableConverter;
import com.automation.jbehave.PropertyParameterConverter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStoryConfiguration extends JUnitStories {

    private ApplicationContext context;

    protected AbstractStoryConfiguration() {
        context = getAnnotatedApplicationContext();

        Embedder embedder = configuredEmbedder();
        String DEFAULT_STORY_TIMEOUT_SECS = "7200";
        embedder.embedderControls()
        		.doIgnoreFailureInStories(true)
        		// added by me 
		        //.doIgnoreFailureInStories(true)
        		.doIgnoreFailureInStories(true)
                .useStoryTimeouts(DEFAULT_STORY_TIMEOUT_SECS)
                .doFailOnStoryTimeout(false)
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInView(false)
                .doVerboseFailures(true);
        
		        /*.doBatch(false)
		 		.doGenerateViewAfterStories(true)
		 		.doIgnoreFailureInStories(false)
		 		.doIgnoreFailureInView(false)
		 		.doSkip(false)
		 		.doVerboseFailures(false)
		 		.doVerboseFiltering(false)
		 		.useStoryTimeoutInSecs(300)
		 		.useThreads(1)*/
    }

    @Override
    public Configuration configuration() {
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
        		.withFormats(storyFormat())
                .withFailureTraceCompression(true)
                .withReporters(getReporters())
                // added by me 
                //.withFailureTrace(true)
                //.withFailureTraceCompression(true)
                .withFailureTrace(true)
                .withFailureTraceCompression(true);


        return new MostUsefulConfiguration()
        		.useStoryReporterBuilder(reporterBuilder)
                .useStoryControls(new StoryControls()
                .doResetStateBeforeScenario(true))
                .useParameterControls(new ParameterControls()
                .useDelimiterNamedParameters(true))
                .useParameterConverters(getConverters());
        

		/*		// configuration.doDryRun(false); "no dry run" is implicit by using
				// default StoryControls
		 
				// configuration.useDefaultStoryReporter(new ConsoleOutput());
				// deprecated -- rather use StoryReportBuilder
		 
				.useFailureStrategy(new RethrowingFailure())
				.useKeywords(new LocalizedKeywords(Locale.ENGLISH))
				.usePathCalculator(new AbsolutePathCalculator())
				.useParameterControls(new ParameterControls())
				.useParameterConverters(new ParameterConverters())
				.useParanamer(new NullParanamer())
				.usePendingStepStrategy(new PassingUponPendingStep())
				.useStepCollector(new MarkUnmatchedStepsAsPending())
				.useStepdocReporter(new PrintStreamStepdocReporter())
				.useStepFinder(new StepFinder())
				.useStepMonitor(new SilentStepMonitor())
				.useStepPatternParser(new RegexPrefixCapturingPatternParser())
				.useStoryControls(new StoryControls())
				.useStoryLoader(new LoadFromClasspath())
				.useStoryParser(new RegexStoryParser(configuration.keywords()))
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(new StoryReporterBuilder())
				.useViewGenerator(new FreemarkerViewGenerator())
				.useParameterControls(new ParameterControls().useNameDelimiterLeft("[").useNameDelimiterRight("]"))*/
		        
        
    }

    private ParameterConverters getConverters() {
        List<ParameterConverters.ParameterConverter> converters = new ArrayList<>();
        converters.add(new PropertyParameterConverter(context.getEnvironment()));
        converters.add(new PropertyExamplesTableConverter(context.getEnvironment()));
        return new ParameterConverters().addConverters(converters);
    }

    private StoryReporter[] getReporters() {
        WebDriverProvider webDriverProvider = context.getBean(WebDriverProvider.class);
        return new StoryReporter[]{new ConsoleLogger(webDriverProvider)};
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), context);
    }

    protected Format[] storyFormat() {
       return new Format[]{Format.IDE_CONSOLE, Format.XML, Format.HTML};
    }

    protected ApplicationContext getContextInstance() {
        if (context == null) {
            this.context = getAnnotatedApplicationContext();
        }
        return context;
    }

    public abstract ApplicationContext getAnnotatedApplicationContext();
}