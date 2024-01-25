import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class SearchPageTest {
    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/");
        searchPage.login("rahul", "rahul@2021");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();


    }
    @Test
    public void CheckSearchFunctionality(){


        WebElement searchButton = driver.findElement(By.className("search-empty-button"));
        searchButton.click();

        WebElement searchButton1 = driver.findElement(By.className("search-button"));
        searchButton1.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));


        int value = searchPage.searchFunctionalities("Avatar");
        if(value >=1){
            System.out.println("Search Functionality is Working Expected");
        }
    }
}