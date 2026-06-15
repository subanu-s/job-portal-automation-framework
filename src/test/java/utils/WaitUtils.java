package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static int getTimeout() {
        return Integer.parseInt(ConfigReader.getProperty("timeout"));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(getTimeout())
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(getTimeout())
        );

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static boolean waitForUrlContains(WebDriver driver, String text) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(getTimeout())
        );

        return wait.until(
                ExpectedConditions.urlContains(text)
        );
    }
}