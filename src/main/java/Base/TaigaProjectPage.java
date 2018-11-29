package base;

import com.google.gson.JsonObject;

public class TaigaProjectPage extends BasePage
{
    @Override
    public String getURL()
    {
        return "https://tree.taiga.io/projects/" + project.get("slug").getAsString();
    }
    JsonObject project;
    public TaigaProjectPage(JsonObject project)
    {
        super();
        driver.get(getURL());
        this.project = project;
    }

}
