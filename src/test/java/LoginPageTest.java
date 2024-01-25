import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test(priority = 1)
    public void testLoginPageUI() {
        Assert.assertTrue(loginPage.isLogoImageDisplayed());
        Assert.assertEquals(loginPage.getHeadingText(), "Login");
        Assert.assertEquals(loginPage.getUserNameInputText(), "USERNAME");
        Assert.assertEquals(loginPage.getPasswordNameInputText(), "PASSWORD");

    }

    @Test(priority = 2)
    public void testLoginFunctionalities() {

        loginPage.loginToApplication("", "");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Assert.assertEquals(loginPage.getErrorMessage(),"*Username or password is invalid");


        loginPage.loginToApplication("", "rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Assert.assertEquals(loginPage.getErrorMessage(),"*Username or password is invalid");

        loginPage.loginToApplication("rahul", "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Assert.assertEquals(loginPage.getErrorMessage(),"*Username or password is invalid");

        loginPage.loginToApplication("rahul", "rahul2021");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        Assert.assertEquals(loginPage.getErrorMessage(),"*Username or password is invalid");

        loginPage.loginToApplication("rahul", "rahul@2021");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}