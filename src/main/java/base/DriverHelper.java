package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {

    public static DriverHelper get()
    {
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }

    public  WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.Browser", "chrome");

    private static ThreadLocal <WebDriver>driverThread = new ThreadLocal<>();

    public  WebDriver getDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
                    driver = new ChromeDriver();
                    driverThread.set(driver);
                    break;
                case "firefox":
                    System.setProperty("webdriver.gickodriver.driver",
                            "./src/main/resources/drivers/geckodriver-windows-32bit.exe");
                    driver = new FirefoxDriver();
                    driverThread.set(driver);
                    break;
            }
        }

        return driverThread.get();
    }

    public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities)
    {
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(""), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
