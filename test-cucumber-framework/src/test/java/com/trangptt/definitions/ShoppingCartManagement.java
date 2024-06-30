package com.trangptt.definitions;

import com.trangptt.POM.CartPage;
import com.trangptt.POM.ProductDetailsPage;
import com.trangptt.POM.ProductSearchPage;
import com.trangptt.POM.TodaysDealsPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.trangptt.library.WebUI;
import com.trangptt.library.configuration.ConfigurationManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.trangptt.POM.HomePage;

import java.util.Map;

public class ShoppingCartManagement {
    private Scenario currentScenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.currentScenario = scenario;
    }

    @Given("I go to amazon.com")
    public void iGoToAmazonCom() {
        WebUI.openBrowser(ConfigurationManager.getInstance().getValue("basedUrl"));
    }

    @And("I input Captcha manually if required with timeout {string} seconds")
    public void iInputCaptchaManuallyIfRequiredWithTimeoutSeconds(String arg0) throws Exception {
        HomePage.solveCaptchaChallenge(Integer.parseInt(arg0));
    }

    @When("I click on menu {string}")
    public void iClickOnMenu(String arg0) throws Exception {
        HomePage.clickOnMenu(arg0);
    }

    @And("I sort the items by {string}")
    public void iSortTheItemsBy(String arg0) throws Exception {
        ProductSearchPage.selectSortBy(arg0);
    }

    @And("I select filter Discount {string}")
    public void iSelectFilterDiscount(String arg0) throws Exception {
        TodaysDealsPage.selectFilter(arg0);
        TodaysDealsPage.seeMoreFilter("Department");
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
        for (int i = 0; i < Integer.parseInt(arg0); i++) {
            ProductSearchPage.addToCartByIndex("1");
            ProductSearchPage.hasQuantityToRemove("1");
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

    @Then("I should see {string} of items in the cart")
    public void iShouldSeeOfItemsInTheCart(String arg0) {

    }

    @Then("I should see the price for {string} items in the cart")
    public void iShouldSeeThePriceForItemsInTheCart(String arg0) throws Exception {
        Map<String, String> details = CartPage.verifySubtotal(arg0, this.currentScenario);
        this.currentScenario.log("Subtotal (" + details.get("quantity") + " items): $" + details.get("price"));
    }

    @And("I click on {string} on the cart page")
    public void iClickOnOnTheCartPage(String arg0) throws Exception {
        CartPage.clickOnButton(arg0);
    }
}
