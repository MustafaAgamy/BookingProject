package pages.projects.wonderMarQMostakbal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.GenericProjectPage;
import utils.CustomMethods;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempClass {

    private WebDriver driver;
    private final By startingFromElement = By.xpath("//div[contains(@class,'text-[20px]')]");
    private final By downMonthlyPayments =By.xpath("//div[contains(@class,'text-[22px]')]");

    public TempClass(WebDriver driver) {
        this.driver = driver;
    }


    private int getMinMonthlyPaymentPrice(){
        return  getPriceField(driver,downMonthlyPayments,1);
    }
    private int getMinDownPaymentPrice(){
        return  getPriceField(driver,downMonthlyPayments, 0);
    }
    private int getStartingFromPrice(){
        return  getPriceField(driver,startingFromElement);
    }
    private int getPriceField(WebDriver driver, By locator){
        return getPriceField(driver, locator, null);
    }

    private int getPriceField(WebDriver driver, By locator, Integer elementIndex){
        Pattern pattern = Pattern.compile("\\b(\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?)\\b");
        Matcher matcher;
        String oldPrice;
        if(elementIndex != null){
            oldPrice = CustomMethods.findDuplicationIndex(driver, locator, elementIndex).getText();

        } else{
            oldPrice = CustomMethods.findElementPresence(driver, locator).getText();
        }
        int price = 0;
        String priceListNumber = oldPrice.replaceAll("EGP", "");
        matcher = pattern.matcher(priceListNumber);
        if (matcher.find()) {
            String matchString1 = matcher.group(1);
            price = Integer.parseInt(matchString1.replaceAll(",",""));
        }
        return price;
    }


    public HashMap<String, Integer> projectDetailsMap(){
        HashMap<String, Integer> projectDetailsMap = new HashMap<>();

        projectDetailsMap.put("startingFrom", getStartingFromPrice());
        projectDetailsMap.put("minDownPayment", getMinDownPaymentPrice());
        projectDetailsMap.put("minMonthlyPayment", getMinMonthlyPaymentPrice());

        return projectDetailsMap;
    }
}
