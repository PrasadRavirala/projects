import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    AccountPage accountPage;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        headerSection = new HeaderSection(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        headerSection.clickTheAccountButton();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
    }

    @Test(priority = 1)
    public void testTheUiElements(){
        accountPage.testTheUiElements();
    }

    @Test(priority = 2)
    public void testTheLogOutFunctionality(){
        accountPage.clickTheLogoutButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "Log Out Functionality Failed");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
