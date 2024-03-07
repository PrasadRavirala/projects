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

public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testTheLoginPageUi(){
        Assert.assertTrue(loginPage.getTheWebsiteLogo().isDisplayed(), "Website Logo is not displayed");
        Assert.assertEquals(loginPage.getTheLoginTextHeading(), "Login");
        Assert.assertEquals(loginPage.getTheLabelAtIndex(0), "USERNAME");
        Assert.assertEquals(loginPage.getTheLabelAtIndex(1), "PASSWORD");
        Assert.assertEquals(loginPage.getTheLoginButtonText(), "Login");

    }

    @Test(priority = 1)
    public void testWithEmptyInputs(){
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getTheErrorMessage(), "*Username or password is invalid");
    }

    @Test(priority = 2)
    public void testWithEmptyUsername(){
        loginPage.loginToApplication("", "rahul@2021");
        Assert.assertEquals(loginPage.getTheErrorMessage(), "*Username or password is invalid");
    }

    @Test(priority = 3)
    public void testWithEmptyPassword(){
        loginPage.loginToApplication("rahul", "");
        Assert.assertEquals(loginPage.getTheErrorMessage(), "*Username or password is invalid");
    }

    @Test(priority = 4)
    public void testWithInvalidInputs(){
        loginPage.loginToApplication("rahul", "rahul2021");
        Assert.assertEquals(loginPage.getTheErrorMsg(), "*username and password didn't match");
    }

    @Test(priority = 5)
    public void testWithValidInputs(){
        loginPage.loginToApplication("rahul", "rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Urls do not match");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
