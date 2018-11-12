package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException
    {

        String accessToken = getAccessToken();
        System.out.println(accessToken);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType2 = MediaType.parse("application/json");
        RequestBody body2 = RequestBody.create(mediaType2, "{\"is_private\":false,\"creation_template\":1,\"name\":\"Project 01\",\"description\":\"Description\"}");
        Request request2 = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body2)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzQ3MDF9:1gME7c:wSK9IFBKl3zMFURt2lr0HfKFw6o")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "e4424644-ed27-3eca-3310-8930badf13be")
                .build();

        Response response2 = client.newCall(request2).execute();

        System.out.println("The second is" + response2.body().string());
    }

    public static String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"lusy_tigr@mail.ru\",\"password\":\"lusy_tigr@mail.ru\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "9319cbf4-74ac-0b84-d272-e5e7c7a5462f")
                .build();

        Response response = client.newCall(request).execute();

        String jsonString = response.body().string();
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

        return jsonObject.get("auth_token").getAsString();
    }
}
