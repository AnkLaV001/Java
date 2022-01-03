package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BaseView{

    @FindBy(xpath = "//a[.='Вход']")
    WebElement loginButton;

    public LandingPage clickLoginButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Вход']")));
        loginButton.click();
        return this;
    }


    public LandingPage(WebDriver driver) {
        super(driver);
    }
}
