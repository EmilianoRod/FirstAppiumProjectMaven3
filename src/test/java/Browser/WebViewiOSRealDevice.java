package Browser;

import CreateDriver.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.time.Duration;
import java.util.Set;

public class WebViewiOSRealDevice {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(AppiumBy.accessibilityId("Get started")).click();
        driver.findElement(AppiumBy.accessibilityId("Continue with Google")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Continue")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Acceso: Cuentas de Google\"`]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]"));

        Set<String> contextHandles = ((IOSDriver) driver).getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }
        ((IOSDriver) driver).context(contextHandles.toArray()[1].toString());

        driver.quit();
    }

}



//#hplogo
