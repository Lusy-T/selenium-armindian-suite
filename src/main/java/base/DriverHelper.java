package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    public  void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driver = null;
        }
    }
}
