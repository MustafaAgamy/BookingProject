package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unused","UnusedReturnValue"})
public class ResultsPage {

    private WebDriver driver;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By typeLabelFields = By.xpath("//p[@class='text-primary-green']");
    private final By areaLabelFields = By.xpath("//p[@class='space-x-1']//span[1]");
    private final By startingFromLabelFields = By.xpath("//h2[contains(@class, 'sp')]");
    private final By bedsLabelFields = By.xpath("//div[2]/div/div[2]/div[2]/div/div/div[1]");
    private final By bathsLabelFields = By.xpath("//div[2]/div/div[2]/div[2]/div/div/div[2]");
    private final By priceLabelFields = By.xpath("//p[contains(@class,'font-bold text-lg')]");
    private final By downPaymentLabelFields = By.xpath("//p[contains(@class,'text-lg font-bold')]");
    private final By installmentLabelFields = By.xpath("//p[contains(@class,'text-medium-gray')]");


    @Step
    public ResultsPage waitForUrlToChange(){
        CustomMethods.waitForUrlToChange(driver);
        return this;
    }

    @Step
    public List<List<Integer>> checkPriceRelatedFiltersApplied(){
       List<List<Integer>> allPriceFiltersList = new ArrayList<>();
       allPriceFiltersList.add(checkPriceFilterApplied());
       allPriceFiltersList.add(checkDownPaymentFilterApplied());
       allPriceFiltersList.add(checkInstallmentFilterApplied());

       return allPriceFiltersList;
    }

    @Step
    public List<List<String>> checkBedsBathsFilterApplied(){
        List<List<String>> bedsAndBathsArrayList = new ArrayList<>();
        bedsAndBathsArrayList.add(checkBedsFilterApplied());
        bedsAndBathsArrayList.add(checkBathsFilterApplied());
        return bedsAndBathsArrayList;
    }

    @Step
    public List<String> checkBedsFilterApplied(){
        return checkEveryStrResultFilterApplied(driver, bedsLabelFields);
    }

    @Step
    public List<String> checkBathsFilterApplied(){
        return checkEveryStrResultFilterApplied(driver, bathsLabelFields);
    }

    @Step
    public List<Integer> checkInstallmentFilterApplied() {
        return checkCurrencyRelatedFiltersApplied(driver, installmentLabelFields, " Monthly / 9 years");

    }

    @Step
    public List<Integer> checkDownPaymentFilterApplied(){
        return checkCurrencyRelatedFiltersApplied(driver, downPaymentLabelFields, "EGP");

    }

    @Step
    public List<Integer> checkPriceFilterApplied(){
      return checkCurrencyRelatedFiltersApplied(driver, priceLabelFields, "EGP");

    }



    private List<Integer> checkCurrencyRelatedFiltersApplied(WebDriver driver, By locator, String toBeRemoved){
        Pattern pattern = Pattern.compile("\\b(\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?)\\b");
        Matcher matcher;
        List<String> oldPricesList = checkEveryStrResultFilterApplied(driver, locator);
        List<Integer> newPricesList = new ArrayList<>();
        for(String priceList : oldPricesList) {
            String priceListNumber = priceList.replaceAll(toBeRemoved, "");
            matcher = pattern.matcher(priceListNumber);
            if (matcher.find()) {
                String matchString1 = matcher.group(1);
                int price = Integer.parseInt(matchString1.replaceAll(",",""));
                newPricesList.add(price);
            }
        }
        return newPricesList;
    }

    @Step
    public List<Integer> checkAreaFilterApplied(){
        return checkEveryIntResultFilterApplied(driver, areaLabelFields);
    }

    @Step
    public List<String> checkTypeFilterApplied() { return checkEveryStrResultFilterApplied(driver, typeLabelFields);}


    public List<Integer> checkEveryIntResultFilterApplied(WebDriver driver, By locator) {

        List<WebElement> webElementList = CustomMethods.findElementsPresence(driver, locator);
        List<Integer> webElementsTextList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            webElementsTextList.add(Integer.parseInt(webElement.getText()));
        }

        return webElementsTextList;
    }

    public List<String> checkEveryStrResultFilterApplied(WebDriver driver, By locator) {

        List<WebElement> webElementList = CustomMethods.findElementsPresence(driver, locator);
        List<String> webElementsTextList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            webElementsTextList.add(webElement.getText());
        }

        return webElementsTextList;
    }
}
