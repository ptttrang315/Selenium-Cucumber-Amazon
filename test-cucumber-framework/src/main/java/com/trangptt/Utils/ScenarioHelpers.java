package com.trangptt.Utils;

import io.cucumber.java.Scenario;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ScenarioHelpers {
    public static void attachScreenshot(String path, Scenario scenario) throws Exception {
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        scenario.attach(fileBytes, "image/png", scenario.getName());
    }

    public static void attachScreenshot(String path, Scenario scenario, String message) throws Exception {
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        scenario.attach(fileBytes, "image/png", message);
    }
}
