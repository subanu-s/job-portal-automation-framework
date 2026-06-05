package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser =
                    ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {

                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("edge")) {

                driver = new EdgeDriver();

            } else {

                throw new RuntimeException(
                        "Browser not supported: "
                                + browser
                );
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}