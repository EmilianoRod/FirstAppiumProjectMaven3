package Browser;

import CreateDriver.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://tesla.com");
        Thread.sleep(5000);

        //Tap to close the Region & Language dropdown
        driver.findElement(AppiumBy.xpath("//*[@id=\"mega-menu\"]/div/dialog/div[1]/button[1]")).click();
        Thread.sleep(5000);

        //Tap on the menu button
        driver.findElement(AppiumBy.xpath("//span[normalize-space()='Menu']")).click();
        Thread.sleep(5000);

        //Tap on the Vehicles option
        driver.findElement(AppiumBy.xpath("//button[@id='dx-nav-item--vehicles']//*[name()='svg']")).click();
        Thread.sleep(5000);

        //Tap on the Order button of the Model X vehicle
        driver.findElement(AppiumBy.xpath("//a[@href='/modelx/design']")).click();
        Thread.sleep(10000);



        //Scroll down until continue button (doesn't work)
        // Realiza el scroll hasta que el botón "Continue" o "Continuar" sea visible

//        WebElement continueButton = driver.findElement(AppiumBy
//                .xpath("//button[@class='tds-btn tds-btn--primary tds-btn--large tds-btn--width-full action-trigger--link continue-to-payment-btn']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", continueButton);

        for (int i = 0; i < 3; i++) {
            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "up",
                    "percent", 1
            ));
            Thread.sleep(3000);
        }

             Thread.sleep(5000);

        //Tap on the Continue button
        WebElement continueButton = driver.findElement(AppiumBy
                .xpath("//button[@class='tds-btn tds-btn--primary tds-btn--large tds-btn--width-full action-trigger--link continue-to-payment-btn']"));
        continueButton.click();
        Thread.sleep(5000);



        //Tap on the Order with Card button
        driver.findElement(AppiumBy.xpath("//main[@id=\"main-content\"]/section/div/div/div[4]/div/div/div[6]/div/div/div/div[1]/div/div[2]/div/div[1]/button")).click();
        Thread.sleep(5000);

        //Enter our first name
        driver.findElement(AppiumBy
                .xpath("//input[@name=\"firstName\"]"))
                .sendKeys("Emiliano");

        Thread.sleep(3000);


    }
}

