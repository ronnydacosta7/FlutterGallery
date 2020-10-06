package setup;

import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Config {
    public static AndroidDriver<MobileElement> driver;
    public void setup(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "io.flutter.demo.gallery");
            caps.setCapability("appActivity", ".MainActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url,caps);
            Thread.sleep(4000);
        }catch(Exception exp) {
            System.out.println("Cause is : " + exp.getCause());
            System.out.println("Message is : " + exp.getMessage());
            exp.printStackTrace();
        }
    }
    public void tearDown(){
        driver.quit();
    }
}
