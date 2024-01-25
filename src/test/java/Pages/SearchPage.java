package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;


    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");
    By loginButton = By.className("login-button");
    By searchInput = By.id("search");
    By movieIconItem = By.className("movie-icon-item");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public int searchFunctionalities(String movie) {


        WebElement searchInputField = driver.findElement(searchInput);
        searchInputField.sendKeys(movie);


        List<WebElement> movieList = driver.findElements(movieIconItem);
        return movieList.size();
    }


    public void login (String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
