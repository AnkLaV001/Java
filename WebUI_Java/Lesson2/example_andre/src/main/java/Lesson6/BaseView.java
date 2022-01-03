package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    WebDriver driver = webDriver();
    WebDriverWait webDriverWait;
    Actions actions;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); //создаём переменную chromeOptions
        chromeOptions.setBinary("F:\\Portable\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe"); //указываем путь к файлу запуска портативной версии браузера
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }
}
