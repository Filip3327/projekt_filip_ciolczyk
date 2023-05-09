import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    private static void logIn(String user, String password) {
        WebElement myAccountMenuItem = chromeDriver.findElement(Constants.MOJE_KONTO_LOCATOR);
        myAccountMenuItem.click();
        WebElement inputUsername = chromeDriver.findElement(Constants.LOGIN_LOCATOR);
        inputUsername.sendKeys(user);
        WebElement inputPassword = chromeDriver.findElement(Constants.PASSWORD_LOCATOR);
        inputPassword.sendKeys(password);
        WebElement buttonLogin = chromeDriver.findElement(Constants.BUTTON_LOGIN_LOCATOR);
        buttonLogin.click();

    }

    @Test
    @Description("1. logowania bez podania login")
    public void emptyLogin() {
        logIn("","Test2002?" );
        WebElement errorNotification = chromeDriver.findElement(Constants.ERROR_LOCATOR);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_NO_USER, errorNotification.getText());
    }

    @Test
    @Description("2. logawanie bez podania hasła")
    public void emptyPassword() {
        logIn("filip4440", "");
        WebElement errorNotification = chromeDriver.findElement(Constants.ERROR_LOCATOR);
        Assertions.assertEquals(Constants.ERROR_MESSAGE_NO_PASSWORD, errorNotification.getText());
    }

}
