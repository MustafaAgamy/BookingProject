package pages.filters.filterBedsAndBaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DiscoverPage;
import pages.ResultsPage;
import utils.CustomMethods;

@SuppressWarnings({"unused","UnusedReturnValue"})
public class FilterBedsBathsPage {

    private WebDriver driver;

    public FilterBedsBathsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By applyBedsBathsFilterBtn = By.xpath("//button[contains(@class,'lg bg-e')]");

    public DiscoverPage and(){
        applyFilter();
        CustomMethods.waitForUrlToChange(driver);
        return new DiscoverPage(driver);
    }
    public FilterBedsBathsPage pickRoomsNumber(int roomsNumber){
        By TypeFilterOptions =
                By.xpath("//label[@for='rooms-" + roomsNumber +"']");
        CustomMethods.findElementPresence(driver, TypeFilterOptions).click();
        return this;
    }

    public FilterBedsBathsPage pickBathsNumber(int bathsNumber){
        By TypeFilterOptions =
                By.xpath("//label[@for='baths-" + bathsNumber +"']");
        CustomMethods.findElementPresence(driver, TypeFilterOptions).click();
        return this;
    }

    public ResultsPage applyFilter() {
        CustomMethods.findElementPresence(driver, applyBedsBathsFilterBtn).click();

        return new ResultsPage(driver);
    }
}
