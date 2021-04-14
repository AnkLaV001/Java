package Lesson6_Anna;

import com.fasterxml.jackson.databind.ObjectMapper;
import Lesson6_Anna.Period;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static final String KEY = "CGJzusnlRQDntWXv4eJcnZ772u3NXdbl";
    private static final String PROTOCOL = "http";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECASTS_ENDPOINT = "forecasts";
    private static final String API_VERSION_1 = "v1";
    private static final String DAILY = "daily";
    private static final String AMOUNT_DAYS = "5day";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static void getWeather(Period period, String selectedCity) throws IOException {
        String cityKey = findCity(selectedCity);
        if (period == Lesson6_Anna.Period.FIVE_DAYS) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(HOST)
                    .addPathSegment(FORECASTS_ENDPOINT)
                    .addPathSegment(API_VERSION_1)
                    .addPathSegment(DAILY)
                    .addPathSegment(AMOUNT_DAYS)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();

            JsonForecast jsonForecast = objectMapper
                    .readerFor(JsonForecast.class)
                    .readValue(responseString);
            System.out.println(responseString);
            System.out.println(jsonForecast.HeadlineObject.getEffectiveDate());
        }
    }


    public static String findCity(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION_1)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter("apikey", KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

        return cityKey;
    }


    public static void main(String[] args) throws IOException {
        getWeather(Period.FIVE_DAYS, "Saint Petersburg");
    }
}
