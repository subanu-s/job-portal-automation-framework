package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                actualUrl.contains("dashboard"),
                "Login failed: Dashboard URL was not displayed"
        );
    }
}