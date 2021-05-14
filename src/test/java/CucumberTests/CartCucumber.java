package CucumberTests;

import Payment.CheckoutPage;
import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import static org.testng.Assert.assertTrue;

public class CartCucumber extends BaseTests {

    CheckoutPage checkoutPage;

    @Given("User is on the login page of the Automation Practice online store")
    public void user_is_on_the_home_page_of_the_Automation_Practice_online_store() throws Exception {
       homePage = new HomePage(startWebDriver("chrome"));
    }

    @When("User add 5 products to the cart")
    public void when_add_products_to_the_cart() throws Exception {
        homePage.addProductsToTheCart();
    }

    @And("User click on go to checkout")
    public void user_click_on_cart() {
        homePage.clickOnCart();
        checkoutPage = homePage.clickOnCheckOut();
    }

    @Then("All initially added products are available in the checkout summary")
    public void all_initially_added_products_are_available_in_the_cart_summary() {

        assertTrue(checkoutPage.summaryItemsCount().contains("5 Products"));
    }
}
