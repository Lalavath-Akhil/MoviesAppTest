import Pages.AccountsPage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



import java.time.Duration;



public class AccountsPageTest {

    WebDriver driver;



    AccountsPage accountsPage;



    @BeforeMethod

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "c:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();

        accountsPage = new AccountsPage(driver);

        driver.get("https://qamoviesapp.ccbp.tech/account");





    }

    @AfterMethod

    public void tearDown(){

        driver.quit();

    }

    @Test

    public void checkAccountPage(){



        accountsPage.login("rahul","rahul@2021");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));



        WebElement accountPage = driver.findElement(By.className("avatar-button"));

        accountPage.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        WebElement accountHeading = driver.findElement(By.className("account-heading"));

        wait.until(ExpectedConditions.visibilityOf(accountHeading));



        WebElement membershipContainer = driver.findElement(By.className("membership-container"));

        wait.until(ExpectedConditions.visibilityOf(membershipContainer));



        WebElement planContainer = driver.findElement(By.className("plan-container"));

        wait.until(ExpectedConditions.visibilityOf(planContainer));



        WebElement logoutButton = driver.findElement(By.className("logout-button"));

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));



        WebElement iconsContainer = driver.findElement(By.className("footer-icons-container"));

        wait.until(ExpectedConditions.visibilityOf(iconsContainer));



        WebElement contactUsPara = driver.findElement(By.className("contact-us-paragraph"));

        wait.until(ExpectedConditions.visibilityOf(contactUsPara));







    }



}