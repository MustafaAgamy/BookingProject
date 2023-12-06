package pages.developers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

public class DevelopersPage {
    private WebDriver driver;

    public DevelopersPage(WebDriver driver) {
        this.driver = driver;
    }

    public DeveloperDetailsPage pickDeveloper(DevelopsEnumMaps.Developers developersName){
        String developer = DevelopsEnumMaps.DEVELOPERS_MAP.get(developersName);
        developersDynamicLocators(developer);
        return new DeveloperDetailsPage(driver);
    }
    private void developersDynamicLocators(String developerName){
        CustomMethods.findElementPresence(driver,
                By.xpath("//a[@href='/developers/" + developerName + "']")).click();
    }
}
