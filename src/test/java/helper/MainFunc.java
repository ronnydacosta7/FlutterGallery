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

    public void click(String id) {
        Actions action = new Actions(driver);
        MobileElement element  = findElementByIdOrXpath(id);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        action.click(element).perform();
    }

    public void swipeLeftUntilFindElement(MobileElement elmnt, String id) {
        TouchAction touchAction = new TouchAction(driver);
        int moveTo = elmnt.getLocation().getX(); //x
        int y = elmnt.getLocation().getY(); //y
        int end = elmnt.getSize().getWidth(); //
        int start = (int) (end * 0.7);

        while (isElementDisplayed(id) == false) {
            touchAction.longPress(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
        }
    }

    public boolean isElementDisplayed(String id){
        try{
            return findElementByIdOrXpath(id).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void inputText(String element, String text) throws InterruptedException {
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
        click(openMenu);
        click(closeMenu);
    }

    public MobileElement findElementByIdOrXpath(String string){
        if(string.contains("//")){
            return driver.findElementByXPath(string);
        }
        return driver.findElementByAccessibilityId(string);
    }

}
