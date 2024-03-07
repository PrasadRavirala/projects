import Pages.HeaderSection;
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

public class HeaderSectionTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection = new HeaderSection(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
    }

    @Test(priority = 1)
    public void testTheWebsiteLogo(){
        Assert.assertTrue(headerSection.getTheWebsiteLogo().isDisplayed(), "Website Logo is not displayed");
    }

    @Test(priority = 2)
    public void testTheNavBarElements(){
        Assert.assertEquals(headerSection.getTHeNavElements(0), "Home");
        Assert.assertEquals(headerSection.getTHeNavElements(1), "Popular");
    }

    @Test(priority = 3)
    public void testTheHomePageUrl(){
        headerSection.clickTheNavbarLink(1);
        headerSection.clickTheNavbarLink(0);
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "Home Page Url Is not matched");
    }

    @Test(priority = 4)
    public void testThePopularPageUrl(){
        headerSection.clickTheNavbarLink(1);
        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "Popular Page Url Is not matched");
    }

    @Test(priority = 5)
    public void testTheAccountPage(){
        headerSection.clickTheAccountButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "Account Page Url Mismatched");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
