import org.openqa.selenium.By;

public class Constants {
    static final String URL_PATH = "http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/";

    // identyfikatory
     static final By MOJE_KONTO_LOCATOR = By.id("menu-item-125");
     static final By BUTTON_LOGIN_LOCATOR = By.cssSelector("button[name='login']");
     static final By SEARCH_FIELD_LOCTAOR = By.id("woocommerce-product-search-field-0");
     static final By PASSWORD_LACOTAR = By.cssSelector("#password");
     static final By ERROR_LOCALOR = By.className("woocommerce-error");

    // error messages
     static final String ERROR_MESSAGE_NO_USER = "Błąd: Nazwa użytkownika jest wymagana.";
}
