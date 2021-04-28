package Payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private WebDriver driver;
    private By proceedToCheckout = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");
    private By checkBox = By.id("cgv");
    private By payByWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private By orderCompleate = By.xpath("//*[@id=\"center_column\"]/div/p/strong");


    public ShoppingCartPage(WebDriver driver) {
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

        return driver.findElement(orderCompleate).getText();
    }
}
