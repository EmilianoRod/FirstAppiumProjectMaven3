package AppiumDriverCommands;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class iOSInteractingWithKeyboard {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //swipe
        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);


        //Navigating to the editable field
        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.xpath("(//XCUIElementTypeTextField[@value=\"Placeholder text\"])[1]")).click();
        Thread.sleep(3000);

        //Presing keys on the keyboard
        driver.findElement(AppiumBy.accessibilityId("q")).click();
        driver.findElement(AppiumBy.accessibilityId("w")).click();
        driver.findElement(AppiumBy.accessibilityId("e")).click();
        Thread.sleep(3000);
//        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        //We can use: (It doesn't always work on real devices)
        ((IOSDriver) driver).hideKeyboard();


    }
}
