package by.a1qa.screens.signup;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidSignUpScreen extends SignUpScreen {

    public AndroidSignUpScreen() {
        super(By.className("android.widget.LinearLayout"));
    }

    @Override
    protected By getTitleOnScreenLbl() {
        return By.id("title");
    }

    @Override
    protected By getSelectBtn() {
        return By.id("secondary_button");
    }
}
