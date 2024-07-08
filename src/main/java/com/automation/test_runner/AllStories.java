package com.automation.test_runner;

import com.automation.configuration.ProjectConfiguration;
import com.automation.jbehave.JBehaveReportFormatter;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AllStories extends JBehaveReportFormatter {

	private static final String STORY_NAME = "*";

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
//				String.format("stories/**/%s.story", STORY_NAME.trim()), "");
		// to specify running single story / scenario
				String.format("stories/TC_003.story", STORY_NAME.trim()), "");
	}
}