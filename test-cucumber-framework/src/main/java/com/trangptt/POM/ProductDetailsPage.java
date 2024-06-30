package com.trangptt.POM;

import com.trangptt.library.WebUI;

import java.util.Map;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;
public class ProductDetailsPage {
    public static boolean hasSizeOptions() throws Exception {
        return WebUI.isElementPresent(findTestObject("Amazon.ProductDetails.Size.Dropdown"));
    }

    public static void randomSelectAvailableSize() throws Exception {
        WebUI.click(findTestObject("Amazon.ProductDetails.Size.Dropdown"));
        WebUI.findWebElements(findTestObject("Amazon.ProductDetails.Size.OptionAvailable")).get(0).click();
    }

    public static void selectQuantity(String count) throws Exception {
        WebUI.verifyElementVisible(findTestObject("Amazon.ProductDetails.Quantity.Dropdown"));
        WebUI.click(findTestObject("Amazon.ProductDetails.Quantity.Dropdown"));
        WebUI.verifyElementVisible(findTestObject("Amazon.ProductDetails.Quantity.Select Quantity", Map.of("count", count)));
        WebUI.click(findTestObject("Amazon.ProductDetails.Quantity.Select Quantity", Map.of("count", count)));
    }

    public static void addProductToCart() throws Exception {
        WebUI.click(findTestObject("Amazon.ProductDetails.Add to Cart"));
    }

}
