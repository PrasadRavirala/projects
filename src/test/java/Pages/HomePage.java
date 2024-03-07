package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By headingTextLocator = By.cssSelector("h1.movies-list-heading");
    By playButtonLocator = By.className("home-movie-play-button");
    By trendingNowMoviesLocator = By.xpath("//h1[text()='Trending Now']/following-sibling::div/descendant::div[@class='slick-track']/descendant::a");
    By originalMoviesLocator = By.xpath("//h1[text()='Originals']/following-sibling::div/descendant::div[@class='slick-track']/descendant::a");
    By footerSectionIcons = By.cssSelector(".footer-icons-container>svg");
    By contactUsSpellLocator = By.className("contact-us-paragraph");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String headingTextLocatorAt(int index){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingTextLocator));
        return driver.findElements(headingTextLocator).get(index).getText();
    }

    public WebElement playButton(){
        return driver.findElement(playButtonLocator);
    }

    public int getTrendingNowCount(){
        return driver.findElements(trendingNowMoviesLocator).size();
    }

    public int getOriginalMoviesCount(){
        return driver.findElements(originalMoviesLocator).size();
    }

    public int getFooterSectionIconCount(){
        return driver.findElements(footerSectionIcons).size();
    }

    public String getContactUsSection(){
        return driver.findElement(contactUsSpellLocator).getText();
    }
}
