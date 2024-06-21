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
//        touchAndHold(driver);
//        tap(driver);
//        pickerWheel(driver);
        slider(driver);
    }




    public static void swipeGesture(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
//        params.put("velocity", 2500);
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
    }

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



    public static void tap(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Steppers"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("x", 0);
        params.put("y", 0);
        driver.executeScript("mobile: tap", params);
    }



    public static void pickerWheel(AppiumDriver driver){
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"chevron\"`][7]")).click();

        boolean flag = false;
        while(!flag){
            WebElement redPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Red color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(redPickerWheel.getAttribute("value").equals("90")){
                flag =  true;
            }
        }

         flag = false;
        while(!flag){
            WebElement greenPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Green color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) greenPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(greenPickerWheel.getAttribute("value").equals("190")){
                flag =  true;
            }
        }

         flag = false;
        while(!flag){
            WebElement bluePickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Blue color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) bluePickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(bluePickerWheel.getAttribute("value").equals("135")){
                flag =  true;
            }
        }
    }



    public static void slider(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));
        element.sendKeys("0");

        element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"0%\""));
        element.sendKeys("1");
    }





}












