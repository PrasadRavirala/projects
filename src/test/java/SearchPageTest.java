import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HeaderSection headerSection;
    SearchPage searchPage;

    @DataProvider
    public Object[][] dataSet(){
        Object[][] data = {
                {"venom"},
                {"narnia"}, {"Spider-Man"}, {"Godzilla vs. Kong"}
        };
        return data;
    }

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        headerSection = new HeaderSection(driver);
        searchPage = new SearchPage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
    }

    @Test(dataProvider = "dataSet")
    public void testTheMovies(String movieName){
        searchPage.clickTheEmptySearchButton();
        searchPage.searchWithMovieName(movieName);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
