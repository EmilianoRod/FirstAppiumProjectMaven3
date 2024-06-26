package FindElements;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {

    public static void main(String[] args) throws Exception {
//      AppiumDriver driver = CreateDriver.CreateDriverSession.initializeDriver("Android");
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");


//      By accessibility = AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")");
        By accessibility = AppiumBy.iOSNsPredicateString("name == \"Activity Indicators\"");

        System.out.println("label:" + driver.findElement(accessibility).getText());
        System.out.println("label:" + driver.findElement(accessibility).getAttribute("label"));
//      System.out.println("checked:" + driver.findElement(accessibility).getAttribute("checked"));

        //The value attribute is a very important one
        System.out.println("value:" + driver.findElement(accessibility).getAttribute("value"));

        System.out.println("enabled:" + driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("selected:" + driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("visible:" + driver.findElement(accessibility).getAttribute("visible"));


        System.out.println("selected:" + driver.findElement(accessibility).isSelected());
        System.out.println("enabled:" + driver.findElement(accessibility).isEnabled());
        System.out.println("displayed:" + driver.findElement(accessibility).isDisplayed());
    }
}
// How to fetch element attributes??