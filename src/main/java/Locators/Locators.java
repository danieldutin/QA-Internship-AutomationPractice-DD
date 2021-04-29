package Locators;

import org.openqa.selenium.By;

public class Locators {

    //for the HomePage
    public static final By SIGN_UP_BUTTON = By.linkText("Sign in");
    public static final By WOMAN_BUTTON = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    //for the AccountPage
    public static final By WELCOME_MESSAGE = By.id("center_column");
    //for the CreateAccountPage
    public static final By NEW_EMAIL = By.id("email_create");
    public static final By CREATE_BUTTON = By.id("SubmitCreate");
    //for the LoginPage
    public static final By EMAIL_FIELD = By.id("email");
    public static final By PASSWORD_FIELD = By.id("passwd");
    public static final By SUBMIT_BUTTON = By.id("SubmitLogin");
    //for the NewUserPage
    public static final By ACCOUNT_FORM = By.xpath("//*[@id=\"columns\"]/div[1]/span[2]");
    public static final By MR_TITLE = By.id("uniform-id_gender1");
    public static final By MRS_TITLE = By.id("uniform-id_gender2");
    public static final By FIRST_NAME = By.id("customer_firstname");
    public static final By LAST_NAME = By.id("customer_lastname");
    public static final By PASS_WORD = By.id("passwd");
    public static final By DAY_DROP_DOWN = By.id("days");
    public static final By EXACT_DAY = By.xpath("//*[@id=\"days\"]/option[2]");
    public static final By MONTH_DROP_DOWN = By.id("months");
    public static final By EXACT_MONTH = By.xpath("//*[@id=\"months\"]/option[2]");
    public static final By YEAR_DROP_DOWN = By.id("years");
    public static final By EXACT_YEAR = By.xpath("//*[@id=\"years\"]/option[21]");
    public static final By ADDRESS_LINE_ONE = By.id("address1");
    public static final By CITY_INPUT = By.id("city");
    public static final By STATE_DROP_DOWN = By.id("id_state");
    public static final By EXACT_STATE = By.xpath("//*[@id=\"id_state\"]/option[4]");
    public static final By ZIP_CODE = By.id("postcode");
    public static final By MOBILE_P = By.id("phone_mobile");
    public static final By REG_BUTTON = By.id("submitAccount");
    //for the CheckoutPage
    public static final By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    public static final By SUMMARY_PROCEED = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    public static final By ADDRESS_PROCEED = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    public static final By SHIPPING_PROCEED = By.xpath("//*[@id=\"form\"]/p/button/span");
    public static final By EMAIL_FIELD_CHECKOUT = By.id("email");
    public static final By PASSWORD_FIELD_CHECKOUT = By.id("passwd");
    public static final By SUBMIT_BUTTON_CHECKOUT = By.id("SubmitLogin");
    public static final By CHECK_BOX = By.id("cgv");
    public static final By PAY_BY_WIRE = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    public static final By CONFIRM_ORDER = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    public static final By ORDER_COMPLETE = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
    //for the ProductListingPage
    public static final By ADD_TO_CART_BTN = By.xpath("//*[@id=\"add_to_cart\"]/button");
    //for the CartPage
    public static final By CLOSE_POP_UP_BTN = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span");
    public static final By GO_TO_CART = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[2]");
    public static final By PRODUCT_IN_CART = By.xpath("//*[@id=\"product_1_1_0_490141\"]/td[2]/p/a");
    //for the WomanPage
    public static final By SELECT_ITEM_BUTTON = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
}
