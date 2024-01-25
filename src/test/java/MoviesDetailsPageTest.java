import Pages.MovieDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class MoviesDetailsPageTest {

    WebDriver driver;

    MovieDetailsPage movieDetailsPage;





    @BeforeMethod

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "c:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();

        movieDetailsPage = new MovieDetailsPage(driver);

        driver.get("https://qamoviesapp.ccbp.tech/");

        movieDetailsPage.login("rahul", "rahul@2021");



    }



    @AfterMethod

    public void tearDown() {

        driver.quit();

    }



    @Test(priority = 1)

    public void checkHomePageFuctionalities() {



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));



        WebElement homeHeading = driver.findElement(By.linkText("Home"));

        homeHeading.click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement movie = driver.findElement(By.xpath("/html/body/div/div/div[2]//a"));

        movie.click();



        WebElement titleContainer = driver.findElement(By.className("home-movie-details-container"));

        wait.until(ExpectedConditions.visibilityOf(titleContainer));



        WebElement movieTitle = driver.findElement(By.className("home-movie-heading"));

        wait.until(ExpectedConditions.visibilityOf(movieTitle));





        WebElement movieOverview = driver.findElement(By.className("home-movie-description"));

        wait.until(ExpectedConditions.visibilityOf(movieOverview));





        WebElement playButton = driver.findElement(By.className("home-movie-play-button"));

        wait.until(ExpectedConditions.elementToBeClickable(playButton));





        WebElement homeBottomContainer = driver.findElement(By.className("home-bottom-container"));

        wait.until(ExpectedConditions.visibilityOf(homeBottomContainer));





        WebElement iconsContainer = driver.findElement(By.className("footer-icons-container"));

        wait.until(ExpectedConditions.visibilityOf(iconsContainer));



        WebElement contactUsparagraph = driver.findElement(By.className("contact-us-paragraph"));

        wait.until(ExpectedConditions.visibilityOf(contactUsparagraph));



        if (titleContainer.isDisplayed() && movieTitle.isDisplayed() && movieOverview.isDisplayed() &&

                playButton.isDisplayed() && homeBottomContainer.isDisplayed() &&

                iconsContainer.isDisplayed() && contactUsparagraph.isDisplayed()

        ) {

            System.out.println("Home Page Fuctionalities is Working As Expected");

        }

    }



    @Test(priority = 2)

    public void checkPopularPageFuctionalities() {



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));



        WebElement homeHeading = driver.findElement(By.linkText("Popular"));

        homeHeading.click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        WebElement movie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[1]/a/img"));

        movie.click();





        WebElement titleContainer = driver.findElement(By.className("movie-details-container"));

        wait.until(ExpectedConditions.visibilityOf(titleContainer));



        WebElement movieTitle = driver.findElement(By.className("movie-title"));

        wait.until(ExpectedConditions.visibilityOf(movieTitle));





        WebElement movieOverview = driver.findElement(By.className("movie-overview"));

        wait.until(ExpectedConditions.visibilityOf(movieOverview));





        WebElement playButton = driver.findElement(By.className("play-button"));

        wait.until(ExpectedConditions.elementToBeClickable(playButton));





        WebElement homeBottomContainer = driver.findElement(By.className("detailed-movie-categories-container"));

        wait.until(ExpectedConditions.visibilityOf(homeBottomContainer));





        WebElement iconsContainer = driver.findElement(By.className("footer-icons-container"));

        wait.until(ExpectedConditions.visibilityOf(iconsContainer));



        WebElement contactUsparagraph = driver.findElement(By.className("contact-us-paragraph"));

        wait.until(ExpectedConditions.visibilityOf(contactUsparagraph));



        if (titleContainer.isDisplayed() && movieTitle.isDisplayed() && movieOverview.isDisplayed() &&

                playButton.isDisplayed() && homeBottomContainer.isDisplayed() &&

                iconsContainer.isDisplayed() && contactUsparagraph.isDisplayed()

        ) {

            System.out.println("Popular Page Fuctionalities is Working As Expected");

        }





    }

}