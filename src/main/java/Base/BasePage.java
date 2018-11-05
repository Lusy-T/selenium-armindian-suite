package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;
import java.util.NoSuchElementException;

import static Base.DriverHelper.getDriver;

public abstract class BasePage <T extends LoadableComponent<T>> extends LoadableComponent<T>{
    protected WebDriver driver;

    public BasePage()
    {
        this.driver = DriverHelper.getDriver();
    }

    @Override
    protected void load() {
        // yet forgotten :)
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().equals(getURL());
    }

//    public BasePage()
//    {
//        this.driver.get("https://github.com/login");
//    }

    public abstract String getURL();

    public void type(WebElement element, String text)
    {
        System.out.println("Typing into element" + element.toString());
        element.sendKeys(text);
    }

    public void type(By location, String text)
    {
        type(find(location), text);
    }

    public void type(String cssSelector, String text)
    {
        type(By.cssSelector(cssSelector), text);
    }

    public WebElement find(By location)
    {
        return driver.findElement(location);
    }

    public List<WebElement> findelements(By location)
    {
        return driver.findElements(location);
    }

    public void click(WebElement element)
    {
        System.out.println("Clicking on element with location" + element.toString());
        element.click();
    }

    public void click(By location)
    {
        click(find(location));
    }

    public boolean isDisplayed(By location )
    {
        try
        {
            return find(location).isDisplayed();
        }catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try
        {
            return element.isDisplayed();
        }catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
