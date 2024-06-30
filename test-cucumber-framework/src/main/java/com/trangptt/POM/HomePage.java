package com.trangptt.POM;

import com.trangptt.library.WebUI;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;

public class HomePage {
    public static void solveCaptchaChallenge(int timeout) throws Exception {
        if (WebUI.isElementPresent(findTestObject("Amazon.Challenge.Captcha Input"))) {
            WebUI.verifyElementPresent(findTestObject("Amazon.HomePage.Button.Navigate Home Logo"), timeout);
            WebUI.click(findTestObject("Amazon.HomePage.Button.Navigate Home Logo"), timeout);
        }
        if (WebUI.isElementPresent(findTestObject("Amazon.HomePage.Button.Dismiss"))) {
            WebUI.click(findTestObject("Amazon.HomePage.Button.Dismiss"));
        }
    }

    public static void backToMainPage() throws Exception {
        WebUI.click(findTestObject("Amazon.HomePage.Button.Navigate Home Logo"));
    }

    public static void clickOnMenu(String name) throws Exception {
        WebUI.verifyElementClickable(findTestObject("Amazon.HomePage.Menu." + name));
        WebUI.click(findTestObject("Amazon.HomePage.Menu." + name));
    }

    public static void searchFor(String keyword) throws Exception {
        WebUI.setText(findTestObject("Amazon.HomePage.Search.Textbox"), keyword);
        WebUI.click(findTestObject("Amazon.HomePage.Search.Button"));
    }
}
