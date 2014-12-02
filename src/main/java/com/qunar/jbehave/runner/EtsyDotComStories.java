package com.qunar.jbehave.runner;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;

public class EtsyDotComStories extends JUnitStories {
    Keywords keywords = new LocalizedKeywords(Locale.TAIWAN);
    Properties properties = new Properties();

    @Override
    public Configuration configuration() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL codeLocation = codeLocationFromClass(this.getClass());
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
        ApplicationContext context = new SpringApplicationContextFactory("my_steps_zh.xml").createApplicationContext();
        return new SpringStepsFactory(configuration(), context);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/" + System.getProperty("storyFilter", "student_zh") + ".story"), null);
    }

}
