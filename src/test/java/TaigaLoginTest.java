import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.Client.getAccessToken;

public class TaigaLoginTest extends SeleniumBase {
    private WebDriver driver = DriverHelper.get().getDriver();
    @Test
    public void LoginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        JsonObject loginJson =getAccessToken("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");

        ((JavascriptExecutor)driver)
                .executeScript("window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");

        ((JavascriptExecutor)driver)
                .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");

         taigaLoginPage = new TaigaLoginPage();

    }

}
