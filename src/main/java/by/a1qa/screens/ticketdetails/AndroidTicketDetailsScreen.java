package by.a1qa.screens.ticketdetails;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidTicketDetailsScreen extends TicketDetailsScreen{

    public AndroidTicketDetailsScreen() {
        super(By.id("static_seating_chart"));
    }

    @Override
    protected By getSeatingChartLoc() {
        return By.id("static_seating_chart");
    }

    @Override
    protected By getExpensiveTicketLbl() {
        return By.id("real_price");
    }

    @Override
    protected By getHoldTimerLbl() {
        return By.id("hold_timer_static_label");
    }

    @Override
    protected By getNumberAndPriceLbl() {
        return By.id("price_label");
    }

    @Override
    protected By getContinueBtn() {
        return By.id("checkout_button");
    }
}
