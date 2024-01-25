import Pages.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderSectionTest {

    WebDriver driver;
    HeaderPage headerPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        headerPage = new HeaderPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkTheLogoElement() {
        headerPage.enterUsername("rahul");
        headerPage.enterPassword("rahul@2021");
        headerPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // Corrected timeout value
        Assert.assertTrue(headerPage.isLogoElementLocated(), "Logo Element Not Found");
    }

    @Test(priority = 2)
    public void checkTheNavBars() {
        headerPage.enterUsername("rahul");
        headerPage.enterPassword("rahul@2021");
        headerPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // Corrected timeout value
        Assert.assertTrue(headerPage.isHomeNavbarDisplayed(), "Home Page NavBar is Not Working As Expected");
        Assert.assertTrue(headerPage.isPopularNavBarDisplayed(), "Popular Page NavBar is Not Working As Expected");
        Assert.assertTrue(headerPage.isAccountNavBarDisplayed(), "Account Page NavBar is Not Working As Expected");
    }
}
