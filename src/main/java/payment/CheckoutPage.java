package payment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPage {

    private WebDriver driver;
    private WebElement webElement;
    private By proceedToCheckout = By.cssSelector("div.button-container a");
    private By summaryProceed = By.cssSelector("p.cart_navigation.clearfix a");
    private By addressProceed = By.cssSelector("button.button.btn.btn-default.button-medium span");
    private By shippingProceed = By.cssSelector("button.button.btn.btn-default.standard-checkout.button-medium span");
    private By emailFieldCheckout = By.id("email");
    private By passwordFieldCheckout = By.id("passwd");
    private By submitButtonCheckout = By.id("SubmitLogin");
    private By checkBox = By.id("cgv");
    private By payByWire = By.cssSelector("div.col-md-6 p a.bankwire");
    private By confirmOrder = By.cssSelector("button.button.btn.btn-default.button-medium span");
    private By orderComplete = By.cssSelector("div.box");
    private By itemsCount = By.xpath("//*[@id=\"summary_products_quantity\"]");
    private By tableSummary = By.cssSelector("tbody tr");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {

        driver.findElement(emailFieldCheckout).sendKeys(email);
    }

    public void setPasswordField(String pass) {

        driver.findElement(passwordFieldCheckout).sendKeys(pass);
    }

    public void clickOnSignIn() {

        driver.findElement(submitButtonCheckout).click();
    }

    public void clickOnCheckBox() {

        driver.findElement(checkBox).click();
    }

    public void clickPayByWire() {

        driver.findElement(payByWire).click();
    }

    public void clickConfirm() {

        driver.findElement(confirmOrder).click();
    }

    public String getAlertText() {

        return driver.findElement(orderComplete).getText();
    }

    public String summaryItemsCount(){

        return driver.findElement(itemsCount).getText();

    }

    public int itemsInCheckout(){

        List<WebElement> items = driver.findElements(tableSummary);
        int size = items.size();
        return size;
    }

    public void summaryProceed() {
        webElement = driver.findElement(summaryProceed);
        jsExecutor(driver, summaryProceed);
    }

    public void addressProceed() {
        webElement = driver.findElement(addressProceed);
        jsExecutor(driver,addressProceed);
    }

    public void shippingProceed() {
        webElement = driver.findElement(shippingProceed);
        jsExecutor(driver, shippingProceed);
    }

    public void proceedToCheckout() {
        WebElement element = driver.findElement(proceedToCheckout);
        jsExecutor(driver, proceedToCheckout);
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    private void jsExecutor(WebDriver driver,By locator){
        webElement = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
        jse.executeScript("arguments[0].click();", webElement);
    }

}