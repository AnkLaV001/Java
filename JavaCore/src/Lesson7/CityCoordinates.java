package Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Utf8;

import java.io.IOException;
import java.util.Scanner;

public class CityCoordinates {
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String tokenCity = "0c7a4d58-ee9d-43d1-beb3-c0b26a2826cf";
    String format = "json";

    public void getCityCoordinates() throws IOException {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while (true){
            System.out.println("Введите название города");
            String city = scanner.nextLine();
            HttpUrl apiUrl = new HttpUrl.Builder()
                    .scheme("https")
                    .host("geocode-maps.yandex.ru")
                    .addPathSegment("1.x/")
                    .addQueryParameter("apikey", tokenCity)
                    .addQueryParameter("geocode", city)
                    .addQueryParameter("format", format)
                    .addQueryParameter("results", "1")
                    .addQueryParameter("bbox", "31.449585,42.122836~-172.018738,78.928302")
                    .build();
//            String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey=" + tokenCity + "&geocode=" + city + "&format=" + format + "&results=1&bbox=31.449585,42.122836~-172.018738,78.928302";
            System.out.println(apiUrl);
            Request requestCity = new Request.Builder()
                    .url(apiUrl)
                    .build();
            Response responseCity = okHttpClient.newCall(requestCity).execute();
            String responseCityString = responseCity.body().string();
//            String cityCoordinates = objectMapper.readTree(responseCityString);
        }

    }

}
