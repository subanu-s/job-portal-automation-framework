package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(screenshotPath);

        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}