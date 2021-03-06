package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {
    private static String ACCESS_TOKEN = null;
    private static final String BASE_URL = "https://api.taiga.io/api/v1";

    public static JsonObject login(String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"username\":\""+ email +"\",\"password\":\""+ password +"\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        ACCESS_TOKEN = object.get("auth_token").getAsString();
        return  object;
    }

    public static Response post(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert response != null;
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code: " + String.valueOf(response.code()));
        }

        return response;
    }


    public static void delete(String urk, JsonObject jsonObject)
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects/296208")
                .delete(null)
                .addHeader("content-type", "application/json")
               // .addHeader("authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzQ3MDF9:1gUvrF:zjptkwmY9hOcaqG10zMSBdETqeQ")
                .addHeader("authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "99696ce3-d0bf-b5af-83ad-7b75c5cb9a66")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}