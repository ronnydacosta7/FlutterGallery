package helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.messages.internal.com.google.common.collect.ImmutableMap;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import setup.Config;

import java.util.concurrent.TimeUnit;

public class MainFunc extends Config {

    String openMenu = "Open menu";
    String closeMenu = "Close menu";

    public void clickElementById(String id) {
        Actions action = new Actions(driver);
        MobileElement form = driver.findElementByAccessibilityId(id);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        action.click(form).perform();
    }

    public void clickElementByXpath(String xPath) {
        Actions action = new Actions(driver);
        MobileElement form = driver.findElementByXPath(xPath);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        action.click(form).perform();
    }

    public void swipeLeftUntilFindElement(MobileElement elmnt, String id) {
        TouchAction touchAction = new TouchAction(driver);
        int moveTo = elmnt.getLocation().getX(); //x
        int y = elmnt.getLocation().getY(); //y
        int end = elmnt.getSize().getWidth(); //
        int start = (int) (end * 0.7);

        while (isElementDisplayedById(id) == false) {
            touchAction.longPress(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
        }
    }

    public boolean isElementDisplayedById(String a){
        try{
            return driver.findElementByAccessibilityId(a).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isElementDisplayedByXpath(String a){
        try{
            return driver.findElementByXPath(a).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void input(String element, String text) throws InterruptedException {
        Actions action = new Actions(driver);
        MobileElement form = (MobileElement) driver.findElementByXPath(element);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        form.click();
        //Wait until keyboard is shown
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.isKeyboardShown();
        action.sendKeys(text).perform();

        //Hide the keyboard
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
        //driver.hideKeyboard();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void refreshElement(){
        clickElementById(openMenu);
        clickElementById(closeMenu);
    }

}
