package com.trangptt.POM;

import com.trangptt.Utils.ScenarioHelpers;
import com.trangptt.library.TakeScreenshot;
import com.trangptt.library.WebUI;
import io.cucumber.java.Scenario;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.trangptt.library.TestObject.ObjectRepository.findTestObject;

public class CartPage {

    public static void selectQuantity(String index, String count) throws Exception {
        WebUI.verifyElementClickable(findTestObject("Amazon.Cart.Quantity.Dropdown By Index", Map.of("index", index)));
        WebUI.delay(2);
        WebUI.click(findTestObject("Amazon.Cart.Quantity.Dropdown By Index", Map.of("index", index)));
        WebUI.verifyElementClickable(findTestObject("Amazon.Cart.Quantity.Select Quantity", Map.of("count", count)));
        WebUI.click(findTestObject("Amazon.Cart.Quantity.Select Quantity", Map.of("count", count)));
    }

    public static void deleteItemByIndex(String index) throws Exception {
        WebUI.click(findTestObject("Amazon.Cart.Delete Item.By Index", Map.of("index", index)));
    }

    public static Map<String, String> verifySubtotal(String quantity, Scenario scenario) throws Exception {
        WebUI.verifyElementTextContains(findTestObject("Amazon.Cart.Subtotals.Active View Form"), String.format("%s items", quantity));
        WebUI.verifyElementTextContains(findTestObject("Amazon.Cart.Subtotals.Gutter View Form"), String.format("%s items", quantity));
        String activeSubtotal = WebUI.getText(findTestObject("Amazon.Cart.Subtotals.Active View Form"));
        String gutterSubtotal = WebUI.getText(findTestObject("Amazon.Cart.Subtotals.Gutter View Form"));
        Map<String, String> activeSubtotalData = extractSubtotalData(activeSubtotal);
        Map<String, String> gutterSubtotalData = extractSubtotalData(gutterSubtotal);
        assert(activeSubtotalData.equals(gutterSubtotalData));
        assert(activeSubtotalData.get("quantity").equals(quantity));
        assert(Double.parseDouble(activeSubtotalData.get("price")) > 0);
        String output = TakeScreenshot.captureFullPageScreenshot(scenario.getName());
        ScenarioHelpers.attachScreenshot(output, scenario);
        return activeSubtotalData;
    }

    public static Map<String, String> extractSubtotalData(String subtotal) {
        Pattern pattern = Pattern.compile("\\((\\d+) items\\): \\$(\\d+(\\.\\d{1,2})?)");
        Matcher matcher = pattern.matcher(subtotal);
        if (matcher.find()) {
            int quantity = Integer.parseInt(matcher.group(1));
            double price = Double.parseDouble(matcher.group(2));
            return Map.of("quantity", String.valueOf(quantity), "price", String.valueOf(price));
        }
        return null;
    }

    public static void clickOnButton(String name) throws Exception {
        WebUI.verifyElementClickable(findTestObject("Amazon.Cart.Button." + name));
        WebUI.click(findTestObject("Amazon.Cart.Button." + name));
    }
}
