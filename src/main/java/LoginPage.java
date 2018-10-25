import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

   private By userNameField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signIn = By.name("commit");
    private By errorMessage = By.id("js-flash-container"); // By.cssSelector("#js- flash-container.flash-error");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        driver.get("https://github.com/login");
    }

    public void LoginWith(String userName, String password)
    {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signIn).click();
    }

    public boolean isErrorMessageDisplayed()
    {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
