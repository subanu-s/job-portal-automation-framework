package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = ExtentReportManager
                .getReportInstance()
                .createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());

        Object testClass = result.getInstance();

        BaseTest baseTest = (BaseTest) testClass;

        String screenshotPath = ScreenshotUtils.captureScreenshot(
                baseTest.getDriver(),
                result.getName()
        );

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        ExtentReportManager.getReportInstance().flush();
    }
}