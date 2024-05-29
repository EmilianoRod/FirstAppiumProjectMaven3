package FindElements;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElements {
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
    @iOSXCUITFindBy(accessibility = "Accesibility")
    private static WebElement myElement4;

    public DifferentWaysOfDefiningElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        DifferentWaysOfDefiningElements differentWaysOfDefiningElements = new DifferentWaysOfDefiningElements(driver);
        System.out.println(myElement4.getText());


        WebElement myElement1 = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(myElement1.getText());


        By myELement2 = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(driver.findElement(myELement2).getText());

        By myElement3 = AppiumBy.accessibilityId("Accessibility");
        System.out.println(driver.findElement(myElement3).getText());
    }
}

//WebElement, By, MobileBy, @FindBy, @AndroidFindBy, @iOSXCUITFindBy
