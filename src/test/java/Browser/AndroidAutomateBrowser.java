package Browser;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
//        driver.findElement(AppiumBy.xpath("//*[@id=\"tds-site-header\"]/ol/li/button")).click();
//        Thread.sleep(5000);


        //Tap on the menu button
        driver.findElement(AppiumBy.xpath("//span[normalize-space()='Menu']")).click();
        Thread.sleep(5000);

        //Tap on the Vehicles option
        driver.findElement(AppiumBy.xpath("//*[@id=\"dx-nav-item--vehicles\"]/span")).click();
        Thread.sleep(5000);

        //Tap on the Order button of the Model X vehicle
        driver.findElement(AppiumBy.xpath("(//a[@href='/modelx/design'])[1]")).click();
        Thread.sleep(9000);



        //Scroll down until continue button (doesn't work)
        // Realiza el scroll hasta que el botón "Continue" o "Continuar" sea visible

//        WebElement continueButton = driver.findElement(AppiumBy
//                .xpath("//button[@class='tds-btn tds-btn--primary tds-btn--large tds-btn--width-full action-trigger--link continue-to-payment-btn']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);



        for (int i = 0; i < 8; i++) {
            System.out.println("swiping");
            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", 150, "top", 150, "width", 200, "height", 300,
                    "direction", "up",
                    "percent", 0.75
            ));

            Thread.sleep(3000);
        }



        //Tap on the Continue button
        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(AppiumBy
                .xpath("//button[@class='tds-btn tds-btn--primary tds-btn--large tds-btn--width-full action-trigger--link continue-to-payment-btn']"));
        continueButton.click();
        Thread.sleep(6000);



        //Tap on the Order with Card button
        driver.findElement(AppiumBy.xpath("//main[@id=\"main-content\"]/section/div/div/div[4]/div/div/div[6]/div/div/div/div[1]/div/div[2]/div/div[1]/button")).click();
        Thread.sleep(5000);

        //Enter our first name
        WebElement nameInput = driver.findElement(AppiumBy.xpath("//input[@name=\"firstName\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameInput);
        nameInput.sendKeys("Emiliano");


        Thread.sleep(3000);


    }
}

