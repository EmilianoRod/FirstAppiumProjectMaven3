package AppiumDriverCommands;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       By views = AppiumBy.accessibilityId("Views");
       driver.findElement(views).click();


       Thread.sleep(5000);
       System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
       Thread.sleep(5000);
       ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));


//        ((AndroidDriver) driver).runAppInBackground(Duration.ofMillis(5000));
        /*((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        ((AndroidDriver) driver).activateApp("com.android.settings");
        Thread.sleep(5000);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");*/

//        System.out.println(((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));
//       ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

//        ((AndroidDriver) driver).installApp("/Users/emilianorodriguez/Desktop/Appium/apps/ApiDemos-debug.apk",
//                new AndroidInstallApplicationOptions().withReplaceEnabled());


    }
}
