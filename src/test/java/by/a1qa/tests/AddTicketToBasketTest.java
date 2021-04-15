package by.a1qa.tests;

import by.a1qa.data.OnboardingScreenTitle;
import by.a1qa.models.Show;
import by.a1qa.models.Ticket;
import by.a1qa.screens.*;
import by.a1qa.steps.TestSteps;
import by.a1qa.utils.ListUtils;
import by.a1qa.utils.Log;
import by.a1qa.utils.TicketUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddTicketToBasketTest extends BaseTest {
    private static final AllShowsScreen allShowsScreen = AqualityServices.getScreenFactory().getScreen(AllShowsScreen.class);
    private static final DiscoverScreen discoverScreen = AqualityServices.getScreenFactory().getScreen(DiscoverScreen.class);
    private static final ShowScreen showScreen = AqualityServices.getScreenFactory().getScreen(ShowScreen.class);
    private static final TicketDetailsScreen ticketDetailsScreen = AqualityServices.getScreenFactory().getScreen(TicketDetailsScreen.class);
    private static final LogInScreen logInScreen = AqualityServices.getScreenFactory().getScreen(LogInScreen.class);

    @Test
    public void addTicketsToBasketTest() {
        Log.info("Proceed onboarding");
        TestSteps.onboarding();

        Log.step(1,"Open Discover screen");
        allShowsScreen.clickDiscoverButton();
        Assert.assertTrue(discoverScreen.isOnDiscoverScreen(), "Isn't discover screen");

        Log.step(2,"Select lowest show");
        discoverScreen.swipeToShows();
        List<Show> shows = ListUtils.getSortedShowList(discoverScreen.getShows());
        String showNameWithLowPrice = shows.get(0).getShowName();
        discoverScreen.clickShowByName(showNameWithLowPrice);
        Assert.assertTrue(showScreen.isOnShowPage(), "Isn't show page");
        Assert.assertTrue(showScreen.getShowName().contains(showNameWithLowPrice.toUpperCase()));

        Log.step(3,"Tap random date and time on calendar");
        showScreen.swipeToCalendar();
        showScreen.clickRandomDate();
        Ticket ticket = new Ticket(TicketUtils.getDate(showScreen.getDate()), showScreen.getTime());
        showScreen.acceptTickets();
        Assert.assertEquals(ticket.getDate(), TicketUtils.getDate(showScreen.getTicketInfo()), "Wrong date");
        Assert.assertEquals(ticket.getTime(), TicketUtils.getTime(showScreen.getTicketInfo()), "Wrong time");
        String numberOfTickets = "2";
        Assert.assertEquals(numberOfTickets + " tickets", TicketUtils.getTicketsWithNumber(showScreen.getTicketInfo()), "Wrong ticket number");

        Log.step(4,"Select most expensive ticket");
        Assert.assertTrue(ticketDetailsScreen.isOnTicketScreen(), "Isn't ticket screen");
        Ticket expensiveTicket = new Ticket(TicketUtils.getPrice(ticketDetailsScreen.getPrice()));
        ticketDetailsScreen.clickMostExpensiveTicket();
        Assert.assertEquals(numberOfTickets + " x " + expensiveTicket.getPrice(),
                ticketDetailsScreen.getNumberOfTicketsAndPrice(), "Number of tickets and price arent equal");

        Log.step(5," Click continue to proceed log in screen");
        ticketDetailsScreen.clickContinueBtn();
        Assert.assertTrue(logInScreen.state().waitForDisplayed(), "Isnt login screen");
    }
}
