package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CrmGeekbrains_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //указание нахождения портативной версии браузера
        ChromeOptions chromeOptions = new ChromeOptions(); //создаём переменную chromeOptions
        chromeOptions.setBinary("F:\\Portable\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe"); //указываем путь к файлу запуска портативной версии браузера
        //chromeOptions.addArguments("--headless"); //добавление аргументов запуска браузера
        //chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://google.com/bot.html)"); //запуск браузера в виде поискового бота google
        WebDriver driver = new ChromeDriver(chromeOptions); //создаём driver с указанием принимать значения из chromeOptions
        driver.get("https://crm.geekbrains.space");
        Thread.sleep(5000);
    }
}
