package com.trangptt.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.trangptt.library.TakeScreenshot;
import com.trangptt.library.WebUI;

public class Hooks {
    @Before
    public static void setUp() {
    }

    @After
    public static void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            TakeScreenshot.capturePageScreenshot(scenario.getName());
        }
//        WebUI.closeBrowser();
    }
}