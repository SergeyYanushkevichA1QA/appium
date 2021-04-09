package by.a1qa.screens;


import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;


public class TicketDetailsScreen extends Screen {
    private final ILabel seatingChartLoc = getElementFactory().getLabel(By.id("static_seating_chart"), "Seating chart");
    private final ILabel expensiveTicket = getElementFactory().getLabel(By.id("real_price"), "Expensive ticket");
    private final ILabel holdTimerLbl = getElementFactory().getLabel(By.id("hold_timer_static_label"), "Hold timer");
    private final ILabel numberAndPriceLbl = getElementFactory().getLabel(By.id("price_label"), "Nmber and price of ticket");
    private final IButton continueButton = getElementFactory().getButton(By.id("checkout_button"), "Continue butotn");

    public TicketDetailsScreen() {
        super(By.id("static_seating_chart"), "Ticket Screen");
    }

    public boolean isOnTicketScreen() {
        return seatingChartLoc.state().waitForDisplayed();
    }

    public void clickMostExpensiveTicket() {
        expensiveTicket.click();
        expensiveTicket.click();
    }

    public String getHoldTimerTxt() {
        holdTimerLbl.state().waitForDisplayed();
        return holdTimerLbl.getText();
    }

    public String getPrice() {
        return expensiveTicket.getText();
    }

    public String getNumberOfTicketsAndPrice() {
        return numberAndPriceLbl.getText();
    }

    public void clickContinueBtn(){
        continueButton.click();
    }
}
