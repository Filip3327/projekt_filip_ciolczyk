import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestLogowania {

    static WebDriver chromeDriver;
    private static final String URL_PATH = "http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/";

    @BeforeAll
    static void prepareDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(URL_PATH);
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
    @Test
    public void emptyLogin() {
//        chromeDriver.findElements()
        List<WebElement> elements = chromeDriver.findElements(By.id("woocommerce-product-search-field-0"));
        System.out.println("Test done!!!");
    }

}
