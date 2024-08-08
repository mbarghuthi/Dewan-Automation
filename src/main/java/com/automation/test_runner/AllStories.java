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
	private static final String STORY_NAME_PATTERN_UOP= "*UOP*";
	private static final String STORY_NAME_PATTERN_SCC= "*SCC*";
	private static final String STORY_NAME_PATTERN_JIC = "*JIC*";


	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
//				String.format("stories/**/%s.story", STORY_NAME.trim()), "");

// to specify running single story / scenario
//				String.format("stories/TC_007_UOP.story", STORY_NAME.trim()), "");

//Run a only for single test scenario
				String.format("stories/TC_001_UOP_PRECONDITION.story", STORY_NAME.trim()), "");

//Run a only UOP stories
//				String.format("stories/**/%s.story", STORY_NAME_PATTERN_UOP.trim()), "");

//Run a only UOP stories
//		String.format("stories/**/%s.story", STORY_NAME_PATTERN_SCC.trim()), "");

//Run a only UOP stories
//		String.format("stories/**/%s.story", STORY_NAME_PATTERN_JIC.trim()), "");
	}


	private static final String SPECIFIC_STORY = "stories/TC_005_UOP.story";
	private static final int RUN_COUNT = 3;

// For running the story multiple times
//	public List<String> storyPaths() {
//		List<String> paths = new ArrayList<>();
//		for (int i = 0; i < RUN_COUNT; i++) {
//			paths.add(SPECIFIC_STORY);
//		}
//		return paths;
//	}
}


