package Lesson7;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherAoi {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        double lat = 59.9386; //широта в градусах
        double lon = 30.3141; //долгота в градусах
        int limit = 5; //срок прогноза
        String token = "92656a0c-ba15-43d0-b4b4-a04d521e1873";
        String apiUrl = "https://api.weather.yandex.ru/v2/forecast?lat=" + lat + "&lon=" + lon + "&limit=" + limit;
        System.out.println(apiUrl);
        Request requestWeather = new Request.Builder()
                .url(apiUrl)
                .addHeader("X-Yandex-API-Key", token)
                .build();

        Response responseBooking = okHttpClient.newCall(requestWeather).execute();
        System.out.println(responseBooking.code());
        System.out.println(responseBooking.headers());
        System.out.println(responseBooking.body().string());
    }


}

//    Второй вариант выполнения ДЗ - доработать свою программу, выводящую погоду, из 6 урока так, чтобы в консоль
//    выводилась информация в читабельном формате на ваше усмотрение - например "Сегодня в Санкт-Петербурге 5 градусов
//    тепла". Главное - распарсить json ответ, достать оттуда нужные данные.