package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CustomMethods {

    public static Boolean Test(WebDriver driver , By by){
        return wait(driver,50).until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
    }
    public static List<WebElement> findElementsPresence(WebDriver driver , By by){
        return wait(driver,50).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static WebElement findElementPresence(WebDriver driver , By by){
        return wait(driver,50).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static WebElement findElementVisible(WebDriver driver , By by){
        return wait(driver,50).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static boolean waitForUrlNotToBe(WebDriver driver , String url){
        return wait(driver,120).until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public static boolean waitForUrlToBe(WebDriver driver , String url){
       return wait(driver,120).until(ExpectedConditions.urlToBe(url));
    }

    public static boolean waitForUrlToChange(WebDriver driver){
        String currentUrl = driver.getCurrentUrl();
       return waitForUrlNotToBe(driver, currentUrl);
    }
    public static boolean waitForUrlNotToChange(WebDriver driver){
        String currentUrl = driver.getCurrentUrl();
        return waitForUrlToBe(driver, currentUrl);
    }
    public static WebElement findDuplicationIndex(WebDriver driver, By locator, int elementIndex) {
            wait(driver, 50).until(ExpectedConditions
                    .not(ExpectedConditions.stalenessOf(driver.findElements(locator).get(elementIndex))));
            return wait(driver,50).until(ExpectedConditions.visibilityOf(driver.findElements(locator).get(elementIndex)));

    }

    public static WebElement waitForElementTextToLoad(WebDriver driver, By locator){
        wait(driver, 60).until(webDriver -> {
           WebElement webElement = CustomMethods.findElementPresence(driver, locator);
           return !(webElement.getText().isEmpty());
        });
          return CustomMethods.findElementPresence(driver, locator);
    }
    public static boolean waitForElementValueToBe(WebDriver driver, By locator, String value) {
        return wait(driver, 50).until(ExpectedConditions
                .attributeToBe(locator,"value", value));
    }

    public static boolean waitForElementToBeSelected(WebDriver driver, WebElement locator) {
        return wait(driver, 50).until(ExpectedConditions
                .elementToBeSelected(locator));
    }
    public static void switchToOpenWindow(WebDriver driver, String mainWindowHandle){
            Set<String> allWindowHandles = driver.getWindowHandles();
            for(String windowHandle : allWindowHandles){
                if(!windowHandle.equals(mainWindowHandle)){
                    driver.switchTo().window(windowHandle);
                }
            }
    }
    private static WebDriverWait wait(WebDriver driver, int timeOut){

//        wait.until((ExpectedCondition<Boolean>) d -> (Boolean) ((JavascriptExecutor) d).executeScript(
//                "return window.performance.getEntriesByType('resource').every(entry => entry.responseEnd > 0)"
//        ));
//        wait.until((ExpectedCondition<Boolean>) webDriver -> {
//            JavascriptExecutor js = (JavascriptExecutor) (driver);
//            boolean jqueryComplete = (Boolean) js.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
//            boolean javascriptComplete = (Boolean) js.executeScript("return document.readyState === 'complete';");
//            return jqueryComplete && javascriptComplete;
//        });

        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }


}
