package stepDef;

import helper.MainFunc;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ClearShoppingCart {
    MainFunc mainFunc = new MainFunc();

    String clear = "CLEAR CART";
    String seaTunic = "//android.widget.Button[contains(@content-desc,'Sea tunic')]";
    String shoppingCard = "//android.widget.Button[contains(@content-desc,'Shopping cart')]";
    String total = "//android.view.View[contains(@content-desc,'TOTAL')]";
    String subtotal="//android.view.View[contains(@content-desc,'Subtotal')]";
    String shipping ="//android.view.View[contains(@content-desc,'Shipping')]";
    String tax = "//android.view.View[contains(@content-desc,'Tax')]";

    @When("click clear cart")
    public void click_clear_cart() {
        mainFunc.click(clear);
    }

    @Then("there is no item in the shopping card")
    public void there_is_no_item_in_the_shopping_card() {
        mainFunc.click(shoppingCard);
        Assert.assertFalse(mainFunc.isElementDisplayed(seaTunic));
        Assert.assertTrue(mainFunc.checkTotalShoppingCart(total,subtotal,shipping,tax));
    }



}
