package Infrastructure.TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import java.net.MalformedURLException;

public class AnyTest {

    public static WebDriver driver;


    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "..\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void afterSuite() {
            driver.close();
            driver.quit();
    }
}
