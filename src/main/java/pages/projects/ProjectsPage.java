package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.wonderMarQMostakbal.WonderMostakbalProject;
import utils.CustomMethods;

public class ProjectsPage {

    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By theWonderMostakbalProject = By.xpath("//a[@href='/discover/tab-projects?drawer_id=list_185']");
    private final By expandProjectBtn = By.xpath("//a[@href='/projects/the-wonder-marq-mostakbal-city']");
    private final By threePointsNewCapitalProject = By.xpath("//a[@href='/discover/tab-projects?drawer_id=list_543']");

    public ProjectsPage pickProject(ProjectsEnumMaps.ProjectsNames projectName){
        int projectIndex = ProjectsEnumMaps.PROJECTS_LOCATORS_MAP.get(projectName);
        projectsDynamicLocators(projectIndex);

        return this;
    }

    public GenericProjectPage navigateToProjectPage(ProjectsEnumMaps.ProjectsNames projectName){
        String mainWindowHandle = driver.getWindowHandle();

        String project = ProjectsEnumMaps.PROJECTS_EXPAND_BTN_MAP.get(projectName);
        projectExpandBtnDynamicLocators(project);

        CustomMethods.switchToOpenWindow(driver, mainWindowHandle);

        return new GenericProjectPage(driver);
    }

    private ProjectsPage projectsDynamicLocators(int projectIndex){
        CustomMethods.findElementPresence(driver,
        By.xpath("//a[@href='/discover/tab-projects?drawer_id=list_" + projectIndex + "']"))
                .click();

        return this;
    }
    private ProjectsPage projectExpandBtnDynamicLocators(String projectName){
        CustomMethods.findElementPresence(driver,
                        By.xpath("//a[@href='/projects/" + projectName + "']"))
                .click();

        return this;
    }

    public WonderMostakbalProject navigateToProjectPage(){
        String mainWindowHandle = driver.getWindowHandle();
        CustomMethods.findElementPresence(driver, expandProjectBtn).click();
        CustomMethods.switchToOpenWindow(driver, mainWindowHandle);

        return new WonderMostakbalProject(driver);
    }

    public WonderMostakbalProject navigateToWonderMostakbal(){
       String mainWindowHandle = driver.getWindowHandle();
        CustomMethods.findElementPresence(driver, expandProjectBtn).click();
        CustomMethods.switchToOpenWindow(driver, mainWindowHandle);

        return new WonderMostakbalProject(driver);
    }

    public ThreePointsNewCapitalProject navigateToThreePointsNewCapital(){
        String mainWindowHandle = driver.getWindowHandle();
        CustomMethods.findElementPresence(driver, expandProjectBtn).click();
        CustomMethods.switchToOpenWindow(driver, mainWindowHandle);

        return new ThreePointsNewCapitalProject(driver);
    }
}
