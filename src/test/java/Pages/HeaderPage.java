package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    WebDriver driver;

    By loginButton = By.className("login-button");
    By username = By.id("usernameInput");
    By password = By.id("passwordInput");


    By homeNavBar = By.linkText("Home");
    By popularNavBar = By.linkText("Popular");
    By accountNavBar = By.className("avatar-button");
    By websiteLogo = By.className("website-logo");


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }


    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }


    public boolean isLogoElementLocated() {
        return driver.findElement(websiteLogo).isDisplayed();
    }


    public boolean isHomeNavbarDisplayed() {
        return driver.findElement(homeNavBar).isDisplayed();
    }


    public boolean isPopularNavBarDisplayed() {
        return driver.findElement(popularNavBar).isDisplayed();
    }


    public boolean isAccountNavBarDisplayed() {
        return driver.findElement(accountNavBar).isDisplayed();


    }
}