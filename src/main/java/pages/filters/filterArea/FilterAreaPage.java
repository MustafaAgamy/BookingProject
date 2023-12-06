package pages.filters.filterArea;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.filters.filterBedsAndBaths.FilterBedsBathsPage;
import pages.ResultsPage;
import utils.CustomMethods;

import java.util.EnumMap;

import static utils.CustomMethods.findDuplicationIndex;

public class FilterAreaPage {


    private WebDriver driver;
    public FilterAreaPage(WebDriver driver){
        this.driver = driver;
    }


    private final By minAndMaxAreaFields = By.xpath("//input[contains(@class,'w-full border-none')]");
    private final By applyAreaFilterBtn = By.xpath("//button[contains(@class,'lg bg-e')]");

    public FilterBedsBathsPage and(){
        return new FilterBedsBathsPage(driver);
    }

    public ResultsPage setMinAndMaxAreaAndApply(String minAreaValue, String maxAreaValue) {
         setMinAreaField(minAreaValue)
        .setMaxAreaField(maxAreaValue)
        .applyFilter();

        return new ResultsPage(driver);
    }
    public FilterAreaPage setMinAreaField(String minAreaValue) {
        pickAreaFilterOption(AreaFields.MIN, minAreaValue);

        return this;
    }

    public FilterAreaPage setMaxAreaField(String maxAreaValue) {
        pickAreaFilterOption(AreaFields.MAX, maxAreaValue);

        return this;
    }

    public ResultsPage applyFilter() {
        CustomMethods.findElementPresence(driver, applyAreaFilterBtn).click();

        return new ResultsPage(driver);
    }

    public FilterAreaPage pickAreaFilterOption(int areaFilterField, String keysToSend) {
        Actions actions =new Actions(driver);

            actions.click(findDuplicationIndex(driver, minAndMaxAreaFields,areaFilterField)).pause(2000)
                    .sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, keysToSend)
                    .release().pause(1000).build().perform();

        return this;
    }
    public FilterAreaPage pickAreaFilterOption(AreaFields areaFilterField, String keysToSend){

        switch (areaFilterField) {
            case MIN -> pickAreaFilterOption(0, keysToSend);
            case MAX -> pickAreaFilterOption(1, keysToSend);
        }
        return this;
    }

    private enum AreaFields{
        MIN, MAX
    }
}
