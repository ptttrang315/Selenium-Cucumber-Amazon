package com.trangptt.POM;

import com.trangptt.library.WebUI;

import java.util.Map;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;
public class ProductSearchPage {
    public static void selectSortBy(String value) throws Exception {
        WebUI.verifyElementPresent(findTestObject("Amazon.ProductSearch.Sort By.Dropdown"));
        WebUI.click(findTestObject("Amazon.ProductSearch.Sort By.Dropdown"));
        WebUI.click(findTestObject("Amazon.ProductSearch.Sort By.Option", Map.of("value", value)));
    }

    public static void addToCartByIndex(String index) throws Exception {
        WebUI.click(findTestObject("Amazon.ProductSearch.Add to Cart.By Index", Map.of("index", index)));
    }

    public static void hasQuantityToRemove(String index) throws Exception {
        WebUI.verifyElementVisible(findTestObject("Amazon.ProductSearch.Remove from Cart.By Index", Map.of("index", index)));
    }

    public static void gotoCart() throws Exception {
        WebUI.click(findTestObject("Amazon.ProductSearch.Go to Cart"));
    }
}
