package com.trangptt.definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.trangptt.library.TakeScreenshot;
import com.trangptt.library.WebUI;
import com.trangptt.Utils.ScenarioHelpers;

public class Hooks {
    @Before
    public static void setUp() {
    }

    @AfterStep
    public static void afterStep(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            String output = TakeScreenshot.capturePageScreenshot(scenario.getName());
            ScenarioHelpers.attachScreenshot(output, scenario, "Checkout screenshot of the failed step");
        }
    }

    @After
    public static void tearDown(Scenario scenario) throws Exception {
        WebUI.closeBrowser();
    }
}