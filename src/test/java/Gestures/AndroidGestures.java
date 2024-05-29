package Gestures;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;


public class AndroidGestures {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
//        longClickGesture(driver);
//        clickGesture(driver);
//        dragGesture(driver);
//        pinchOpenGesture(driver);
//        swipeGesture(driver);
        scrollGesture(driver);
    }


    public static void longClickGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //You can use elementId or Coordinates
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
//                "x", 217 ,
//                "y", 659 ,
                "duration", 1000
        ));
    }


    public static void clickGesture(AppiumDriver driver){
        WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) views).getId()
        ));
    }


    public static void dragGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 650,
                "endY", 580
        ));
    }


    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }


    public static void swipeGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement firstImage = driver.findElement(AppiumBy
                .androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId", ((RemoteWebElement) firstImage).getId(),
                "direction", "left",
                "percent", 0.25
        ));

        /*        WebElement listContainer= driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId", ((RemoteWebElement) listContainer).getId(),
                "direction", "up",
                "percent", 0.75
        ));*/
    }


    public static void scrollGesture(AppiumDriver driver) throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(2000);
//        WebElement listContainer= driver.findElement(AppiumBy.id("android:id/list"));
        WebElement animationButton = driver.findElement(AppiumBy.accessibilityId("Animation"));

        boolean canScrollMore = true;
        while(canScrollMore){
             canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
//                "elementId", ((RemoteWebElement) animationButton).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }
    }









}





