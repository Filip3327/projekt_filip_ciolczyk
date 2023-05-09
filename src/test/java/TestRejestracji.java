import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestRejestracji {

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
    @Test
    @Description("3. Poprawna rejestracja")
    public void succefullUserRegistration(){
        long timestamp = System.currentTimeMillis();
       chromeDriver.findElement(Constants.REGISTER_LOCATOR).click();
       chromeDriver.findElement(Constants.USER_LOGIN_LOCATOR).sendKeys(timestamp + "flip4flap12345");
       chromeDriver.findElement(Constants.USER_EMAIL).sendKeys(timestamp + "flip45flap@gmail.com");
       chromeDriver.findElement(Constants.USER_PASS).sendKeys(timestamp + "Test412345?");
       chromeDriver.findElement(Constants.USER_CONFIRM_PASSWORD).sendKeys(timestamp + "Test412345?");
       chromeDriver.findElement(Constants.BUTTON_SUBMIT).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(Constants.TIMEOUT_10_S));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Constants.SUBMIT_MESSAGE));

       Assertions.assertEquals(Constants.SUCCESSFULLY_MESSAGE, chromeDriver.findElement(Constants.SUBMIT_MESSAGE).getText());





    }
}
