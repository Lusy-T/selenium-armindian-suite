import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {


    @FindBy(id= "column-a")
    private WebElement source;

    @FindBy(id= "column-b")
    private WebElement target;
    //private

    public DragAndDropPage() {
        super();
        PageFactory.initElements(driver, this);
        driver.get(GetUrl());
    }

    @Override
    public String GetUrl() {
        return "https://the-internet.herokuapp.com/drag_and_drop";
    }

    public void dropAndDrag() //(WebElement source, WebElement target)
    {
        getActions().dragAndDrop(source, target).build().perform();
    }

    public String getAElementText()
    {
        return source.getText();
    }

    public String getBElementText()
    {
        return target.getText();
    }

    public void dragAndDropFirstToSecond()
    {
        dropAndDrag();
    }
}
