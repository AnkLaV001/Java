package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BaseView{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static String diaryNewsHeadingLocatorXpath = "//h1[.='Новости @дневников']";
    private final static String diaryNewsLocatorXpath = "//div[@class='news']//div[@class='item']";
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(xpath = diaryNewsHeadingLocatorXpath)
    private WebElement diaryNewsHeading;

    @FindBy(xpath = diaryNewsLocatorXpath)
    private WebElement diaryNews;

    public SpiritDiaryPage chooseOneOfDiaryNews(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(diaryNewsHeadingLocatorXpath)));
        webDriverWait.until(d ->d.findElements(By.xpath(diaryNewsLocatorXpath)).size() > 0);
        List<WebElement> newsList = driver.findElements(By.xpath(diaryNewsLocatorXpath));
        webDriverWait.until(d -> d.findElements(By.xpath("//a[.='Дневник']")).size() > 0);
        List<WebElement> diaryList = driver.findElements(By.xpath("//a[.='Дневник']"));
        diaryList.stream().findFirst().get().click();
        return new SpiritDiaryPage(driver);
    }

}
