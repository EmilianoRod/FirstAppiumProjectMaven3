package Browser;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver appiumDriver = CreateBrowserSession.initializeDriver("iOS");
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));

        appiumDriver.get("https://www.tesla.com");
        Thread.sleep(3000);


        //Click to close the region
//        appiumDriver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/dialog/div[1]/button[1]/svg")).click();
//        Thread.sleep(3000);


        //Click on menu button
        appiumDriver.findElement(By.xpath("//*[@id=\"tds-site-header\"]/ol/li/button")).click();
        Thread.sleep(3000);


        //Click on Vehicles
        appiumDriver.findElement(By.xpath("//*[@id=\"dx-nav-item--vehicles\"]")).click();
        Thread.sleep(3000);


        //Click on order Model X
        appiumDriver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/dialog/div[2]/div/div[1]/div[3]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);


        for (int i = 0; i < 3; i++) {
            JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("velocity", 2500);
            js.executeScript("mobile: swipe", params);
            Thread.sleep(2000);
        }


        //Click on the Continue button
        appiumDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[9]/div/div/div[3]/button")).click();
        Thread.sleep(3000);


        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("velocity", 500);
        js.executeScript("mobile: swipe", params);
        Thread.sleep(2000);


        //Click on the order with card button
        appiumDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[4]/div/div/div[6]/div/div/div/div[1]/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(3000);

        //Enter name
        appiumDriver.findElement(By.xpath("//*[@id=\"FIRST_NAME\"]")).sendKeys("Emiliano");
        Thread.sleep(3000);


    }
}
