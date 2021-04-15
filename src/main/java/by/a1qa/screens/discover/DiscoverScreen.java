package by.a1qa.screens.discover;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.models.Show;
import by.a1qa.utils.PriceParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscoverScreen extends Screen {
    private final ILabel showsLbl;
    private final ILabel header;
    private final By posterLoc;
    private final By posterNameLoc;
    private final By posterCostLoc;

    public DiscoverScreen(By locator) {
        super((locator), "Discover Page");
        showsLbl = getElementFactory().getLabel(getShowsLbl(), "Shows lbl");
        header = getElementFactory().getLabel(getHeader(), "Header lbl");
        posterLoc = getPosterLoc();
        posterNameLoc = getPosterNameLoc();
        posterCostLoc = getPosterCostLoc();
    }

    protected abstract By getShowsLbl();

    protected abstract By getHeader();

    protected abstract By getPosterLoc();

    protected abstract By getPosterNameLoc();

    protected abstract By getPosterCostLoc();

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
        for(int i = 0; i < getPosterAmount(); i++) {
            Show show = new Show(getPosterNameList().get(i).getText(), PriceParser.parsePrice(getPosterCostList().get(i).getText()));
            shows.add(show);
        }
        return shows;
    }

    public void clickShowByName(String showName) {
        ILabel showLbl =  getPosterNameList().stream()
                .filter(s -> s.getText().equals(showName))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("No show with name '%s' found", showName)));
        showLbl.click();
     }
}
