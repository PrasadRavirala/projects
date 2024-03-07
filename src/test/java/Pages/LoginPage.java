package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By websiteLogoImageLocator = By.className("login-website-logo");
    By headingTextLocator = By.className("sign-in-heading");
    By labelTextLocator = By.className("input-label");
    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");
    By loginButton = By.className("login-button");
    By errorMessageLocator = By.className("error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public WebElement getTheWebsiteLogo(){
        return driver.findElement(websiteLogoImageLocator);
    }

    public String getTheLoginTextHeading(){
        return driver.findElement(headingTextLocator).getText();
    }

    public String getTheLabelAtIndex(int index){
        return driver.findElements(labelTextLocator).get(index).getText();
    }

    public String getTheLoginButtonText(){
        return driver.findElement(loginButton).getText();
    }

    public String getTheErrorMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessage.getText();
    }

    public String getTheErrorMsg(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessage.getText();
    }

    public void loginToApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}