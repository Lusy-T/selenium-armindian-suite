import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;
    @Test

    public void successLogin()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Lusine\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");

        assertTrue(driver.getCurrentUrl().contains("http://google.comm"), "The page has incorrect URL");


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
