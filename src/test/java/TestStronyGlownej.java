import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStronyGlownej {

    static WebDriver chromeDriver;
    @BeforeAll
    static void prepareDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(Constants.URL_PATH);
    }

    @AfterAll
    static void quitDriver() {
        chromeDriver.quit();
    }

    @BeforeEach
    void cleanCookiesBefore() {
        chromeDriver.manage().deleteAllCookies();
    }
    @AfterEach
    void cleanCookiesAfter() {
        chromeDriver.manage().deleteAllCookies();
    }

    private static void checkLogoAndSearch() {
        Assertions.assertEquals(Constants.SHOP_NAME, chromeDriver.findElement(Constants.LOGO_LOCATOR).getText());
        Assertions.assertNotNull(chromeDriver.findElement(Constants.SEARCH_FIELD_LOCATOR));
    }

    @Test
    @Description("4.1 Check logo and search")
    public void checkLogoAndSearchOnMainPage() {
       checkLogoAndSearch();
    }

    @Test
    @Description("4.2 Check logo")
    public void checkLogoAndSearchOnLoginPage() {
        chromeDriver.findElement(Constants.MOJE_KONTO_LOCATOR).click();
        checkLogoAndSearch();
    }

    @Test
    @Description("5")
    public void checkContactPage() {
        chromeDriver.findElement(Constants.CONTACT_LOCATOR).click();
        Assertions.assertTrue(chromeDriver.getCurrentUrl().contains(Constants.CONTACT));
    }

    @Test
    @Description("6")
    public void checkJumpFromLoginTOMainPage() {
       chromeDriver.findElement(Constants.MOJE_KONTO_LOCATOR).click();
       Assertions.assertTrue(chromeDriver.getCurrentUrl().contains(Constants.MY_ACCOUNT));
       chromeDriver.findElement(Constants.MAIN_PAGE).click();
       Assertions.assertEquals(Constants.URL_PATH, chromeDriver.getCurrentUrl() );
    }
}

