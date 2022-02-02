package Lesson6;

import Lesson7.LessonLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DiaryTest {
    WebDriver webDriver;
    EventFiringWebDriver eventFiringWebDriver;
    LandingPage landingPage;
    LoginPage loginPage;
    MainPage mainPage;

    private final static String DIARY_BASE_PAGE_URL = "https://diary.ru/";
    private final static String LOGIN = "AndrE001";
    private final static String PASS = "E1W6OK9#FK";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver(){
        eventFiringWebDriver = new EventFiringWebDriver(BaseView.webDriver());
        eventFiringWebDriver.register(new LessonLogger());
        eventFiringWebDriver.get(DIARY_BASE_PAGE_URL);
        //webDriver = BaseView.webDriver();
        //webDriver.get(DIARY_BASE_PAGE_URL);
        landingPage = new LandingPage(webDriver);
        loginPage = new LoginPage(webDriver);
        //mainPage = new MainPage(webDriver);
    }

    @Test
    void openMainPageTest(){
        new LandingPage(webDriver).clickLoginButton();
        new LoginPage(webDriver).fillLoginInput(LOGIN)
                .fillPasswordInput(PASS)
                .switchToCaptchaFrame()
                .pressToCaptchaCheckbox()
                .pressLoginButton();
        webDriver.findElement(By.xpath("//h1[.='Новости @дневников']"));
    }

    @AfterEach
    void tearDown(){
        webDriver.quit();
    }
}
