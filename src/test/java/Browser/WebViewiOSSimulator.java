package Browser;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WebViewiOSSimulator {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        //Scroll down
        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);


        //Tap on the Web View button
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(10000);

        Set<String> contextHandles = ((IOSDriver) driver).getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }

        ((IOSDriver) driver).context(contextHandles.toArray()[1].toString());
        System.out.println( driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        ((IOSDriver) driver).context("NATIVE_APP");
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
        driver.quit();
    }
}
