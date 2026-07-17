package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                WaitUtils.waitForUrlContains(driver, "dashboard"),
                "Login failed: Dashboard page was not opened"
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] provideInvalidLoginData() {

        return new Object[][] {
            {"Admin", "wrongpassword"},
            {"WrongUser", "admin123"},
            {"WrongUser", "wrongpassword"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void verifyInvalidLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        String actualMessage = loginPage.getInvalidLoginMessage();

        Assert.assertEquals(
                actualMessage,
                "Invalid credentials",
                "Invalid login error message mismatch"
        );
    }
}