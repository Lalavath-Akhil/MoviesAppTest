import Pages.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;


public class PopularPageTest {
    WebDriver driver;
    PopularPage popularPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        popularPage = new PopularPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/");
        popularPage.login("rahul", "rahul@2021");


    }


    @AfterMethod
    public void tearDown() {


        driver.quit();
    }




    @Test(priority = 1)
    public void checkPopularPageSection() {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        boolean value = popularPage.checkPopularPageSection();
        Assert.assertTrue(value, "Popular Page Section Failed");
    }


    @Test(priority = 2)
    public void checkPopularPageMovies() {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        int value = popularPage.checkPopularPageMovies();
        if (value == 30) {
            System.out.println("Movies are displayed as Expected");
        } else {
            System.out.println("Movies are display failed");


        }
    }
}