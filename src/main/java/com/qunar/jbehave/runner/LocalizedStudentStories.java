package com.qunar.jbehave.runner;

import com.qunar.jbehave.basic.StudentStepsZh;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class LocalizedStudentStories extends JUnitStories {
    @Override
    public Configuration configuration() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL codeLocation = codeLocationFromClass(this.getClass());
        Keywords keywords = new LocalizedKeywords(locale());
        Properties properties = new Properties();
        properties.setProperty("encoding", "UTF-8");
        Configuration configuration = new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
                .useStoryParser(new RegexStoryParser(keywords))
                .useStoryLoader(new LoadFromClasspath(classLoader))
                .useDefaultStoryReporter(new ConsoleOutput(keywords))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(codeLocation)
                                .withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName())
                                .withDefaultFormats()
                                .withViewResources(properties)
                                .withFailureTrace(false)
                                .withKeywords(keywords)
                                .withFormats(org.jbehave.core.reporters.Format.CONSOLE,
                                        org.jbehave.core.reporters.Format.HTML));
        return configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), getStudentSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/" + System.getProperty("storyFilter", "student_zh") + ".story"), null);
    }

    protected Locale locale() {
        return Locale.TAIWAN;
    };

    protected static Object getStudentSteps() {
        return new StudentStepsZh();
    };

}