package by.a1qa.screens.main;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class OnboardingScreen extends Screen {
    private final ILabel titleOnScreen;
    private final IButton nextButton;

    public OnboardingScreen(By locator) {
        super(locator, "Main Page");
        titleOnScreen = getElementFactory().getLabel(getTitleOnScreenLbl(), "Title");
        nextButton = getElementFactory().getButton(getNextBtn(), "Next Button");
    }

    protected abstract By getTitleOnScreenLbl();

    protected abstract By getNextBtn();

    public void clickNextButton() {
        nextButton.click();
    }

    public String getTitle() {
        return titleOnScreen.getText();
    }
}
