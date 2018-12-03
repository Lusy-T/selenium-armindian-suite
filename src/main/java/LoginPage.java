import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //private WebDriver driver;

   private By userNameField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signIn = By.name("commit");
    private By errorMessage = By.id("js-flash-container"); // By.cssSelector("#js- flash-container.flash-error");

    public LoginPage(WebDriver driver)
    {
        super();
       // this.driver = driver;
        driver.get(GetUrl());
    }

    public void LoginWith(String userName, String password)
    {
        type(userNameField,  userName);
        type(passwordField, userName);
        click(signIn);

//        driver.findElement(userNameField).sendKeys(userName);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(signIn).click();
    }

    public boolean isErrorMessageDisplayed()
    {
        return isDisplayed(errorMessage);
    }

    public String GetURL()
    {
        return "https://github.com/login";
    }

    @Override
    public String GetUrl() {
        return "https://github.com/login";
    }
}
