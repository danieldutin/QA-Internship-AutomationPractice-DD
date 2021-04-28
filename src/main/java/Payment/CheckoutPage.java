package Payment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private By proceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private By summaryProceed = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    private By addressProceed = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    private By shippingProceed = By.xpath("//*[@id=\"form\"]/p/button/span");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");
    private By checkBox = By.id("cgv");
    private By payByWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private By orderComplete = By.xpath("//*[@id=\"center_column\"]/div/p/strong");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProceedBtn() {

        driver.findElement(proceedToCheckout).click();
    }

    public void setEmailField(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String pass) {

        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickOnSignIn() {

        driver.findElement(submitButton).click();
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
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
