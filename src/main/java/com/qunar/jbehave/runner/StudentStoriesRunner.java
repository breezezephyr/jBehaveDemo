package com.qunar.jbehave.runner;

import com.qunar.jbehave.basic.StudentStepsZh;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Created with IntelliJ IDEA. Author: xiappeng.cai Date: 14-11-23 Time: 下午5:53
 */
@RunWith(AnnotatedEmbedderRunner.class)
@Configure(keywords = StudentStoriesRunner.MyLocalKeywords.class, storyParser = StudentStoriesRunner.MyStoryParser.class, stepCollector = StudentStoriesRunner.MyStoryCollector.class, storyControls = StudentStoriesRunner.MyStoryControls.class, storyReporterBuilder = StudentStoriesRunner.MyReportBuilder.class, parameterConverters = { StudentStoriesRunner.MyDateConverter.class })
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@UsingSteps(instances = { StudentStepsZh.class })
public class StudentStoriesRunner implements Embeddable {

    private Embedder embedder;

    public void useEmbedder(Embedder embedder) {
        this.embedder = embedder;
    }

    @Test
    public void run() {
        embedder.runStoriesAsPaths(new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("student/student_zh.story"), asList("")));
    }

    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }

    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(org.jbehave.core.reporters.Format.HTML, org.jbehave.core.reporters.Format.CONSOLE)
                    .withDefaultFormats();
        }
    }

    public static class MyLocalKeywords extends LocalizedKeywords {
        public MyLocalKeywords() {
            super(Locale.TAIWAN);
        }
    }

    public static class MyStoryParser extends RegexStoryParser {
        public MyStoryParser() {
            super(new LocalizedKeywords(Locale.TAIWAN));
        }
    }

    public static class MyStoryCollector extends MarkUnmatchedStepsAsPending {
        public MyStoryCollector() {
            super(new LocalizedKeywords(Locale.TAIWAN));
        }
    }

    public static class MyDateConverter extends ParameterConverters.DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }
}
