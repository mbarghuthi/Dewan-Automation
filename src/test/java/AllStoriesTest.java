import com.automation.configuration.ProjectConfiguration;
import com.automation.jbehave.ConsoleLogger;
import com.automation.jbehave.JBehaveReportFormatter;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AllStoriesTest extends JBehaveReportFormatter {

	private static final String STORY_NAME = "*";
	private static final String STORY_NAME_PATTERN_UOP= "*UOP*";
	private static final String STORY_NAME_PATTERN_JPPMC= "*JPPMC*";
	private static final String STORY_NAME_PATTERN_JIC = "*JIC*";

	public AllStoriesTest() {
		configuredEmbedder().embedderControls()
				.doIgnoreFailureInStories(false)
				.doIgnoreFailureInView(false)
				.doVerboseFailures(true)
				.doFailOnStoryTimeout(true);
	}

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}

	@Override
	public List<String> storyPaths() {
		// -Dstory.filter=*JPPMC* from Maven/Jenkins, defaults to * (all stories)
		String filter = System.getProperty("story.filter", "*");
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
				String.format("stories/**/%s.story", filter.trim()), "");
	}

	@Override
	public void run() throws Throwable {
		// reset failure tracker before every full run
		ConsoleLogger.resetFailures();

		try {
			super.run();
		} catch (Throwable t) {
			throw new RuntimeException("JBehave execution failed", t);
		}

		// Force Maven/JUnit failure if any story/step failed in JBehave
		if (ConsoleLogger.hasFailures()) {
			throw new RuntimeException("JBehave detected failed stories. Failing Maven build.");
		}
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