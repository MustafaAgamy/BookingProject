package pages.projects.wonderMarQMostakbal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class WonderMostakbalProject {

    private WebDriver driver;
    private static final LinkedHashMap<Integer,String>WONDER_MOSTAKBAL_MAP = new LinkedHashMap<>();

    public WonderMostakbalProject(WebDriver driver) {
        this.driver = driver;
    }

    private final By startingFromElement = By.xpath("//div[contains(@class,'text-[20px]')]");
    private final By downMonthlyPayments =By.xpath("//div[contains(@class,'text-[22px]')]");
    private String getStartingFrom(){
        return CustomMethods.findElementPresence(driver, startingFromElement).getText();
    }


    public HashMap<Integer,String> returnText(){
       WONDER_MOSTAKBAL_MAP.put(0,getStartingFrom());
       WONDER_MOSTAKBAL_MAP.put(1,getDownPaymentValue());
       WONDER_MOSTAKBAL_MAP.put(2,getMonthlyPaymentValue());

       return WONDER_MOSTAKBAL_MAP;
    }

    public String getDownPaymentValue(){
      return  pickDownMonthlyPayments(DownMonthlyPayments.DOWN_PAYMENT);
    }

    public String getMonthlyPaymentValue(){
       return pickDownMonthlyPayments(DownMonthlyPayments.MONTHLY_PAYMENT);
    }

    private String pickDownMonthlyPayments(DownMonthlyPayments paymentValue){
        switch (paymentValue) {
            case DOWN_PAYMENT -> {
                return getDownMonthlyPaymentLocator(0);
            }

            case MONTHLY_PAYMENT -> {
                return getDownMonthlyPaymentLocator(1);
            }
        }
        return "";
    }

    private String getDownMonthlyPaymentLocator(int locatorIndex){
        return CustomMethods.findDuplicationIndex(driver, downMonthlyPayments, locatorIndex).getText();
    }
    private enum DownMonthlyPayments {
        DOWN_PAYMENT, MONTHLY_PAYMENT
    }
}
