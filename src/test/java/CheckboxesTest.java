import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTest extends SeleniumBase
{
    @Test
    public void checkboxesByIndex()
    {
        CheckboxPage checkboxPage= new CheckboxPage();

        assertFalse(checkboxPage.isCheckboxChecked(0), "First checkbox was checked");
        assertTrue(checkboxPage.isCheckboxChecked(1), "First checkbox was not checked");

        checkboxPage.clickCheckbox(0);
        assertFalse(checkboxPage.isCheckboxChecked(0), "First checkbox was not checked");
        assertTrue(checkboxPage.isCheckboxChecked(1), "First checkbox was not checked");

        checkboxPage.clickCheckbox(1);
        assertFalse(checkboxPage.isCheckboxChecked(0), "First checkbox was not checked");
        assertTrue(checkboxPage.isCheckboxChecked(1), "First checkbox was checked");

        checkboxPage.isCheckboxChecked(1);
    }

//    @Test
//    public void checkboxesByText()
//    {
//        CheckboxPage checkboxPage= new CheckboxPage();
//
//        assertFalse(checkboxPage.isCheckboxChecked("checkbox 1"), "First checkbox was checked");
//        assertTrue(checkboxPage.isCheckboxChecked("checkbox 2"), "First checkbox was not checked");
//
//        checkboxPage.clickCheckbox("checkbox 1");
//        assertFalse(checkboxPage.isCheckboxChecked(0), "First checkbox was not checked");
//        assertTrue(checkboxPage.isCheckboxChecked(1), "First checkbox was not checked");
//
//        checkboxPage.clickCheckbox(1);
//        assertFalse(checkboxPage.isCheckboxChecked(0), "First checkbox was not checked");
//        assertTrue(checkboxPage.isCheckboxChecked(1), "First checkbox was checked");
//
//        checkboxPage.isCheckboxChecked(1);
//    }
}
