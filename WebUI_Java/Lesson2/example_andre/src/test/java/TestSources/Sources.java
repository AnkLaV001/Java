package TestSources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sources {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); //создаём переменную chromeOptions
        chromeOptions.setBinary("F:\\Portable\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe"); //указываем путь к файлу запуска портативной версии браузера
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }

    @BeforeAll
    public static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupDriver() throws InterruptedException {
        driver = webDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
