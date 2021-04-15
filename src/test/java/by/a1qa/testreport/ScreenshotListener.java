package by.a1qa.testreport;

import aquality.appium.mobile.application.AqualityServices;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        String dateString = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        String methodName = result.getName();
        if(!result.isSuccess() && AqualityServices.isApplicationStarted()){
            File scrFile = ((TakesScreenshot)AqualityServices.getApplication().getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = String.format("%s/target/surefire-reports", new File(System.getProperty("user.dir")).getAbsolutePath());
                File destFile = new File(String.format("%s/failure_screenshots/%s_%s.png", reportDirectory, methodName, dateString));
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log(String.format("<a href='%s'> <img src='%s' height='100' width='100'/> </a>", destFile.getAbsolutePath(), destFile.getAbsolutePath()));
            } catch (IOException e) {
                AqualityServices.getLogger().warn("An IO exception occured while tried to save a screenshot");
            }
        }
    }
}
