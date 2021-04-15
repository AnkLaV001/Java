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
            String  userInput = scanner.nextLine();
            if ( userInput.equals("выход") ||  userInput.equals("exit")) {
                System.out.println("Спасибо за пользованием программой");
                break;
            }
//            String weatherNow = weatherApi.weatherJson( userInput);
            WeatherJson weatherResponse = objectMapper.readValue(weatherApi.weatherJson( userInput), WeatherJson.class);
//            weatherApi.weatherJson( userInput);
            System.out.println("На данный момент в " +  userInput + " " + weatherResponse.getFactObject().getTemp() + " C и " + weatherResponse.getFactObject().getCondition());
        }
    }
}
