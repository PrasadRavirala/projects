import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    MovieDetailsPage movieDetailsPage;


    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        headerSection = new HeaderSection(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
    }

    @Test(priority = 1)
    public void testTheSquidGame(){
        movieDetailsPage.testTheSquidGame();
    }

    @Test(priority = 2)
    public void testTeVenomMovie(){
        headerSection.clickTheNavbarLink(1);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        movieDetailsPage.testTheVenomMovie();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
