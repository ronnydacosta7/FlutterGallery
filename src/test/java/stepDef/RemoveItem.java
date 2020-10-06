package stepDef;

import helper.MainFunc;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RemoveItem {
    MainFunc mainFunc = new MainFunc();

    String seaTunic = "//android.widget.Button[contains(@content-desc,'Sea tunic')]";

    @When("click on remove item button")
    public void click_on_remove_item_button() {
        mainFunc.click(seaTunic);
    }

    @Then("the item will be deleted from shopping card")
    public void the_item_will_be_deleted_from_shopping_card() {
        Assert.assertFalse(mainFunc.isElementDisplayed(seaTunic));
    }
}
