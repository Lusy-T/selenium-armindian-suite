import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CheckboxPage extends BasePage {

    @FindBys({
            @FindBy(css = "input[type='checkbox']")
    })
    private List<WebElement> checkboxes;

    public CheckboxPage() {
        super();
        driver.get(GetUrl());
    }

    public String GetUrl() {
        return "http://the-internet.herokuapp.com/checkboxes";
    }


    public boolean isCheckboxChecked(int index) {
        String attribute = checkboxes.get(index).getAttribute("checked");
        if (attribute != null) {
            return Boolean.valueOf(attribute);
        } else {
            return false;
        }
    }

    public boolean isCheckBoxCheckedWithSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        click(checkboxes.get(index));
    }

    public boolean isCheckboxChecked(String text) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(text)) {
                String attribute = checkbox.getAttribute("checked");
                if (attribute != null) {
                    return Boolean.valueOf(attribute);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void clickCheckbox(String text) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(text)) {
                click(checkbox);
                break;
            }
        }
    }
}
