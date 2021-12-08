package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //указание нахождения портативной версии браузера
        ChromeOptions chromeOptions = new ChromeOptions(); //создаём переменную chromeOptions
        chromeOptions.setBinary("F:\\Portable\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe"); //указываем путь к файлу запуска портативной версии браузера
        WebDriver driver = new ChromeDriver(chromeOptions); //создаём driver с указанием принимать значения из chromeOptions
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.close();

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://ya.ru");

    }
}
