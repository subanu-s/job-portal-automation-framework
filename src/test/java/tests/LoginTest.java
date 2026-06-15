package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("wrongdashboard"),
                "Login failed: Dashboard page was not opened"
        );
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "wrongpassword");

        String actualMessage = loginPage.getInvalidLoginMessage();

        Assert.assertEquals(
                actualMessage,
                "Invalid credentials",
                "Invalid login error message mismatch"
        );
    }
}