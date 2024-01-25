package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By trendingNowSection = By.tagName("h1");
    By originasSection = By.tagName("h1");
    By contactUsParagraphLocator = By.className("contact-us-paragraph");


    By homeNavEle = By.linkText("Home");
    By popluarNavEle =  By.linkText("Popular");
    By playButtonEle =By.tagName("button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }

    public boolean testHomeHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(trendingNowSection));
        return driver.findElement(trendingNowSection).isDisplayed();
    }

    public boolean testPopularHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(originasSection));
        return driver.findElement(originasSection).isDisplayed();
    }

    public boolean isPlayButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButtonEle));
        return driver.findElement(playButtonEle).isDisplayed();
    }

    public boolean isContactUsTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsParagraphLocator));
        return driver.findElement(contactUsParagraphLocator).isDisplayed();
    }

    public boolean checkMoviesSections() {
        List<WebElement> trendingSection = driver.findElements(By.xpath("html/body/div/div/div[2]/div[1]/div//a"));
        List<WebElement> originalSection = driver.findElements(By.xpath("html/body/div/div/div[2]/div[2]/div//a"));
        return !trendingSection.isEmpty() && !originalSection.isEmpty();
    }


}