package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;





public class MovieDetailsPage {

    WebDriver driver;




    By usernameLocator = By.id("usernameInput");

    By passwordLocator = By.id("passwordInput");

    By loginButtonLocator = By.className("login-button");



    public MovieDetailsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }



    public void login(String username, String password) {

        driver.findElement(usernameLocator).sendKeys(username);

        driver.findElement(passwordLocator).sendKeys(password);

        driver.findElement(loginButtonLocator).click();

    }

}