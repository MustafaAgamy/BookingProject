package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomMethods;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }
    private final By successfulLoginMsg = By.className("Toastify__toast-body");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmSignInBtn = By.xpath("//button[@type='submit']");

    @Step
    public SignInPage login(String email, String password){
        CustomMethods.findElementPresence(driver, emailField).sendKeys(email);
        CustomMethods.findElementPresence(driver, passwordField).sendKeys(password);
        CustomMethods.findElementPresence(driver, confirmSignInBtn).click();

        return this;
    }

    @Step
    public String getSuccessfulLoginMsg(){

        return CustomMethods.waitForElementTextToLoad(driver, successfulLoginMsg).getText();
    }
}
