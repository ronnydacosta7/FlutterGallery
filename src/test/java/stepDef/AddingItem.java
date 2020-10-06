package stepDef;

import helper.MainFunc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddingItem {
    MainFunc mainFunc = new MainFunc();

    String replyId = "Reply\nAn efficient, focused email app";
    String shrine = "Shrine\nA fashionable retail app";
    String rallyId = "Rally\nA personal finance app";
    String a = "Starter app\nA responsive starter layout";
    String next = "NEXT";
    String openMenu = "Open menu";
    String clothing = "CLOTHING";
    String shoppingCard = "Shopping cart, no items";
    String seaTunic = "//android.widget.Button[contains(@content-desc,'Sea tunic')]";

    @Given("User open the Shire Gallery")
    public void user_open_the_shire_gallery() {
        mainFunc.clickElementById("Shrine\nA fashionable retail app");
    }

    @When("click on next button after user input username & password")
    public void click_on_next_button() throws InterruptedException {
        mainFunc.input("//*[@text='Username']","ronny");
        mainFunc.input("//*[@text='Password']","ronny123");
        mainFunc.clickElementById("NEXT");
    }

    @When("click on filter menu")
    public void click_on_filter_menu() {
        mainFunc.clickElementById(openMenu);
    }

    @When("click on clothing filter")
    public void click_on_clothing_filter() {
        mainFunc.clickElementById(clothing);
    }

    @When("click on item sea tunic")
    public void click_on_item_sea_tunic() {
        if(mainFunc.isElementDisplayedByXpath(seaTunic)){
            mainFunc.clickElementByXpath(seaTunic);
        }
        else{
            mainFunc.refreshElement();
            mainFunc.clickElementByXpath(seaTunic);
        }
    }

    @Then("the item sea tunic add to shopping card")
    public void the_item_sea_tunic_add_to_shopping_card() {
       mainFunc.clickElementById(shoppingCard);
        Assert.assertTrue(mainFunc.isElementDisplayedByXpath(seaTunic));
    }
}
