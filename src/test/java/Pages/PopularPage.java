package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");
    By loginButton = By.className("login-button");
    By popularLink = By.linkText("Popular");
    By searchMoviesContainer = By.className("search-movies-container");
    By movieIconItem = By.className("movie-icon-item");

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean checkPopularPageSection(){
        WebElement PopularSec = driver.findElement(By.linkText("Popular"));
        PopularSec.click();
        WebElement popularSection = driver.findElement(By.className("search-movies-container"));
        return  popularSection.isDisplayed();
    }

    public int checkPopularPageMovies(){
        WebElement PopularSec = driver.findElement(By.linkText("Popular"));
        PopularSec.click();
        List<WebElement>  popularPageList = driver.findElements(By.className("movie-icon-item"));
        return  popularPageList.size();
    }
}