package by.a1qa.screens;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.utils.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class CityScreen extends Screen {
    private final By citiesLoc = By.xpath("//*[contains(@resource-id, 'location_text')]");

    public CityScreen() {
        super(By.className("android.widget.TextView"), "City Page");
    }

    private List<ILabel> getCitiesList() {
        return getElementFactory().findElements(citiesLoc, ElementType.LABEL);
    }

    public String getRandomCityNameAndClick() {
        ILabel city = getCitiesList().get(NumberUtils.getRandomNumber(getCitiesList().size()));
        String cityName = city.getText();
        city.click();
        return cityName;
    }

    public void chooseCity(String cityName) {
        ILabel cityLbl = getCitiesList().stream()
                .filter(s -> s.getText().equals(cityName))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("No city with name '%s' found", cityName)));
        cityLbl.click();
    }
}
