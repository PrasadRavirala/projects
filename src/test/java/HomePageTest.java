import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
    }

    @Test(priority = 1)
    public void testTheHeadingPageSections(){
        Assert.assertEquals(homePage.headingTextLocatorAt(0), "Trending Now");
        Assert.assertEquals(homePage.headingTextLocatorAt(1), "Originals");
    }

    @Test(priority = 2)
    public void testThePlayButton(){
        Assert.assertTrue(homePage.playButton().isDisplayed(), "Play button is not displayed");
    }

    @Test(priority = 3)
    public void testTheMoviesCount(){
        Assert.assertEquals(homePage.getTrendingNowCount(), 10, "Trending Movies Count Mismatched");
        Assert.assertEquals(homePage.getOriginalMoviesCount(), 10, "Originals Movies Count Mismatched");
    }

    @Test(priority = 4)
    public void testTheContactUsSection(){
        Assert.assertEquals(homePage.getFooterSectionIconCount(), 4, "Footer Section Count is Mismatched");
        Assert.assertEquals(homePage.getContactUsSection(), "Contact Us", "Contact Us Mismatched");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
