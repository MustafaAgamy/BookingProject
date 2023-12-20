package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericProjectPage {

    private WebDriver driver;
    private final By startingFromElement = By.xpath("//div[contains(@class,'text-[20px]')]");
    private final By downMonthlyPayments =By.xpath("//div[contains(@class,'text-[22px]')]");
    private final By projectInfo = By.xpath("//div[contains(@class,'mt-2 t')]");
    private final By projectTitle = By.xpath("//h1[contains(@class,'text[18px]')]");
    private final By projectPropertiesTypes = By.xpath("//h4[@class='text-base font-medium text-black']");

    public GenericProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getProjectTitle() { return CustomMethods.findElementPresence(driver, projectTitle).getText(); }
    private String getDeliveryInfo(){
        return  pickProjectInfoField(ProjectInfo.DELIVERY);
    }
    private String getPaymentOptionInfo(){
        return  pickProjectInfoField(ProjectInfo.PAYMENT_OPTION);
    }
    private String getMaintenanceFeesInfo(){
        return  pickProjectInfoField(ProjectInfo.MAINTENANCE_FEES);
    }
    private int getMinMonthlyPaymentPrice(){
        return  getPriceField(PaymentsValues.MONTHLY_PAYMENT);
    }
    private int getMinDownPaymentPrice(){
        return  getPriceField(PaymentsValues.DOWN_PAYMENT);
    }
    private int getStartingFromPrice(){ return  getPriceField(PaymentsValues.STARTING_FROM); }

    private int getPriceField(PaymentsValues paymentsValues){
        Pattern pattern = Pattern.compile("\\b(\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?)\\b");
        Matcher matcher;
        String oldPrice = pickPaymentField(paymentsValues);

        int price = 0;
        String priceListNumber = oldPrice.replaceAll("EGP", "");
        matcher = pattern.matcher(priceListNumber);
        if (matcher.find()) {
            String matchString1 = matcher.group(1);
            price = Integer.parseInt(matchString1.replaceAll(",",""));
        }
        return price;
    }

    public HashMap<String, Object> projectDetailsMap(){
        HashMap<String, Object> projectDetailsMap = new HashMap<>();

        projectDetailsMap.put("title", getProjectTitle());
        projectDetailsMap.put("startingFrom", getStartingFromPrice());
        projectDetailsMap.put("minDownPayment", getMinDownPaymentPrice());
        projectDetailsMap.put("minMonthlyPayment", getMinMonthlyPaymentPrice());
        projectDetailsMap.put("deliveryInfo", getDeliveryInfo());
        projectDetailsMap.put("paymentOptionInfo", getPaymentOptionInfo());
        projectDetailsMap.put("maintenanceFeesInfo", getMaintenanceFeesInfo());

        return projectDetailsMap;
    }

    private String pickProjectInfoField(ProjectInfo projectInfo){
        switch (projectInfo){
            case DELIVERY -> {
                try {
                    return getProjectInfoDetails(0);
                } catch (IndexOutOfBoundsException e){
                    return "";
                }
            }
            case PAYMENT_OPTION -> {
                try {
                    return getProjectInfoDetails(1);
                } catch (IndexOutOfBoundsException e){
                    return "";
                }
            }
            default -> {
                try {
                    return getProjectInfoDetails(2);
                } catch (IndexOutOfBoundsException e){
                    return "";
                }
            }
        }
    }

    private String pickPaymentField(PaymentsValues paymentValue){
        switch (paymentValue) {
            case DOWN_PAYMENT -> {
                return getDownMonthlyPaymentLocator(0);
            }

            case MONTHLY_PAYMENT -> {
                return getDownMonthlyPaymentLocator(1);
            }
            default -> {
                return CustomMethods.findElementPresence(driver, startingFromElement).getText();
            }
        }
    }

    private String getProjectInfoDetails(int locatorIndex){
        return CustomMethods.findDuplicationIndex(driver, projectInfo, locatorIndex).getText();
    }

    private String getDownMonthlyPaymentLocator(int locatorIndex){
        return CustomMethods.findDuplicationIndex(driver, downMonthlyPayments, locatorIndex).getText();
    }

    private enum PaymentsValues {
        DOWN_PAYMENT, MONTHLY_PAYMENT, STARTING_FROM
    }

    private enum ProjectInfo {
        DELIVERY, PAYMENT_OPTION, MAINTENANCE_FEES
    }

    private enum ProjectProperties{

    }
}
