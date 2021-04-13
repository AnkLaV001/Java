package Lesson7;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        WeatherApi weatherApi = new WeatherApi();
        while (true) {
            System.out.println("Введите название города");
            String city = scanner.nextLine();
            if (city.equals("выход") || city.equals("exit")) {
                System.out.println("Спасибо за пользованием программой");
                break;
            }
            weatherApi.weatherJson(city);
        }
    }
}
