package by.a1qa.tests;

import by.a1qa.data.TestData;
import by.a1qa.models.Show;
import by.a1qa.models.Ticket;
import by.a1qa.screens.*;
import by.a1qa.steps.TestSteps;
import by.a1qa.utils.ListUtils;
import by.a1qa.utils.TicketUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddTicketToBasketTest extends BaseTest {
    private static AllShowsScreen allShowsScreen = new AllShowsScreen();
    private static DiscoverScreen discoverScreen = new DiscoverScreen();
    private static ShowScreen showPage = new ShowScreen();
    private static TicketDetailsScreen ticketDetailsScreen = new TicketDetailsScreen();
    private static LogInScreen logInScreen = new LogInScreen();


    @Test
    public void addTicketsToBasketTest() {
        logger.info("Step 0. Proceed to all shows screen. Location - " + TestData.cityName);
        TestSteps.onboarding();

        logger.info("Step 1 - Open Discover screen");
        allShowsScreen.clickDiscoverButton();
        Assert.assertTrue(discoverScreen.isOnDiscoverScreen(), "Isn't discover screen");

        logger.info("Step 2 - Select lowest show");
        discoverScreen.swipeToShows();
        List<Show> shows = ListUtils.getSortedShowList(discoverScreen.getShows());
        String showNameWithLowPrice = shows.get(0).getShowName();
        discoverScreen.clickShowByName(showNameWithLowPrice);
        Assert.assertTrue(showPage.isOnShowPage(), "Isn't show page");
        Assert.assertEquals(showPage.getShowName(), showNameWithLowPrice.toUpperCase());

        logger.info("Step 3 - Tap random date and time on calendar");
        showPage.swipeToCalendar();
        showPage.clickRandomDate();
        Ticket ticket = new Ticket(TicketUtils.getDate(showPage.getDate()), showPage.getTime());
        showPage.acceptTickets();
        Assert.assertEquals(ticket.getDate(), TicketUtils.getDate(showPage.getTicketInfo()), "Wrong date");
        Assert.assertEquals(ticket.getTime(), TicketUtils.getTime(showPage.getTicketInfo()), "Wrong time");
        String numberOfTickets = "2";
        Assert.assertEquals(numberOfTickets + " tickets", TicketUtils.getTicketsWithNumber(showPage.getTicketInfo()), "Wrong ticket number");

        logger.info("Step 4 - Select most expensive ticket");
        Assert.assertTrue(ticketDetailsScreen.isOnTicketScreen(), "Isn't ticket screen");
        Ticket expensiveTicket = new Ticket(TicketUtils.getPrice(ticketDetailsScreen.getPrice()));
        ticketDetailsScreen.clickMostExpensiveTicket();
        Assert.assertEquals(ticketDetailsScreen.getHoldTimerTxt(), TestData.holdTimerTxt, "Hold timer isnt equal");
        Assert.assertEquals(numberOfTickets + " x " + expensiveTicket.getPrice(),
                ticketDetailsScreen.getNumberOfTicketsAndPrice(), "Number of tickets and price arent equal");

        logger.info("Step 5 - Click continue to proceed log in screen");
        ticketDetailsScreen.clickContinueBtn();
        Assert.assertTrue(logInScreen.state().waitForDisplayed(), "Isnt login screen");
    }
}