package by.a1qa.screens;


import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class AllShowsScreen extends Screen {
    private final ILabel locationLbl = getElementFactory().getLabel(By.id("location_name"), "Location name");
    private final IButton allShowsBtn = getElementFactory().getButton(By.id("tab_all_shows"), "All shows button");
    private final IButton discoverBtn = getElementFactory().getButton(By.id("tab_discover"), "Discover button");

    public AllShowsScreen() {
        super(By.id("root_view"), "Shows Page");
    }

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
