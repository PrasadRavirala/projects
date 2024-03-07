package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularPage {

    WebDriver driver;
    WebDriverWait wait;

    By moviesImagesLocator = By.cssSelector("li[class='movie-icon-item'] img");

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getTheImageDisplayed(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesImagesLocator));
        return driver.findElements(moviesImagesLocator).get(index);
    }
}
