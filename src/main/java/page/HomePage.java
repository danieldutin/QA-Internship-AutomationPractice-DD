package page;

import Payment.CheckoutPage;
import ProductListingPage.WomanPage;
import ShoppingCart.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    private WebElement webElement;
    private By signUpButton = By.linkText("Sign in");
    private By womanButton = By.cssSelector("div.col-lg-12 a");
    private By cartButton = By.cssSelector("div.shopping_cart");
    private By popUpClose = By.cssSelector("span.cross");
    private By productOne = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span");
    private By productOneContainer = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div");
    private By productTwo = By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span");
    private By productTwoContainer = By.xpath("//*[@id=\"homefeatured\"]/li[2]/div");
    private By productThree = By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span");
    private By productThreeContainer = By.xpath("//*[@id=\"homefeatured\"]/li[3]/div");
    private By productFour = By.xpath("//*[@id=\"homefeatured\"]/li[4]/div/div[2]/div[2]/a[1]/span");
    private By productFourContainer = By.xpath("//*[@id=\"homefeatured\"]/li[4]/div");
    private By productFive = By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span");
    private By productFiveContainer = By.xpath("//*[@id=\"homefeatured\"]/li[5]/div");
    private By goToCart = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b");
    private By featuredProducts = By.cssSelector("div.row");
    Actions action;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignUpButtonLogIn() {

        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }

    public CreateAccountPage clickSignUpButtonCreate() {

        driver.findElement(signUpButton).click();
        return new CreateAccountPage(driver);
    }

    public WomanPage clickWomanButton() {

        driver.findElement(womanButton).click();
        return new WomanPage(driver);
    }

    public CartPage shoppingCard() {

        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public CheckoutPage clickOnCheckOut() {

        webElement = driver.findElement(goToCart);
        jsExecutor(driver,goToCart);
        driver.findElement(goToCart).click();
        return new CheckoutPage(driver);
    }

    public void addProductsToTheCart() throws InterruptedException {

        By[] products = {productOne, productTwo, productThree, productFour, productFive};
        By[] productContainers = {productOneContainer, productTwoContainer, productThreeContainer, productFourContainer, productFiveContainer};
        action = new Actions(driver);

        for (int i = 0; i < 5; i++) {

            By addToCartButton = products[i];

            jsExecutor(driver, productContainers[i]);
            Thread.sleep(3000);
            action.moveToElement(webElement).moveToElement(driver.findElement(addToCartButton)).click().perform();
            Thread.sleep(3000);
            closePopUp();
        }
    }

    public void clickOnCart() {
        jsExecutor(driver, goToCart);
        driver.findElement(goToCart).click();
    }

    public void closePopUp() {
        action = new Actions(driver);
        jsExecutor(driver, popUpClose);
        action.moveToElement(webElement).click().perform();
    }

    private void jsExecutor(WebDriver driver,By locator){
        webElement = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
        jse.executeScript("arguments[0].click();", webElement);
    }

}
