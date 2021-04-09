package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest {
    public final static Logger logger = AqualityServices.getLogger();

    @BeforeClass
    public void setup(){
        AqualityServices.getApplication();
        AqualityServices.getLogger().info("App is opened");
    }

    @AfterClass
    public void tearDown() {
        if (AqualityServices.isApplicationStarted())
            AqualityServices.getApplication().getDriver().quit();
        AqualityServices.getLogger().info("App is closed");
    }
}

