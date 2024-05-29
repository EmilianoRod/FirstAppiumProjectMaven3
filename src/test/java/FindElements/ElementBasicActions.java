package FindElements;

import CreateDriver.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ElementBasicActions {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")");
        By textFields = AppiumBy.androidUIAutomator("new UiSelector().text(\"TextFields\")");
        By editText = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/edit\")");

        driver.findElement(views).click();

        //Swipe
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text emi");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
        Thread.sleep(3000);

    }
}


// click, sendKeys, clear