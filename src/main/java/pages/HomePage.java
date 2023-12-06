package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.developers.DevelopersPage;
import pages.projects.ProjectsPage;
import utils.CustomMethods;


@SuppressWarnings({"unused","UnusedReturnValue"})
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
       this.driver = driver;
    }

    private final By discoverPageBtn = By.xpath("//a[@href='/discover']");
    private final By projectsPageBtn = By.xpath("//a[@href='/discover/tab-projects']");
    private final By developersPageBtn = By.xpath("//a[@href='/developers']");
    private final By signInBtn = By.xpath("//button[contains(@class,'ms-3.5')]");

    public DiscoverPage clickDiscoverBtn(){
        CustomMethods.findElementPresence(driver, discoverPageBtn).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new  DiscoverPage(driver);
    }

    public ProjectsPage clickProjectsBtn(){
        CustomMethods.findElementPresence(driver, projectsPageBtn).click();
        return new  ProjectsPage(driver);
    }

    public DevelopersPage clickDevelopersBtn(){
        CustomMethods.findElementPresence(driver, developersPageBtn).click();
        return new DevelopersPage(driver);
    }

    public SignInPage clickSignInBtn(){
        CustomMethods.findElementPresence(driver, signInBtn).click();

        return new SignInPage(driver);
    }
}
