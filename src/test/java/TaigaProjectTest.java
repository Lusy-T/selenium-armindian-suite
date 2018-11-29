import api.Client;
import base.TaigaProjectPage;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class TaigaProjectTest extends SeleniumBase
{
    @Test
    public void projectPage(Method method) throws IOException
    {
        Client.login("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");
        String projectName = method.getName() + new Date().getTime();
        JsonObject project = new JsonObject();
        project.addProperty("name", projectName);
        project.addProperty("description", "Test Project via Api Description");
        project.addProperty("creation_template", 1);
        project.addProperty("is_private", false);
        Client.createProject(project);

        TaigaProjectPage taigaProjectPage = new TaigaProjectPage(project);
        //taigaProjectPage.getURL();
    }

}
