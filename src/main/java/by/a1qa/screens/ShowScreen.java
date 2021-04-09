package by.a1qa.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.utils.NumberUtils;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ShowScreen extends Screen {
    private final ILabel slideImg = getElementFactory().getLabel(By.id("slide_image"), "Slide img");
    private final ILabel showName = getElementFactory().getLabel(By.id("show_name"), "Show name");
    private final ILabel acceptTickets = getElementFactory().getLabel(By.id("performance_time"), "Accept tickets");
    private final ILabel calendarLbl = getElementFactory().getLabel(By.id("calendar_view"), "calendar");
    private final ILabel dateLbl = getElementFactory().getLabel(By.id("date_label"), "Date format M Number");
    private final ILabel ticketLbl = getElementFactory().getLabel(By.id("date_time_label"), "Ticket");
    private final By dayLoc = By.xpath("//*[contains(@resource-id, 'day_number')]");

    public ShowScreen() {
        super(By.id("com.todaytix.TodayTix:id/show_name"), "Show Page");
    }

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
