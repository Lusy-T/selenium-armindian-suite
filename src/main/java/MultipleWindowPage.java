import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowPage extends BasePage {

    @FindBy(css = ".example a']")
    private WebElement clickHereLink;

    @FindBy(css = ".example h3']")
    private WebElement newPageMessage;

     @Override
    public String GetUrl() {
        return "https://the-internet.herokuapp.com/windows";
    }

    public MultipleWindowPage()
    {
        super();
       driver.get(GetUrl());
    }


    public void clickOnClickHere()
    {
        click(clickHereLink);
    }



    public void changeTab(int index)
    {
        Object [] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[1].toString());
    }

    public String getNewTabText()
    {
        return newPageMessage.getText();
    }

    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }
}

