package utils;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.lang.reflect.Method;

public class BaseTest {

    ReporterManager reporter;

    @BeforeMethod
    public void beforeWithData(Object[] data, Method method) {

        reporter = ReporterManager.Instance;
        reporter.startReporting(method, data);

        try {
            reporter.info("Driver creation");
            BasePage.driver.set(DriverProvider.getDriver());
        }catch (Exception e){
            reporter.fail("Before test failure during Driver creation", e);
            reporter.stopReporting();
            reporter.closeReporter();
            Assert.fail();
        }
    }

    @AfterMethod
    public void endTest(ITestResult testResult){

        // close reporter
        reporter.stopReporting(testResult);

        //close driver
        BasePage.driver().quit();
        DriverProvider.closeDriver();

    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        reporter.closeReporter();
    }

}
