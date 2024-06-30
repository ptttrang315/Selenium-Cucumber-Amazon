package com.trangptt.POM;

import com.trangptt.library.WebUI;

import java.util.Map;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;

public class CartPage {

    public static void selectQuantity(String index, String count) throws Exception {
        WebUI.verifyElementVisible(findTestObject("Amazon.Cart.Quantity.Dropdown By Index", Map.of("index", index)));
        WebUI.click(findTestObject("Amazon.Cart.Quantity.Dropdown By Index", Map.of("index", index)));
        WebUI.click(findTestObject("Amazon.Cart.Quantity.Select Quantity", Map.of("count", count)));
        WebUI.delay(2);
    }

    public static void deleteItemByIndex(String index) throws Exception {
        WebUI.click(findTestObject("Amazon.Cart.Delete Item.By Index", Map.of("index", index)));
    }

}
