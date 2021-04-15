package by.a1qa.screens.signup;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

import static io.appium.java_client.MobileBy.iOSClassChain;

@ScreenType(platform = PlatformName.IOS)
public class IOSSignUpScreen extends SignUpScreen{

    public IOSSignUpScreen() {
        super(iOSClassChain("**/XCUIElementTypeWindow[1]"));
    }

    @Override
    protected By getTitleOnScreenLbl() {
        return By.xpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
    }

    @Override
    protected By getSelectBtn() {
        return By.id("OnboardingSlide.SecondaryButton");
    }
}
