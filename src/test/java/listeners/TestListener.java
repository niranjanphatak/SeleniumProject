package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Utils.ExtentManager;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import base.BaseTest;

public class TestListener implements ITestListener {

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        String screenshotPath = ScreenshotUtil
                .captureScreenshot(driver, result.getMethod().getMethodName());

        test.log(Status.PASS, "Test Passed");
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        String screenshotPath = ScreenshotUtil
                .captureScreenshot(driver, result.getMethod().getMethodName());

        test.log(Status.FAIL, result.getThrowable());

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        String screenshotPath = ScreenshotUtil
                .captureScreenshot(driver, result.getMethod().getMethodName());

        test.log(Status.SKIP, "Test Skipped");

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}