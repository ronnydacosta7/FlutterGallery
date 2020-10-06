package helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.messages.internal.com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
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

    public void swipeOnHalfScreenUntilFindElement(String id) {
        TouchAction touchAction = new TouchAction(driver);
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int widht = dim.getWidth();
        int y = (int) (height * 0.5);
        int startX = (int) (widht * 0.7);
        int moveTo = 20;

        while(isElementDisplayed(id) == false){
            touchAction.longPress(PointOption.point(startX, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
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

    public String getTextContentDesc(String id){
        MobileElement element = findElementByIdOrXpath(id);
        return element.getAttribute("content-desc");
    }

    public double convertStringToDouble(String id){
        String temp = id.substring(id.lastIndexOf("$")+1);
        double result = Double.parseDouble(temp);
        return result;
    }

    public double calculatedTotal(int subtotal, int shipping, int tax){
        return subtotal + shipping + tax;
    }

    public boolean checkTotalShoppingCart(String xPathTotal, String xPathSubTotal, String xpathShipping, String xpathTax){
        String textTotal = getTextContentDesc(xPathTotal);
        String textSubTotal = getTextContentDesc(xPathSubTotal);
        String textShipping = getTextContentDesc(xpathShipping);
        String textTax = getTextContentDesc(xpathTax);

        double total = convertStringToDouble(textTotal);
        double subTotal = convertStringToDouble(textSubTotal);
        double shipping = convertStringToDouble(textShipping);
        double tax = convertStringToDouble(textTax);

        double temptTotal = subTotal + shipping + tax;
        System.out.println("Total : "+total+"tempt : "+temptTotal);
        if (temptTotal == total)
        {
            return true;
        }
        else{
            return false;
        }

    }

}
