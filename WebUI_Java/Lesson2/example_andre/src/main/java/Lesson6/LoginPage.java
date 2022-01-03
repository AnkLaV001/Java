package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView{

    private final static String loginFormLocatorId = "loginform-username";
    private final static String passwordFormLocatorId = "loginform-password";
    private final static String captchaFrameLocatorXpath = "//iframe[@title='reCAPTCHA']";
    private final static String captchaCheckboxLocatorClassName = "recaptcha-checkbox-border";
    private final static String loginButtonLocatorId = "login_btn";

    @FindBy(id = loginFormLocatorId)
    private WebElement loginInput;

    @FindBy(id = passwordFormLocatorId)
    private WebElement passwordInput;

    @FindBy(xpath = captchaFrameLocatorXpath)
    private WebElement captchaFrame;

    @FindBy(id = loginButtonLocatorId)
    private WebElement loginButton;

    @FindBy(className = captchaCheckboxLocatorClassName)
    private WebElement captchaCheckbox;

    @Step("Заполнить поле Login")
    public LoginPage fillLoginInput(String login){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginFormLocatorId)));
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле Password")
    public LoginPage fillPasswordInput(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Переключиться на iFrame с капчей")
    public LoginPage switchToCaptchaFrame(){
        driver.switchTo().frame(captchaFrame);
        return this;
    }

    @Step("Нажать на чекбокс проверки капчи")
    public LoginPage pressToCaptchaCheckbox(){
        captchaCheckbox.click();
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public MainPage pressLoginButton(){
        loginButton.click();
        return new MainPage(driver);
    }


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
