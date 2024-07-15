package Browser;

import io.appium.java_client.AppiumDriver;

import java.time.Duration;

public class AndroidChromeDriverAutomatic {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(30));

        driver.get("https://tesla.com");

    }
}
