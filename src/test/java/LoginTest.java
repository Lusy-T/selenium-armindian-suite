import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test
    public void githubFailedLogin(){
        System.setProperty("webdriver.chrome.driver", "C:\\Lusine\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");

        WebElement loginElement = driver.findElement(By.id("login_field"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement signIn = driver.findElement(By.name("commit"));

        loginElement.sendKeys("mail@mail.am");
        passwordElement.sendKeys("mail@mail.am");
        signIn.click();

        assertTrue(driver.findElement(By.id("js-flash-container")).isDisplayed(), "Error message was not displayed" );
        //

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
