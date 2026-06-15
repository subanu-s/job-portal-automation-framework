package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("reports/AutomationReport.html");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Job Portal Automation Framework");
            extent.setSystemInfo("Tester", "Subanu S");
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        }

        return extent;
    }
}