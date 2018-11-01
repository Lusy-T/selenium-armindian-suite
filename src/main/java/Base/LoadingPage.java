package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadingPage extends BasePage {

    @FindBy(css= "#start button")
    private WebElement startButton;

    @FindBy(css= "#finish h4")
    private WebElement finishText;

    //private By startButton = By.cssSelector("#start button");
    //private By finishText = By.cssSelector("#finish h4");

    public LoadingPage()
    {
        super();
        PageFactory.initElements(driver, this);
        driver.get(getURL());
    }

    @Override
    public String getURL()
    {
        return "http://the-internet.herokuapp.com/dynamic_loading/1";
    }

    public void clickStart()
    {
        click(startButton);
        WaitHelper.getWait().waitForElementToBeVisible(finishText);
    }

    public boolean isFinishTextDisplayed()
    {
        return isDisplayed(finishText);

    }

    public String getFinishText()
    {
      //  return find(finishText).getText();
        return finishText.getText();
    }

    @Override
    public void isLoaded()
    {
        WaitHelper.getWait().waitForElementToBeVisible(startButton);
    }
}
