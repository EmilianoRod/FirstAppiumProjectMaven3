package Gestures;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class iOSGestures {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
//        swipeGesture(driver);
//        scrollGesture(driver);
//        pinchGesture(driver);
        touchAndHold(driver);
    }

//    public static void swipeGesture(AppiumDriver driver) {
//        WebElement element = driver.findElement(AppiumBy.
//                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "up");
////        params.put("velocity", 2500);
//        params.put("elementId", ((RemoteWebElement) element).getId());
//        driver.executeScript("mobile: swipe", params);
//    }

    public static void scrollGesture(AppiumDriver driver) {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("direction", "down");
        driver.executeScript("mobile: scroll", params1);


        WebElement childElement = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "down");
        params.put("elementId", ((RemoteWebElement) childElement).getId());
//        params.put("predicateString", "label == \"Web View\"");
        params.put("toVisible", true);
        driver.executeScript("mobile: scroll", params);
    }


    public static void pinchGesture(AppiumDriver driver) {
        Map<String, Object> params1 = new HashMap<>();
        params1.put("scale", 20);
        params1.put("velocity", 2.2);
        driver.executeScript("mobile: pinch", params1);

        WebElement element = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeOther[`name == \"OverlayView\"`][1]"));

        Map<String, Object> params2 = new HashMap<>();
        params2.put("elementId", ((RemoteWebElement) element).getId());
        params2.put("scale", 0.1);
        params2.put("velocity", -2.2);
        driver.executeScript("mobile: pinch", params2);
    }



    public static void touchAndHold(AppiumDriver driver) {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[13]/XCUIElementTypeOther[1]/XCUIElementTypeOther")).click();

        WebElement element = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile: touchAndHold", params);

    }



}












