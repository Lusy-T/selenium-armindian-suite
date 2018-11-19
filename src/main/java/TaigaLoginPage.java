import base.BasePage;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static api.Client.getAccessToken;

public class TaigaLoginPage extends BasePage {

    @Override
    public String getURL()
    {
        return "https://tree.taiga.io/login";
    }

    public TaigaLoginPage() {
        super();
        driver.get(getURL());
    }


    public JsonObject APILogin(String email, String password)
    {
        JsonObject jsObject;
        try {
            jsObject =  getAccessToken(email, password);
        }
        catch (IOException ception)
        {
            return null;
        }

        return jsObject;
    }

}
