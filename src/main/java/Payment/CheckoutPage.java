package Payment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
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

    public void summaryProceed() {
        WebElement element = driver.findElement(summaryProceed);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);
    }

    public void addressProceed() {
        WebElement element = driver.findElement(addressProceed);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);
    }

    public void shippingProceed() {
        WebElement element = driver.findElement(shippingProceed);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);
    }

    public void proceedToCheckout() {
        WebElement element = driver.findElement(proceedToCheckout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);
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

}