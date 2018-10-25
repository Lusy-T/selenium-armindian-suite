import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
//            System.setProperty("webdriver.chrome.driver", "C:\\Lusine\\chromedriver.exe");
//    driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void successLogin() {
       driver.get("http://google.com");

        assertTrue(driver.getCurrentUrl().contains("https://www.google.com/"), "The page has incorrect URL");
    }


    @Test
    public void githubFailedLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginWith("a@a.a", "a");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed");

//        driver.get("https://github.com/login");
//
//        WebElement loginElement = driver.findElement(By.id("login_field"));
//        WebElement passwordElement = driver.findElement(By.id("password"));
//        WebElement signIn = driver.findElement(By.name("commit"));
//
//        loginElement.sendKeys("mail@mail.am");
//        passwordElement.sendKeys("mail@mail.am");
//        signIn.click();
//
//        assertTrue(driver.findElement(By.id("js-flash-container")).isDisplayed(), "Error message was not displayed" );
        //


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String getURL() {
        return null;
    }
}
