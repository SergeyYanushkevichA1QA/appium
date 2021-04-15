package by.a1qa.screens.ticketdetails;


import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;


public abstract class TicketDetailsScreen extends Screen {
    private final ILabel seatingChartLoc;
    private final ILabel expensiveTicket;
    private final ILabel holdTimerLbl;
    private final ILabel numberAndPriceLbl;
    private final IButton continueButton;

    public TicketDetailsScreen(By locator) {
        super(locator, "Ticket Screen");
        seatingChartLoc = getElementFactory().getLabel(getSeatingChartLoc(), "Seating chart");
        expensiveTicket = getElementFactory().getLabel( getExpensiveTicketLbl(), "Expensive ticket");
        holdTimerLbl = getElementFactory().getLabel(getHoldTimerLbl(), "Hold timer");
        numberAndPriceLbl = getElementFactory().getLabel(getNumberAndPriceLbl(), "Nmber and price of ticket");
        continueButton = getElementFactory().getButton(getContinueBtn(), "Continue butotn");
    }

    protected abstract By getSeatingChartLoc();

    protected abstract By getExpensiveTicketLbl();

    protected abstract By getHoldTimerLbl();

    protected abstract By getNumberAndPriceLbl();

    protected abstract By getContinueBtn();

    public boolean isOnTicketScreen() {
        return seatingChartLoc.state().waitForDisplayed();
    }

    public void clickMostExpensiveTicket() {
        expensiveTicket.click();
        AqualityServices.getApplication().getDriver().navigate().refresh();
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
