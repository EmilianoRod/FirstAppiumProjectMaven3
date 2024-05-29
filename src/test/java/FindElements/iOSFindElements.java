package FindElements;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class iOSFindElements {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        WebElement activityIndicatorsTitle = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(activityIndicatorsTitle.getText());

        activityIndicatorsTitle = driver.findElements(AppiumBy.className("XCUIElementTypeStaticText"))
                .get(1);
        System.out.println(activityIndicatorsTitle.getText());

        activityIndicatorsTitle = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(activityIndicatorsTitle.getText());

        activityIndicatorsTitle = driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println(activityIndicatorsTitle.getText());

        activityIndicatorsTitle = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(activityIndicatorsTitle.getText());

//        activityIndicatorsTitle = driver.findElement(AppiumBy.tagName("Activity Indicators"));
//        System.out.println(activityIndicatorsTitle.getText());


    }
}
