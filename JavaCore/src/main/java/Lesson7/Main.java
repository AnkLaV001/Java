package Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        WeatherApi weatherApi = new WeatherApi();
        while (true) {
            System.out.println("Введите название города");
            String city = scanner.nextLine();
            if (city.equals("выход") || city.equals("exit")) {
                System.out.println("Спасибо за пользованием программой");
                break;
            }
//            String weatherNow = weatherApi.weatherJson(city);
            WeatherJson weatherResponse = objectMapper.readValue(weatherApi.weatherJson(city), WeatherJson.class);
//            weatherApi.weatherJson(city);
            System.out.println("На данный момент в " + city + " "+ weatherResponse.getFactObject().getTemp() + " C и " + weatherResponse.getFactObject().getCondition());
        }
    }
}
