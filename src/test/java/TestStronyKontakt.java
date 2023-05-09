import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStronyKontakt {

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
    @Description("7.Proba wyslania wiadomosci")
    public void attemptSendMessage(){
        chromeDriver.findElement(Constants.CONTACT_LOCATOR).click();
        chromeDriver.findElement(Constants.CONTACT_NAME_LAST_NAME).sendKeys("filop,Ciolczyk");
        chromeDriver.findElement(Constants.CONTACT_YOUR_EMAIL).sendKeys("flipaflap@gmail.com");
        chromeDriver.findElement(Constants.CONTACT_TOPIC).sendKeys("test");
        chromeDriver.findElement(Constants.CONTACT_MESSAGE).sendKeys("wykonuje test");
        chromeDriver.findElement(Constants.INPUT_SUBMIT).click();
        WebElement responseOutPut = chromeDriver.findElement(Constants.RESPONSE_OUTPUT);

        Assertions.assertNotNull(responseOutPut);
    }
}
