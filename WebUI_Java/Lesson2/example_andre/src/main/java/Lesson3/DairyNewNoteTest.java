package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DairyNewNoteTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setBinary("F:\\Portable\\GoogleChromePortable\\GoogleChromePortable.exe");
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        Cookie cookie = new Cookie("_identity", "ffbd3f03a64da922e634604b8d627d900dc944d0ae11f8f8670067895c4bb1d6a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3559826%2C%227ecVBVgUv37ORIcUl7uhnv0SiTDvuvXE%22%2C2592000%5D%22%3B%7D");
        chromeDriver.manage().addCookie(cookie);

        chromeDriver.get("https://diary.ru");

    }
}
