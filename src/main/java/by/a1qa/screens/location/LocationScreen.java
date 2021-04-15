package by.a1qa.screens.location;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class LocationScreen extends Screen {
    private final IButton selectBtn;

    public LocationScreen(By locator) {
        super(locator, "Location Screen");
        selectBtn = getElementFactory().getButton(getSelectBtn(), "Select Manually button");
    }

    protected abstract By getSelectBtn();

    public void clickSelectButton() {
        selectBtn.click();
    }
}
