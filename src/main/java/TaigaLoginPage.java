import base.BasePage;

public class TaigaLoginPage extends BasePage {
    @Override
    public String GetUrl() {
        return "https://tree.taiga.io/login";
    }

    public TaigaLoginPage() {
        super();
        driver.get(GetUrl());
    }
}