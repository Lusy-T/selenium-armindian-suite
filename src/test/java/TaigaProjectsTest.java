import api.ApiHelper;
import api.Client;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TaigaProjectsTest extends SeleniumBase {

    private JsonObject project;
    private JsonObject issue;

    @BeforeMethod
    public void setUpMethod() throws IOException
    {
        Client.login("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");
        project = ApiHelper.createProject() ;
    }

    @AfterMethod
    public void tearDownMethod()
    {
        if(issue != null)
        {
            ApiHelper.deleteIssue(issue);
        }
        if (project != null)
        {
            ApiHelper.deleteProject(project);
        }
    }

    @Test
    public void projectPage(Method method) throws IOException {
        issue = ApiHelper.createIssue(project.get("id").getAsInt());

        login("lusy_tigr@mail.ru", "lusy_tigr@mail.ru");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);

    }

}