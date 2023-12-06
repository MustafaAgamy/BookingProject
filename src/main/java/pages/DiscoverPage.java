package pages;

import org.openqa.selenium.*;
import pages.filters.filterArea.FilterAreaPage;
import pages.filters.filterBedsAndBaths.FilterBedsBathsPage;
import pages.filters.filterBy.FilterByPage;
import pages.filters.filterType.FilterTypePage;
import pages.filters.price.FilterPricePage;
import utils.CustomMethods;


@SuppressWarnings({"unused","UnusedReturnValue"})
public class DiscoverPage {


    private WebDriver driver;

    public DiscoverPage(WebDriver driver){
        this.driver =driver;
    }

    // 0 -> Type, 1 -> Area, 2 -> Beds&Baths, 3 -> Price, 4 -> ??
    private final By expandFilterButtons = By.xpath("//button[contains(@class,'rounded-md p-4')]");
    private final By filterByButton = By.xpath("//button[contains(@class,'relative inline-flex appearance')]");

    public FilterTypePage visitTypeFilter(){
        visitFilterPage(Filters.TYPE);
        return new FilterTypePage(driver);
    }

    public FilterAreaPage visitAreaFilter(){
        visitFilterPage(Filters.AREA);
        return new FilterAreaPage(driver);
    }
    public FilterBedsBathsPage visitBedsBathsFilter(){
        visitFilterPage(Filters.BEDS_BATHS);
        return new FilterBedsBathsPage(driver);
    }

    public FilterPricePage visitPriceFilter(){
        visitFilterPage(Filters.PRICE);
        return new FilterPricePage(driver);
    }

    public FilterByPage visitFilterBy(){
        CustomMethods.findElementPresence(driver, filterByButton).click();
        return new FilterByPage(driver);
    }
    private DiscoverPage filtersDynamicLocators(int filterNumber){
        CustomMethods.findDuplicationIndex(driver, expandFilterButtons,filterNumber).click();
       return this;
    }

    private DiscoverPage visitFilterPage(Filters filterName){

        switch (filterName) {
            case TYPE -> filtersDynamicLocators(0);
            case AREA -> filtersDynamicLocators(1);
            case BEDS_BATHS -> filtersDynamicLocators(2);
            case PRICE -> filtersDynamicLocators(3);

        }
        return this;
    }

    private enum Filters{
        TYPE, AREA, BEDS_BATHS, PRICE
    }

}
