package com.qunar.jbehave.runner;

import static java.util.Arrays.asList;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@Configure()
@UsingSpring(resources = { "configuration.xml", "my_steps.xml" })
public class SpringAnnotatedStories extends InjectableEmbedder {

    private Logger logger = LoggerFactory.getLogger(SpringAnnotatedStories.class);
    @Test
    @Override
    public void run() throws Throwable {
        List<String> paths = new StoryFinder().findPaths(
                CodeLocations.codeLocationFromClass(this.getClass()).getFile(), asList("onpay/**.story"), null);
        logger.info("found these stories to run {}", paths);
        injectedEmbedder().runStoriesAsPaths(paths);
    }

}
