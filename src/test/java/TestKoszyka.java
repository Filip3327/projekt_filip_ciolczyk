import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestKoszyka {
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

    private static void commonAddToBasket() {
        chromeDriver.findElement(Constants.BASKET_LOCATOR).click();
        Assertions.assertEquals(Constants.EMPTY_BASKET_MESSAGE, chromeDriver.findElement(Constants.CART_EMPTY_LOCATOR).getText() );
        chromeDriver.findElement(Constants.BUTTON_BACK_TO_SHOP).click();
        chromeDriver.findElement(new By.ByXPath("//a[@data-product_id='24']")).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(Constants.TIMEOUT_10_S));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Constants.ADDED_TOO_CART_LOCATOR));
        chromeDriver.findElement(Constants.ADDED_TOO_CART_LOCATOR).click();

        Assertions.assertNotNull(chromeDriver.findElement(By.linkText("Srebrna moneta 5g - UK 1980")));
    }

    @Test
    @Description("8.Dodanie do koszyka")
    public void addToBasket() {
        commonAddToBasket();
    }

    @Test
    @Description("9.Usuniecie z koszyka")
    public void deleteToBasket() {
        commonAddToBasket();
        chromeDriver.findElement(By.className("remove")).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(Constants.TIMEOUT_10_S));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Constants.WOOCOMERCE_MESSAGE_LOCATOR));

        Assertions.assertEquals("Usunięto: „Srebrna moneta 5g - UK 1980”. Cofnij?",
                chromeDriver.findElement(Constants.WOOCOMERCE_MESSAGE_LOCATOR).getText());

    }
}
