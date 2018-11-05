import Base.CheckboxPage;
import org.testng.annotations.Test;

public class CheckboxesTest extends SeleniumBase
{
    @Test
    public void checkboxes()
    {
        CheckboxPage checkboxPage= new CheckboxPage();
        checkboxPage.isCheckboxChecked(1);
    }
}
