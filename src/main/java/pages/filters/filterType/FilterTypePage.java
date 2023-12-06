package pages.filters.filterType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DiscoverPage;
import pages.ResultsPage;
import utils.CustomMethods;

@SuppressWarnings({"unused","UnusedReturnValue"})
public class FilterTypePage {

    private WebDriver driver;
    public FilterTypePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By applyTypeFilterBtn = By.xpath("//button[contains(@class,'500 bg-p')]");
    private final By commercialTypeBtn = By.xpath("//button[contains(@class,'focus:outline-none bo')]");

    public DiscoverPage and(){
        applyFilter();
        CustomMethods.waitForUrlToChange(driver);
        return new DiscoverPage(driver);
    }

    public ResultsPage pickTypeFilterAndApply(String typeFilter){

        return new ResultsPage(driver);
    }
    public ResultsPage applyFilter() {
        CustomMethods.findElementPresence(driver, applyTypeFilterBtn).click();
        return new ResultsPage(driver);
    }

    public FilterTypePage clickCommercial() {
        CustomMethods.findElementPresence(driver, commercialTypeBtn).click();

        return this;
    }

     private FilterTypePage filterTypesDynamicLocators(int filterTypeOption) {
         By TypeFilterOptions =
                 By.xpath("//ul[contains(@class,'grid-cols-2 gap-4')]//li[contains(@class,'text-xs')][" + filterTypeOption + "]");
         CustomMethods.findElementPresence(driver, TypeFilterOptions).click();
         return this;
     }

    public FilterTypePage filterTypesDynamicLocatorsDemo(int filterTypeOption) {
        By TypeFilterOptions =
                By.xpath("//ul[contains(@class,'grid-cols-2 gap-4')]//li[contains(@class,'text-xs')][" + filterTypeOption + "]");
        CustomMethods.findElementPresence(driver, TypeFilterOptions).click();
        return this;
    }
    public FilterTypePage pickResidentialTypeFilterOption(FilterTypeEnumMaps.ResidentialTypes typeFilterOption){
        int filterOptionIndex = FilterTypeEnumMaps.RESIDENTIAL_TYPES_MAP.get(typeFilterOption);
        filterTypesDynamicLocators(filterOptionIndex);
        return this;
    }
    public FilterTypePage pickCommercialTypeFilterOption(FilterTypeEnumMaps.CommercialTypes typeFilterOption){
        int filterOptionIndex = FilterTypeEnumMaps.COMMERCIAL_TYPES_MAP.get(typeFilterOption);
        filterTypesDynamicLocators(filterOptionIndex);
        return this;
    }
}
