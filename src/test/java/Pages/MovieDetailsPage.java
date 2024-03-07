package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MovieDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By shangchiAnchorLink = By.cssSelector("img[src *= 'shang-chi-and-the-legend-of-the-ten-rings-movie-poster.png']");
    By movieTitle = By.className("movie-title");
    By movieReviewsContainer = By.cssSelector("div[class='movie-review-container'] p");
    By movieOverView = By.className("movie-overview");
    By playButton = By.className("play-button");
    By venomAnchorLink = By.cssSelector("img[alt='Venom']");

    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testTheSquidGame(){
        driver.findElement(shangchiAnchorLink).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/046084e1-a782-4086-b723-f98c5c57ebc0"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        System.out.println("Movie Title: " + driver.findElement(movieTitle).getText());
        List<WebElement> movieReviews = driver.findElements(movieReviewsContainer);
        System.out.println("Movie Duration: " + movieReviews.get(0).getText());
        System.out.println("Sensor Rating: " + movieReviews.get(1).getText());
        System.out.println("Release Year: " + movieReviews.get(2).getText());
        System.out.println("Movie Overview: " + driver.findElement(movieOverView).getText());
        WebElement image = driver.findElement(playButton);
        Assert.assertTrue(image.isDisplayed(), "Play button Displayed Failed");
    }

    public void testTheVenomMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(venomAnchorLink));
        driver.findElement(venomAnchorLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        System.out.println("Movie Title: " + driver.findElement(movieTitle).getText());
        List<WebElement> movieReviews = driver.findElements(movieReviewsContainer);
        System.out.println("Movie Duration: " + movieReviews.get(0).getText());
        System.out.println("Sensor Rating: " + movieReviews.get(1).getText());
        System.out.println("Release Year: " + movieReviews.get(2).getText());
        System.out.println("Movie Overview: " + driver.findElement(movieOverView).getText());
        WebElement image = driver.findElement(playButton);
        Assert.assertTrue(image.isDisplayed(), "Play button Displayed Failed");
    }

}
