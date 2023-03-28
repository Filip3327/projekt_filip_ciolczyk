import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestLogowania {

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
    @Description("1. logowania bez podania login")
    public void emptyLogin() {
        WebElement myAccountMenuItem = chromeDriver.findElement(Constants.MOJE_KONTO_LOCATOR);
        myAccountMenuItem.click();
        WebElement inputPassword = chromeDriver.findElement(Constants.PASSWORD_LACOTAR);
        inputPassword.sendKeys("Test2002?");
        WebElement buttonLogin = chromeDriver.findElement(Constants.BUTTON_LOGIN_LOCATOR);
        buttonLogin.click();
        WebElement errorNotification = chromeDriver.findElement(Constants.ERROR_LOCALOR);

        Assertions.assertEquals(Constants.ERROR_MESSAGE_NO_USER, errorNotification.getText());
    }

    @Test
    @Description("2. logawanie bez podania hasła")
    public void emptyPassword() {
        WebElement myAccountMenuItem = chromeDriver.findElement(Constants.MOJE_KONTO_LOCATOR);
        myAccountMenuItem.click();
        WebElement inputPassword = chromeDriver.findElement(Constants.PASSWORD_LACOTAR);
        inputPassword.sendKeys("Test2002?");
        WebElement buttonLogin = chromeDriver.findElement(Constants.BUTTON_LOGIN_LOCATOR);
        buttonLogin.click();
        WebElement errorNotification = chromeDriver.findElement(Constants.ERROR_LOCALOR);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_NO_USER, errorNotification.getText());
    }

}
