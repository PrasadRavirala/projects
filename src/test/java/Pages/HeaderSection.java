package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSection {

    WebDriver driver;

    By homePageLogoLocator = By.className("website-logo");
    By navBarElementsLocator = By.cssSelector("li[class=list-item] a");
    By accountButton = By.className("avatar-button");

    public HeaderSection(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTheWebsiteLogo(){
        return driver.findElement(homePageLogoLocator);
    }

    public String getTHeNavElements(int index){
        return driver.findElements(navBarElementsLocator).get(index).getText();
    }

    public void clickTheNavbarLink(int index){
        driver.findElements(navBarElementsLocator).get(index).click();
    }

    public void clickTheAccountButton(){
        driver.findElement(accountButton).click();
    }
}
