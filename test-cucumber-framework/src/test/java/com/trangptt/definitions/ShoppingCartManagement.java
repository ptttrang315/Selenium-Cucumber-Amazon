package com.trangptt.definitions;

import com.trangptt.POM.ProductDetailsPage;
import com.trangptt.POM.TodaysDealsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.trangptt.library.WebUI;
import com.trangptt.library.configuration.ConfigurationManager;
import io.cucumber.java.en.When;
import com.trangptt.POM.HomePage;

public class ShoppingCartManagement {

    @Given("I go to amazon.com")
    public void iGoToAmazonCom() {
        WebUI.openBrowser(ConfigurationManager.getInstance().getValue("basedUrl"));
    }

    @When("I click on {string}")
    public void iClickOn(String arg0) throws Exception {
        HomePage.clickOnMenu(arg0);
    }

    @And("I sort the items by {string}")
    public void iSortTheItemsBy(String arg0) throws Exception {
    }

    @And("I select filter Discount {string}")
    public void iSelectFilterDiscount(String arg0) throws Exception {
        TodaysDealsPage.selectDiscountFilter(arg0);
    }

    @And("I view the deal for the {string} item")
    public void iViewTheDealForTheItem(String arg0) throws Exception {
        String index = arg0.replaceAll("\\D+", "");
        TodaysDealsPage.viewTheDeal(index);
    }

    @And("I add {string} of the item into the cart")
    public void iAddOfTheItemIntoTheCart(String arg0) throws Exception {
        if (ProductDetailsPage.hasSizeOptions()) {
            ProductDetailsPage.randomSelectAvailableSize();
        }
        ProductDetailsPage.selectQuantity(arg0);
        ProductDetailsPage.addProductToCart();
    }
}
