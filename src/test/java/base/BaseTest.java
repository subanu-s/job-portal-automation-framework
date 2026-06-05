package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.getDriver();

        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}