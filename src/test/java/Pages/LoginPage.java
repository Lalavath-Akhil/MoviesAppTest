package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By logoImage = By.className("login-website-logo");

    By headingText = By.className("sign-in-heading");

    By userLabelField = By.xpath("//label[text()='USERNAME']");

    By passwordLabelField = By.xpath("//label[text()='PASSWORD']");

    By usernameEle = By.id("usernameInput");

    By passwordEle = By.id("passwordInput");

    By loginBtnEle = By.className("login-button");

    By errorMsgEle = By.className("error-message");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public boolean isLogoImageDisplayed() {
        return driver.findElement(logoImage).isDisplayed();
    }

    public String getHeadingText(){
        return driver.findElement(headingText).getText();
    }


    public String getUserNameInputText() {
        return driver.findElement(userLabelField).getText();
    }


    public String getPasswordNameInputText() {
        return driver.findElement(passwordLabelField).getText();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMsgEle).getText();
    }


    public void loginToApplication(String username, String password) {
        driver.findElement(usernameEle).sendKeys(username);
        driver.findElement(passwordEle).sendKeys(password);
        driver.findElement(loginBtnEle).click();
    }

}