import org.testng.annotations.AfterMethod;

import static Base.DriverHelper.getDriver;

public class SeleniumBase {
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    public String getURL() {
        return null;
    }
}
