package FindElements;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


//docs::
// https://academy.realm.io/posts/nspredicate-cheatsheet/
// https://appium.github.io/appium-xcuitest-driver/7.9/reference/element-attributes/
// https://appium.github.io/appium-xcuitest-driver/7.9/reference/locator-strategies/
// https://appium.github.io/appium-xcuitest-driver/7.9/reference/ios-predicate/

public class iOSPredicateString {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        WebElement activityIndicatorTitle2 = driver
                .findElement((AppiumBy.iOSNsPredicateString("name == \"Activity Indicators\"")));
        System.out.println(activityIndicatorTitle2.getText());

        activityIndicatorTitle2 = driver
                .findElement((AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\"")));
        System.out.println(activityIndicatorTitle2.getText());

        activityIndicatorTitle2 = driver
                .findElement((AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeStaticText\" OR name == \"Activity Indicators\"")));
        System.out.println(activityIndicatorTitle2.getText());

        activityIndicatorTitle2 = driver
                .findElements((AppiumBy.iOSNsPredicateString("name == \"Alert Views\" OR name == \"Activity Indicators\"")))
                .get(1);
        System.out.println(activityIndicatorTitle2.getText());

        activityIndicatorTitle2 = driver
                .findElement((AppiumBy.iOSNsPredicateString("name CONTAINS \"Activity Indicators\"")));
        System.out.println(activityIndicatorTitle2.getText());

        activityIndicatorTitle2 = driver
                .findElement((AppiumBy.iOSNsPredicateString("label CONTAINS \"Activity Indicators\"")));
        System.out.println(activityIndicatorTitle2.getText());


//        WebElement activityIndicatorsTitle = driver
//                .findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
//        System.out.println(activityIndicatorsTitle.getText());
    }

}
