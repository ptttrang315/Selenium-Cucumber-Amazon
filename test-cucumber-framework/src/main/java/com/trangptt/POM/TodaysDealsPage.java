package com.trangptt.POM;

import com.trangptt.library.WebUI;

import java.util.Map;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;

public class TodaysDealsPage {
    public static void selectDiscountFilter(String value) throws Exception {
        WebUI.verifyElementVisible(findTestObject("Amazon.Today's Deals.Filter.Discount", Map.of("value", value)));
        WebUI.click(findTestObject("Amazon.Today's Deals.Filter.Discount", Map.of("value", value)));
    }
}
