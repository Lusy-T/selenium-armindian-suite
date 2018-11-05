import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultipleWindowPageTest extends SeleniumBase{

    @Test
    public void multipleWindowClick()
    {
        MultipleWindowPage multipleWindowPage = new MultipleWindowPage();

        multipleWindowPage.clickOnClickHere();
        multipleWindowPage.changeTab(1);

        assertEquals(multipleWindowPage.getNewTabText(), "New Window", "New Tab was not open");
        assertTrue(multipleWindowPage.getCurrentUrl().contains("windows/new"), "New tab url is not correct");
    }

}
