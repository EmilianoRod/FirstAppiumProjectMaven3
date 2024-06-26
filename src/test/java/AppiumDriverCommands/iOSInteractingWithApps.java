package AppiumDriverCommands;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSInteractingWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(5000);
        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));
        Thread.sleep(5000);
        ((IOSDriver) driver).terminateApp("com.example.apple-samplecode.UICatalog");
        Thread.sleep(5000);
        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));


//        ((IOSDriver) driver).installApp(
//                "/Users/emilianorodriguez/Desktop/Appium/apps/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app"
//        );

//        ((IOSDriver) driver).runAppInBackground(Duration.ofMillis(5000));

//        ((IOSDriver) driver).activateApp("com.apple.Preferences");
//        Thread.sleep(5000);
//        ((IOSDriver) driver).activateApp("com.example.apple-samplecode.UICatalog");



    }
}
