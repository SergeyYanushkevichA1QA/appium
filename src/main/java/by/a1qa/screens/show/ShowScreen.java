package by.a1qa.screens.show;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.utils.NumberUtils;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public abstract class ShowScreen extends Screen {
    private final ILabel slideImg;
    private final ILabel showName;
    private final ILabel acceptTickets;
    private final ILabel calendarLbl;
    private final ILabel dateLbl;
    private final ILabel ticketLbl;
    private final By dayLoc;

    public ShowScreen(By locator) {
        super(locator, "Show Page");
        slideImg = getElementFactory().getLabel(getSlideImg(), "Slide img");
        showName = getElementFactory().getLabel(getShowNameLbl(), "Show name");
        acceptTickets = getElementFactory().getLabel(getAcceptTicketsLbl(), "Accept tickets");
        calendarLbl = getElementFactory().getLabel(getCalendarLbl(), "calendar");
        dateLbl = getElementFactory().getLabel(getDateLbl(), "Date format M Number");
        ticketLbl = getElementFactory().getLabel(getTicketLbl(), "Ticket");
        dayLoc = getDayLoc();
    }

    protected abstract By getSlideImg();

    protected abstract By getShowNameLbl();

    protected abstract By getAcceptTicketsLbl();

    protected abstract By getCalendarLbl();

    protected abstract By getDateLbl();

    protected abstract By getTicketLbl();

    protected abstract By getDayLoc();

    public boolean isOnShowPage() {
        return slideImg.state().waitForDisplayed();
    }

    public String getShowName() {
        return showName.getText();
    }

    private List<ILabel> getAllDaysInCalendar() {
        return getElementFactory().findElements(dayLoc, ElementType.LABEL);
    }

    public void clickRandomDate() {
        getAllDaysInCalendar().get(NumberUtils.getRandomNumber(getAllDaysInCalendar().size())).click();
    }

    public String getDate() {
        return dateLbl.getText();
    }

    public void acceptTickets() {
        acceptTickets.click();
    }

    public String getTime() {
        return acceptTickets.getText();
    }

    public void swipeToCalendar() {
        calendarLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
    }

    public String getTicketInfo() {
        return ticketLbl.getText();
    }
}
