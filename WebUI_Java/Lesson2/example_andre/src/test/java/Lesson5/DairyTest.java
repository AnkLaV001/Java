package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class DairyTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String DIARY_URL = "https://diary.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = webDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DIARY_URL);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void addToQuote() throws InterruptedException {
        login();
        webDriverWait.until(d -> d.findElements(By.xpath("//div[@class='news']//div[@class='item']")).size() > 0);
        List<WebElement> newsList = driver.findElements(By.xpath("//div[@class='news']//div[@class='item']"));
        newsList.stream().filter(f -> f.getText().contains("Новости дневников")).findFirst().get().click();
        webDriverWait.until(d -> d.findElements(By.xpath("//a[.='Дневник']")).size() > 0);
        List<WebElement> diaryList = driver.findElements(By.xpath("//a[.='Дневник']"));
        diaryList.stream().findFirst().get().click();
        webDriverWait.until(d -> d.findElements(By.xpath("//a[@title='В цитатник']")).size() > 0);
        List<WebElement> quoteList = driver.findElements(By.xpath("//a[@title='В цитатник']"));
        quoteList.stream().findFirst().get().click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        assertThat(driver.findElement(By.className("toast-message")), isDisplayed());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='Удалить из цитатника']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        assertThat(driver.findElement(By.className("toast-message")), isDisplayed());
    }

    @Test
    void allDiary () throws InterruptedException {
        login();
         actions.moveToElement(driver.findElement(By.xpath("//li[@class='dropdown']//button[@id='drop-common']")))
                 .click()
                 .build()
                 .perform();
         List<WebElement> menuList = driver.findElements(By.xpath("//div[@class='dropdown-block col-sm-6']//a"));
         menuList.stream().findFirst().get().click();
         webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-header']//h1")));
         assertThat(driver.findElement(By.xpath("//div[@class='page-header']//h1")), isDisplayed());
    }

    void login() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Вход']")));
        driver.findElement(By.xpath("//a[.='Вход']")).click();
        driver.findElement(By.id("loginform-username")).sendKeys("AndrE001");
        driver.findElement(By.id("loginform-password")).sendKeys("E1W6OK9#FK");
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.className("recaptcha-checkbox-border")).click();
        //webDriverWait.until(d -> d.findElement(By.xpath("//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked' and @aria-checked='true']")));
        Thread.sleep(15000);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("login_btn")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-header']")));
    }

    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); //создаём переменную chromeOptions
        chromeOptions.setBinary("F:\\Portable\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe"); //указываем путь к файлу запуска портативной версии браузера
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }

}
