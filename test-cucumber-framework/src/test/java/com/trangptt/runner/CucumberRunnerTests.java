package com.trangptt.runner;

import io.cucumber.tagexpressions.TagExpressionParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

@CucumberOptions( features = "src/test/resources/features",
        glue = { "com.trangptt.definitions" },
        tags = "")

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        String dynamicTags = System.getenv("includes");
        if (dynamicTags != null && !dynamicTags.isEmpty())
            return (Arrays.stream(scenarios).filter(scenario -> TagExpressionParser.parse(dynamicTags).evaluate(((PickleWrapper) scenario[0]).getPickle().getTags())).toList()).toArray(new Object[0][0]);
        else return scenarios;
    }
}