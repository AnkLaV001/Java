package Lesson7;

import Lesson7.Lesson8.DbConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        WeatherApi weatherApi = new WeatherApi();
        DbConnection dbConnection = new DbConnection();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        while (true) {
//            System.out.println(dateFormat.format( new Date() ) );
            System.out.println("Введите название города");
            String userInput = scanner.nextLine();
            if ( userInput.equals("выход") ||  userInput.equals("exit")) {
                System.out.println("Спасибо за пользованием программой");
                break;
            }
//            String weatherNow = weatherApi.weatherJson( userInput);
            WeatherJson weatherResponse = objectMapper.readValue(weatherApi.weatherJson(userInput), WeatherJson.class);
//            weatherApi.weatherJson( userInput);
            dbConnection.saveWeatherData(weatherResponse);
            dbConnection.getSavedWeatherData(userInput);

            System.out.println("На данный момент в " + weatherResponse.getGeoObjectObject().getLocalityObject().getName() + " " + weatherResponse.getFactObject().getTemp() + " C и " + weatherResponse.getFactObject().getCondition());
        }
    }
}
