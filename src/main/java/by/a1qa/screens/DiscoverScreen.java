package by.a1qa.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.models.Show;
import by.a1qa.utils.PriceParser;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class DiscoverScreen extends Screen {
    private final String showContainer = "//android.widget.LinearLayout[@index='1']";
    private final String xpathContainer = "//android.view.ViewGroup[@content-desc='Fan Favourites The shows that our audience love']";
    private final ILabel showsLbl = getElementFactory().getLabel(By.xpath(xpathContainer), "Shows lbl");
    private final ILabel header = getElementFactory().getLabel(By.id("discover_header"), "Header lbl");
    private final By posterLoc = By.xpath(showContainer + "//*[contains(@resource-id, 'container')]");
    private final By posterNameLoc = By.xpath(showContainer + "//*[contains(@resource-id, 'show_name')]");
    private final By posterCostLoc = By.xpath(showContainer + "//*[contains(@resource-id, 'price_amount_label')]");

    public DiscoverScreen() {
        super(By.xpath("//android.widget.LinearLayout"), "Discover Page");
    }

    public boolean isOnDiscoverScreen() {
        return header.state().waitForDisplayed();
    }

    public void swipeToShows() {
        showsLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
    }

    private int getPosterAmount() {
        return getElementFactory().findElements(posterLoc, ElementType.LABEL).size();
    }

    private List<ILabel> getPosterNameList() {
        return getElementFactory().findElements(posterNameLoc, ElementType.LABEL);
    }

    private List<ILabel> getPosterCostList() {
        return getElementFactory().findElements(posterCostLoc, ElementType.LABEL);
    }

    public List<Show> getShows() {
        List<Show> shows = new ArrayList<>();
        for(int i = 0; i < getPosterAmount() - 1; i++) {
            Show show = new Show(getPosterNameList().get(i).getText(), PriceParser.parsePrice(getPosterCostList().get(i).getText()));
            shows.add(show);
        }
        return shows;
    }

    public void clickShowByName(String showName) {
       getPosterNameList().stream()
                .filter((s) -> s.getText().equals(showName)).findAny().get().click();
     }
}
