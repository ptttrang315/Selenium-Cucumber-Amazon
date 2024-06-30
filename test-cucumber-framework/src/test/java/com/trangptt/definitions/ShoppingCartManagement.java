package com.trangptt.definitions;

import com.trangptt.POM.CartPage;
import com.trangptt.POM.ProductDetailsPage;
import com.trangptt.POM.ProductSearchPage;
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
        ProductSearchPage.selectSortBy(arg0);
    }

    @And("I select filter Discount {string}")
    public void iSelectFilterDiscount(String arg0) throws Exception {
        TodaysDealsPage.selectFilter(arg0);
        TodaysDealsPage.selectFilter("Clothing, Shoes & Jewelry");
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

    @And("I go back to the main page")
    public void iGoBackToTheMainPage() throws Exception {
        HomePage.backToMainPage();
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) throws Exception {
        HomePage.searchFor(arg0);
    }

    @And("I add {string} of the searched item into the cart")
    public void iAddOfTheSearchedItemIntoTheCart(String arg0) throws Exception {
        for (int i = 1; i <= Integer.parseInt(arg0); i++) {
            ProductSearchPage.addToCartByIndex(String.valueOf(i));
            ProductSearchPage.hasQuantityToRemove(String.valueOf(i));
        }
    }

    @And("I go to my cart")
    public void iGoToMyCart() throws Exception {
        ProductSearchPage.gotoCart();
    }

    @And("I edit the {string} item quantity to {string}")
    public void iEditTheItemQuantityTo(String arg0, String arg1) throws Exception {
        String index = arg0.replaceAll("\\D+", "");
        CartPage.selectQuantity(index, arg1);
    }

    @And("I delete the {string} item")
    public void iDeleteTheItem(String arg0) throws Exception {
        String index = arg0.replaceAll("\\D+", "");
        CartPage.deleteItemByIndex(index);
    }
}
