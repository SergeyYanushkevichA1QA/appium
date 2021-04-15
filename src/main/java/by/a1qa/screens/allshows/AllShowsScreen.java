package by.a1qa.screens.allshows;


import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class AllShowsScreen extends Screen {
    private final ILabel locationLbl;
    private final IButton allShowsBtn;
    private final IButton discoverBtn;

    public AllShowsScreen(By locator) {
        super(locator, "Shows Page");
        locationLbl = getElementFactory().getLabel(getLocationLbl(), "Location name");
        allShowsBtn = getElementFactory().getButton(getAllShowsBtn(), "All shows button");
        discoverBtn = getElementFactory().getButton(getDiscoverBtn(), "Discover button");
    }

    protected abstract By getLocationLbl();

    protected abstract By getAllShowsBtn();

    protected abstract By getDiscoverBtn();

    public String getLocName() {
        return locationLbl.getText();
    }

    public boolean isShowsScreen(){
        return allShowsBtn.state().waitForDisplayed();
    }

    public void clickDiscoverButton(){
        discoverBtn.click();
    }
}
