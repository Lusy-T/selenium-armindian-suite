import org.testng.annotations.AfterMethod;

import static Base.DriverHelper.getDriver;
import static Base.DriverHelper.quitDriver;

public class SeleniumBase {
    @AfterMethod
    public void tearDown() {

        quitDriver();
    }


    public String getURL() {
        return null;
    }
}
