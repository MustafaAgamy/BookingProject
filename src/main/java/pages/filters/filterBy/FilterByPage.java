package pages.filters.filterBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

public class FilterByPage {

    private WebDriver driver;

    public FilterByPage(WebDriver driver) {
        this.driver = driver;
    }
    public FilterByPage pickFeatureFilter(FilterByEnumMaps.Features featureFilterName){
        int featureFilterIndex = FilterByEnumMaps.FEATURES_MAP.get(featureFilterName);
        featuresDynamicLocators(featureFilterIndex);

        return this;
    }
    public FilterByPage pickAmenitiesFilter(FilterByEnumMaps.Amenities amenitiesFilterName){
        int amenitiesFilterIndex = FilterByEnumMaps.AMENITIES_MAP.get(amenitiesFilterName);
        amenitiesDynamicLocators(amenitiesFilterIndex);

        return this;
    }

    private FilterByPage featuresDynamicLocators(int featureFilterIndex){
        CustomMethods.findElementPresence(driver,
                By.xpath("//ul[contains(@class,'grid g')]//li[@class='text-xs']"
                        + "[" + featureFilterIndex + "]")).click();
        return this;
    }
    private FilterByPage amenitiesDynamicLocators(int amenitiesFilterIndex){
        CustomMethods.findElementPresence(driver,
                By.xpath("//ul[contains(@class,'flex flex-wrap g')]//li[@class='text-xs']"
                        + "[" + amenitiesFilterIndex + "]")).click();
        return this;
    }
}
