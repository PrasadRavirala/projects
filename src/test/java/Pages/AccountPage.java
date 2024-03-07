package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    WebDriver driver;
    WebDriverWait wait;

    By accountHeading = By.className("account-heading");
    By username = By.className("membership-username");
    By password = By.className("membership-password");
    By planDetails = By.className("plan-details");
    By logOutButton = By.className("logout-button");


    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testTheUiElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountHeading));
        System.out.println("Account Heading: " + driver.findElement(accountHeading).getText());
        System.out.println("Username: " + driver.findElement(username).getText());
        System.out.println("Password: " + driver.findElement(password).getText());
        System.out.println("Plan Details: " + driver.findElement(planDetails).getText());
    }

    public void clickTheLogoutButton(){
        driver.findElement(logOutButton).click();
    }


}
