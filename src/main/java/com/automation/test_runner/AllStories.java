package com.automation.test_runner;

import com.automation.configuration.ProjectConfiguration;
import com.automation.jbehave.JBehaveReportFormatter;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class AllStories extends JBehaveReportFormatter {

	private static final String STORY_NAME = "*";
	private static final String STORY_NAME_PATTERN = "*UOP*";
	private static final String SPECIFIC_STORY = "stories/TC_004_UOP.story";
	private static final int RUN_COUNT = 3;

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
//				String.format("stories/**/%s.story", STORY_NAME.trim()), "");
		// to specify running single story / scenario
				String.format("stories/TC_003_UOP.story", STORY_NAME.trim()), "");
		//Run a only UOP stories
//				String.format("stories/**/%s.story", STORY_NAME_PATTERN.trim()), "");
	}

	// For running the story multiple times
//	public List<String> storyPaths() {
//		List<String> paths = new ArrayList<>();
//		for (int i = 0; i < RUN_COUNT; i++) {
//			paths.add(SPECIFIC_STORY);
//		}
//		return paths;
//	}
}


