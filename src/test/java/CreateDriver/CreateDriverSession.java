package CreateDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://127.0.0.1:4723/");

        switch (platformName) {
            case "Android":
//                caps.setCapability("deviceName", "pixel_8_pro");
                caps.setCapability("automationName", "uiautomator2");
//                caps.setCapability("udid", "emulator-5554");
//              caps.setCapability("avd", "Pixel_XL_API_30");
                caps.setCapability("udid", "48563be");
              caps.setCapability("avdLaunchTimeout", 180000);
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//                caps.setCapability("appPackage", "com.google.android.apps.maps");
//                caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
                caps.setCapability("app", "/Users/emilianorodriguez/Desktop/Appium/apps/ApiDemos-debug.apk");
                caps.setCapability("chromedriverExecutable", "/Users/emilianorodriguez/Desktop/chromedriver/chromedriver126.0.6478.126/chromedriver");
                caps.setCapability("unlockType", "pin");
                caps.setCapability("unlockKey", "0000");
                return new AndroidDriver(url, caps);

            case "iOS":
//              caps.setCapability("deviceName", "iPhone 14 Pro");
                caps.setCapability("automationName", "XCUITest");
//              caps.setCapability("udid", "A2D7F500-945B-4D3D-A356-2213AA25601C");
                //iPhone X uuid
                caps.setCapability("udid", "0178cb7d81c0e3f7398d4a497b384896d40b55b5");
//              caps.setCapability("app", "/Users/emilianorodriguez/Desktop/Appium/apps/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
                caps.setCapability("simulatorStartupTimeout", 180000);
//              caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                caps.setCapability("bundleId", "com.ubercab.UberClient");
                caps.setCapability("autoAcceptAlerts", true);

                caps.setCapability("includeSafariInWebviews", true);
                caps.setCapability("absoluteWebLocations", true);
                caps.setCapability("safariGarbageCollect", true);
                caps.setCapability("enableAsyncExecuteFromHttps", true);
//                caps.setCapability("autoWebview", true);
                caps.setCapability("webviewConnectTimeout", 90000);
                caps.setCapability("webviewConnectTimeout", "90000");
//              caps.setCapability("bundleId", "com.apple.Maps");

                 caps.setCapability("xcodeOrgId", "F44N5MSDA3");
                 caps.setCapability("xcodeSigningId", "iPhone Developer");
                return new IOSDriver(url, caps);

            default:
                throw new Exception("invalid platform");
        }
    }
}
    