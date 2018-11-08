package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoverPage extends BasePage {
    @Override
    public String getURL() {
        return "https://the-internet.herokuapp.com/hovers";
    }

    @FindBys({
            @FindBy(css= "figure")})
    private List<WebElement> figureElements;

    @FindBy(css= ".figcaption")
    private WebElement figcaptionElement;

    public HoverPage()
    {
        super();
     //   PageFactory.initElements(driver, this);
        driver.get(getURL());
    }

    public void HoverElement()
    {
        getActions().moveToElement(figureElements.get(0));
    }

    public boolean isFooterDisplayed()
    {
        return isDisplayed(figcaptionElement);
    }
}
