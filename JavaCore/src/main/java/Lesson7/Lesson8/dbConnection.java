package Lesson7.Lesson8;

import Lesson7.Main;
import Lesson7.WeatherJson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbConnection {
    public static void main(String[] args) {

    }
    private static final String DB_NAME = "weather.db";
    String insertWeather = "insert  into weather (city, localdate, temperature, weather_text) values (?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean saveWeatherData(WeatherJson weatherJson) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, .getCity());
            saveWeather.setString(2, weatherJson.getLocalDate());
            saveWeather.setDouble(3, weatherJson.getFactObject().getTemp());
            saveWeather.setString(4, weatherJson.getFactObject().getCondition());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    //TODO: Реализовать метод для считывания данных о погоде
    //public List<Weather> getSavedWeatherData() {
    //    //statement.executeQuery(select.....)
    //}
}
