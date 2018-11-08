import Base.DriverHelper;
import org.testng.annotations.AfterMethod;



public class SeleniumBase {
    @AfterMethod
    public void tearDown() {

        DriverHelper.get().quitDriver();
    }


    public String getURL() {
        return null;
    }
}
