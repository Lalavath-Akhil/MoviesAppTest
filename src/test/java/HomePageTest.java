
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/");
        homePage.login("rahul", "rahul@2021");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkTheHeadingTexts() {


        Assert.assertTrue(homePage.testHomeHeading(), "Home Heading is Not Working");
        System.out.println("Home Heading is displayed.");

        Assert.assertTrue(homePage.testPopularHeading(), "Popular Heading is Not Working");
        System.out.println("Popular Heading is displayed.");
    }

    @Test(priority = 2)
    public void checkPlayBtn() {

        Assert.assertTrue(homePage.isPlayButtonDisplayed(), "Play Button is Not Working");
        System.out.println("Play Button is displayed.");
    }

    @Test(priority = 3)
    public void checkMoviesDisplay() {


        Assert.assertTrue(homePage.checkMoviesSections(), "Movies Display is Not Working");
        System.out.println("Movies Display is working.");
    }

    @Test(priority = 4)
    public void isContactUsDisplayed() {


        Assert.assertTrue(homePage.isContactUsTextDisplayed(), "Contact Us is not Displayed ");
        System.out.println("Contact Us is displayed");

    }
}
