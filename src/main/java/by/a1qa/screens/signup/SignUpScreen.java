package by.a1qa.screens.signup;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class SignUpScreen extends Screen {
    private final IButton selectBtn;
    private final ILabel titleOnScreen;

    public SignUpScreen(By locator) {
        super(locator, "SignUp Screen");
        titleOnScreen = getElementFactory().getLabel(getTitleOnScreenLbl(), "Title");
        selectBtn = getElementFactory().getButton(getSelectBtn(), "Select Manually button");
    }

    protected abstract By getTitleOnScreenLbl();

    protected abstract By getSelectBtn();

    public void clickContinueWithoutSignUp() {
        selectBtn.click();
    }

    public String getTitle() {
        return titleOnScreen.getText();
    }
}
