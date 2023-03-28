import org.openqa.selenium.By;

public class Constants {
    static final String URL_PATH = "http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/";

    // identyfikatory
     static final By MOJE_KONTO_LOCATOR = By.id("menu-item-125");
     static final By BUTTON_LOGIN_LOCATOR = By.cssSelector("button[name='login']");
     static final By BUUTON_SUBMIT = By.className("ur-submit-button");
     static final By SEARCH_FIELD_LOCTAOR = By.id("woocommerce-product-search-field-0");
     static final By LOGIN_LOCATOR = By.id("username");
     static final By PASSWORD_LACOTAR = By.cssSelector("#password");
     static final By ERROR_LOCALOR = By.className("woocommerce-error");
     static final By REGISTER_LOCATOR = By.id("menu-item-146");
     static final By USER_LOGIN_LOCATOR = By.id("user_login");
     static final By USER_EMAIL = By.id("user_email");
     static final By USER_PASS = By.id("user_pass");
     static final By USER_CONFIRM_PASSWORD = By.id("user_confirm_password");
     static final By SUBMIT_MESSAGE = By.id("ur-submit-message-node");
     static final By LOGO_LOCATOR = By.className("site-title");
     static final By SEACH_FIELD_LOCATOR = By.id("woocommerce-product-search-field-0");
     static final By CONTACT_LOCATOR = By.id("menu-item-132");

     static final By MAIN_PAGE = By.linkText("Strona główna");

    // other
     static final String ERROR_MESSAGE_NO_USER = "Błąd: Nazwa użytkownika jest wymagana.";
     static final String ERROR_MESSAGE_NO_PASSWORD = "Błąd: pole hasła jest puste.";
     static final String SHOP_NAME = "Softie Metal Shop";
     static final String CONTACT = "kontakt";
     static final String  MY_ACCOUNT = "moje-konto";

     static final String SUCCESSFULLY_MESSAGE = "User successfully registered.";

    // timeouts
     static final long TIMEOUT_10_S = 10;
}
