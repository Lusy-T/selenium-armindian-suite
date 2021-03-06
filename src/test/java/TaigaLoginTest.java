import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.sql.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class TaigaLoginTest extends SeleniumBase {

    @Test
    public void loginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        login("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");
        TaigaHomePage taigaHomePage = (TaigaHomePage) new TaigaHomePage().get();
        taigaHomePage.clickProjectsIcon();

        assertTrue(taigaHomePage.getCurrentUrl().contains("projects"),
                "URL is not correct");

    }

}
       // JsonObject loginJson =getAccessToken("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");

        //((JavascriptExecutor)driver)
          //      .executeScript("window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");

        //((JavascriptExecutor)driver)
          //      .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");

         //taigaLoginPage = new TaigaLoginPage();

