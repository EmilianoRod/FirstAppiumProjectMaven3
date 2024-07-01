package WebView;

import CreateDriver.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebViewInspectUsingAI {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Android
      /*  driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Scroll
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        //Navigate to the Web View 2 screen
        driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
        Thread.sleep(3000);

        //Imprimiendo el titlulo de la screen
        System.out.println(driver.findElement(AppiumBy.
                androidUIAutomator("new UiSelector().text(\"This page is a Second Selenium sandbox\")")).getText());
*/

        //iOS: iOS: iOS: iOS: iOS: iOS: iOS: iOS: iOS: iOS: iOS:

        //swipe
        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);


        //Navigate to the screen
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(3000);


        //Print heading text from web view
        System.out.println(driver.findElement(AppiumBy
                .accessibilityId("This is HTML content inside a WKWebView ."))
                .getAttribute("label"));
    }
}
