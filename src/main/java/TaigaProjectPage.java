import base.BasePage;
import com.google.gson.JsonObject;

public class TaigaProjectPage extends BasePage {
    private JsonObject project;
    public TaigaProjectPage(JsonObject project) {
        super();
        this.project =  project;
        driver.get(GetUrl());
    }
    @Override
    public String GetUrl() {
        return "https://tree.taiga.io/project/"
                + project.get("slug").getAsString();
    }
}
