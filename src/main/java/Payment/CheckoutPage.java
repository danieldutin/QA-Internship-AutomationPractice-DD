package Payment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Locators.Locators.*;

public class CheckoutPage {

    private WebDriver driver;
    /*private By proceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private By summaryProceed = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    private By addressProceed = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    private By shippingProceed = By.xpath("//*[@id=\"form\"]/p/button/span");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");
    private By checkBox = By.id("cgv");
    private By payByWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private By orderComplete = By.xpath("//*[@id=\"center_column\"]/div/p/strong");*/


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProceedBtn() {

        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public void setEmailField(String email) {

        driver.findElement(EMAIL_FIELD_CHECKOUT).sendKeys(email);
    }

    public void setPasswordField(String pass) {

        driver.findElement(PASSWORD_FIELD_CHECKOUT).sendKeys(pass);
    }

    public void clickOnSignIn() {

        driver.findElement(SUBMIT_BUTTON_CHECKOUT).click();
    }

    public void clickOnCheckBox() {

        driver.findElement(CHECK_BOX).click();
    }

    public void clickPayByWire() {

        driver.findElement(PAY_BY_WIRE).click();
    }

    public void clickConfirm() {

        driver.findElement(CONFIRM_ORDER).click();
    }

    public String getAlertText() {

        return driver.findElement(ORDER_COMPLETE).getText();
    }

    public void summaryProceed() {
        WebElement element = driver.findElement(SUMMARY_PROCEED);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);

    }

    public void addressProceed() {
        WebElement element = driver.findElement(ADDRESS_PROCEED);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);

    }

    public void shippingProceed() {
        WebElement element = driver.findElement(SHIPPING_PROCEED);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);

    }

    public void proceedToCheckout() {
        WebElement element = driver.findElement(PROCEED_TO_CHECKOUT);
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
