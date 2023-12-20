package pages.filters.price;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DiscoverPage;
import pages.ResultsPage;
import utils.CustomMethods;


public class FilterPricePage {

    private WebDriver driver;

    public FilterPricePage(WebDriver driver){
        this.driver = driver;
    }

    private final By FromAndToFields = By.xpath("//input[contains(@class,'pointer-events-auto ')]");
    private final By applyPriceFilterBtn = By.xpath("//button[contains(@class,'500 bg-p')]");
    private final By downPaymentBtn = By.xpath("//button[contains(@class,'hover:bg-gray-50')][1]");
    private final By installmentsBtn = By.xpath("//button[contains(@class,'hover:bg-gray-50')][2]");

    public DiscoverPage and(){
        applyFilter();
        CustomMethods.waitForUrlToChange(driver);
        return new DiscoverPage(driver);
    }
    public ResultsPage applyFilter(){
        CustomMethods.findElementPresence(driver, applyPriceFilterBtn).click();

        return new ResultsPage(driver);
    }

    public FilterPricePage clickDownPayment(){
        CustomMethods.findElementPresence(driver, downPaymentBtn).click();

        return this;
    }

    public FilterPricePage clickInstallments(){
        CustomMethods.findElementPresence(driver, installmentsBtn).click();

        return this;
    }
    public FilterPricePage setPriceFromToField(FilterPriceEnumMaps.PriceValue fromValue, FilterPriceEnumMaps.PriceValue toValue){
        FilterPriceEnumMaps.PriceValue.initializeMaps(fromValue);
        int toIndex;
        int fromIndex = FilterPriceEnumMaps.PRICES_FROM_MAP.get(fromValue);

        if(FilterPriceEnumMaps.PRICES_TO_MAP.get(toValue) != null){
            toIndex = FilterPriceEnumMaps.PRICES_TO_MAP.get(toValue);
        } else {
            throw new NullPointerException("NUllPointer : There's no value associated for this key" + "\n"
                    + "the \"1 index\" value in the \"PRICES_TO_MAP\" is : " + FilterPriceEnumMaps.PRICES_TO_MAP.keySet().toArray()[0]
             + "'TO VALUE' cannot be less than 'FROM VALUE'");
        }

        setFromAndToFields(fromIndex, toIndex);

        return this;
    }
    public FilterPricePage setDownPaymentFromToField(FilterPriceEnumMaps.DownPaymentValue fromValue, FilterPriceEnumMaps.DownPaymentValue toValue){
        FilterPriceEnumMaps.DownPaymentValue.initializeMaps(fromValue);

        int fromIndex = FilterPriceEnumMaps.DOWN_PAYMENT_FROM_MAP.get(fromValue);
        int toIndex;

        if(FilterPriceEnumMaps.DOWN_PAYMENT_TO_MAP.get(toValue) != null){
            toIndex = FilterPriceEnumMaps.DOWN_PAYMENT_TO_MAP.get(toValue);
        } else {
            throw new NullPointerException("NUllPointer : There's no value associated for this key" + "\n"
                    + "the \"1 index\" value in the \"DOWN_PAYMENT_TO_MAP\" is : " + FilterPriceEnumMaps.DOWN_PAYMENT_TO_MAP.keySet().toArray()[0]
                    + "'TO VALUE' cannot be less than 'FROM VALUE'");
        }

        setFromAndToFields(fromIndex, toIndex);

        return this;
    }
    public FilterPricePage setInstallmentFromToField(FilterPriceEnumMaps.InstallmentValue fromValue, FilterPriceEnumMaps.InstallmentValue toValue){
        FilterPriceEnumMaps.InstallmentValue.initializeMaps(fromValue);

        int fromIndex = FilterPriceEnumMaps.INSTALLMENT_FROM_MAP.get(fromValue);
        int toIndex;

        if(FilterPriceEnumMaps.INSTALLMENT_TO_MAP.get(toValue) != null){
            toIndex = FilterPriceEnumMaps.INSTALLMENT_TO_MAP.get(toValue);
        } else {
            throw new NullPointerException("NUllPointer : There's no value associated for this key" + "\n"
                    + "the \"1 index\" value in the \"INSTALLMENT_TO_MAP\" is : " + FilterPriceEnumMaps.INSTALLMENT_TO_MAP.keySet().toArray()[0]
                    + "'TO VALUE' cannot be less than 'FROM VALUE'");
        }

        setFromAndToFields(fromIndex, toIndex);

        return this;
    }
    private FilterPricePage setFromAndToFields(int fromValue, int toValue){
        setFromPrice(fromValue);
        setToPrice(toValue);

        return this;
    }
    private FilterPricePage setFromPrice(int fromValue){
        pickPriceField("from");
        pickRangeOption(fromValue);

        return this;
    }

    private FilterPricePage setToPrice(int toValue){
        pickPriceField("to");
        pickRangeOption(toValue);

        return this;
    }

    private FilterPricePage pickPriceField(String fieldName){

        switch (fieldName.toLowerCase()) {
            case "from" -> clickPriceField(0);
            case "to" -> clickPriceField(1);

        }
        return this;
    }

    private FilterPricePage clickPriceField(int fieldIndex){
        CustomMethods.findDuplicationIndex(driver, FromAndToFields, fieldIndex).click();
        return this;
    }

    private FilterPricePage pickRangeOption(int priceIndex){
        Actions actions = new Actions(driver);
        actions.pause(1000).click(CustomMethods.findElementPresence(driver,
                        By.xpath("//li[contains(@class,'relative')][" + priceIndex +"]")))
                .pause(500).build().perform();

        return this;
    }
}
