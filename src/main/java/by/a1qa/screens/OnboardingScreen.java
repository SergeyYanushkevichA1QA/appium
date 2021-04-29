package by.a1qa.screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class OnboardingScreen extends Screen {
    private final ILabel titleOnScreen = getElementFactory().getLabel(By.id("title"), "Title");
    private final IButton nextButton = getElementFactory().getButton(By.id("next_button"), "Next Button");

    public OnboardingScreen() {
        super(By.id("content"), "Main Page");
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public String getTitle() {
        return titleOnScreen.getText();
    }
}
