package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    By emptySearchButton = By.className("search-empty-button");
    By searchInput = By.id("search");
    By searchButton = By.className("search-button");
    By movieImages = By.className("movie-image");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickTheEmptySearchButton(){
        driver.findElement(emptySearchButton).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));
    }

    public void searchWithMovieName(String movieName){
        driver.findElement(searchInput).sendKeys(movieName);
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieImages));
        List<WebElement> movieSize = driver.findElements(movieImages);
        System.out.println("Movies Count " + movieName + ": " + movieSize.size());
    }






}
