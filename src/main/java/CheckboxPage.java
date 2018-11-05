import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxPage extends BasePage {

    @FindBys({
            @FindBy(css = "input[type='checkbox']")
                    })
    private List<WebElement> chekboxes;

        @Override
    public String getURL() {
        return "https://the-internet.herokuapp.com/checkboxes";
    }

    public CheckboxPage()
    {
        super();
        PageFactory.initElements(driver, this);
        driver.get(getURL());
    }

    public boolean isCheckboxChecked(int index)
    {
        String attribute = chekboxes.get(index).getAttribute("checked");
        if (attribute !=null)
        {
            return Boolean.valueOf(attribute);
        }
            else
        {
            return false;
        }
    }

    public boolean isCheckBoxCheckedWithSelected(int index)
    {
        return chekboxes.get(index).isSelected();
    }

    public void clickCheckbox(int index)
    {
        click(chekboxes.get(index));
    }

    public void isCheckboxChecked(String text)
    {
        for (WebElement checkbox:chekboxes)
        {
            if(checkbox.getText().equals(text))
            {
                click(checkbox);
                break;
            }
        }

    }
}
