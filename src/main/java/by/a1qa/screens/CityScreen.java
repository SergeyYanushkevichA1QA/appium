package by.a1qa.screens;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.utils.NumberUtils;
import org.openqa.selenium.By;

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
        ILabel element = getCitiesList().get(NumberUtils.getRandomNumber(getCitiesList().size()));
        String cityName = element.getText();
        element.click();
        return cityName;
    }

    public void chooseCity(String cityName) {
        getCitiesList().stream()
                .filter(s -> s.getText().equals(cityName)).findAny().orElse(null).click();
    }
}
