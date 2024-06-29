package com.trangptt.POM;

import com.trangptt.library.WebUI;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;

public class HomePage {
    public static void clickOnMenu(String name) throws Exception {
        WebUI.verifyElementPresent(findTestObject("Amazon.HomePage.Menu." + name), 90);
        if (WebUI.isElementPresent(findTestObject("Amazon.HomePage.Button.Dismiss"))) {
            WebUI.click(findTestObject("Amazon.HomePage.Button.Dismiss"));
        }
        WebUI.click(findTestObject("Amazon.HomePage.Menu." + name), 90);
    }
}
