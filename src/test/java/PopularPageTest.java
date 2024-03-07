import Pages.HeaderSection;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PopularPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopularPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection = new HeaderSection(driver);
        popularPage = new PopularPage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
    }

    @Test
    public void testThePopularImagesDisplayed(){
        headerSection.clickTheNavbarLink(1);
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        int moviesSize = driver.findElements(By.cssSelector("li[class='movie-icon-item'] img")).size();
        for(int i=0; i<moviesSize; i++){
            Assert.assertTrue(popularPage.getTheImageDisplayed(i).isDisplayed(), "Movies Displayed Failed");
        }
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
