package pages.developers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IcaptialDeveloperUnits {

    private WebDriver driver;

    public IcaptialDeveloperUnits(WebDriver driver){
        this.driver = driver;
    }

    private final By orlaResidence1 = By.xpath("//a[@href='/units/apartment-for-sale-in-orla-residence']");
    private final By orlaResidence2 = By.xpath("//a[@href='/units/apartment-for-sale-in-orla-residence-2']");
    private final By orlaResidence3 = By.xpath("//a[@href='/units/luxury-apartment-for-sale-in-orla-residence']");



}
