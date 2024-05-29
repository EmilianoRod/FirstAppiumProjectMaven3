package CreateDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {

    public static void main(String[] args) throws MalformedURLException {

/*        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Pixel XL API 30")
                .setAutomationName("uiautomator2")
                .setApp("/Users/erodriguez/Desktop/appium/lessons/appium/FirstAppiumProjectMaven2/src/test/resources/ApiDemos-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/");
        AppiumDriver driver = new AndroidDriver(url, options);*/

        XCUITestOptions options = new XCUITestOptions()
                //optional
                .setDeviceName("iPhone 15")
                //optional d
                .setAutomationName("XCUITest")
                .setApp("/Users/erodriguez/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app")
                .setUdid("A947527B-A8FA-4882-A24E-E9F0390D43DD");

        URL url = new URL("http://127.0.0.1:4723/");
        AppiumDriver driver = new IOSDriver(url, options);
    }
}
