package pages.developers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomMethods;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDetailsPage {

    private WebDriver driver;

    public DeveloperDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By developerName = By.xpath("//h1[contains(@class,'text-2xl')]");
    private final By projectsTitles = By.xpath("//p[@class='break-words text-sm font-medium']");
    private final By projectsLinks = By.xpath("//a[contains(@href,'/projects/')]");
    private final By developerUnits = By.xpath("//a[contains(@href,'/units/')]");

    public String developersProject(){
        return CustomMethods.findElementPresence(driver, projectsTitles).getText();
    }
    public List<String> developersProjects(){
        List<WebElement> webElements = CustomMethods.findElementsPresence(driver, projectsTitles);
        List<String> projects = new ArrayList<>();
        for(WebElement webElement: webElements){
            projects.add(webElement.getText().toLowerCase());
        }
        String developer = CustomMethods.findElementPresence(driver, developerName).getText();
        projects.add(developer);

        return projects;
    }

    private DeveloperDetailsPage projectTitlesDynamicLocators(int titleIndex){
        CustomMethods.findDuplicationIndex(driver, projectsTitles, titleIndex).getText();

        return this;
    }

    private DeveloperDetailsPage projectLinksDynamicLocators(int titleIndex){
        CustomMethods.findDuplicationIndex(driver, projectsTitles, titleIndex).click();

        return this;
    }


}
