package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WaitUtils.waitForElementVisible(driver, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForElementVisible(driver, passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtils.waitForElementClickable(driver, loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    private By invalidCredentialsMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    public String getInvalidLoginMessage() {
        return WaitUtils.waitForElementVisible(driver, invalidCredentialsMessage).getText();
    }
}