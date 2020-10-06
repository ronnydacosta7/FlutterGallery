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
    String accesories = "ACCESSORIES";
    String shoppingCard = "//android.widget.Button[contains(@content-desc,'Shopping cart')]";
    String seaTunic = "//android.widget.Button[contains(@content-desc,'Sea tunic')]";
    String stellaSunglasses = "//android.widget.Button[contains(@content-desc,'Stella sunglasses')]";


    @Given("User open the Shire Gallery")
    public void user_open_the_shire_gallery() {
        mainFunc.click("Shrine\nA fashionable retail app");
    }

    @When("click on next button after user input username & password")
    public void click_on_next_button() throws InterruptedException {
        mainFunc.inputText("//*[@text='Username']","ronny");
        mainFunc.inputText("//*[@text='Password']","ronny123");
        mainFunc.click("NEXT");
    }

    @When("click on filter menu")
    public void click_on_filter_menu() {
        mainFunc.click(openMenu);
    }

    @When("click on clothing filter")
    public void click_on_clothing_filter() {
        mainFunc.click(clothing);
    }

    @When("click on accessories filter")
    public void click_on_accessories_filter() {
        mainFunc.click(accesories);
    }

    @When("click on item sea tunic")
    public void click_on_item_sea_tunic() {
        if(mainFunc.isElementDisplayed(seaTunic)){
            mainFunc.click(seaTunic);
        }
        else{
            mainFunc.refreshElement();
            mainFunc.click(seaTunic);
        }
    }

    @When("click on item stella sunglasses")
    public void click_on_item_stella_sunglasses() {
        if(mainFunc.isElementDisplayed(stellaSunglasses)){
            mainFunc.click(stellaSunglasses);
        }
        else{
            mainFunc.refreshElement();
            mainFunc.click(stellaSunglasses);
        }
    }

    @Then("the item sea tunic add to shopping card")
    public void the_item_sea_tunic_add_to_shopping_card() {
       mainFunc.click(shoppingCard);
       Assert.assertTrue(mainFunc.isElementDisplayed(seaTunic));
    }

    @Then("the item sea tunic and stella sunglasses add to shopping card")
    public void the_item_sea_tunic_and_stella_sunglasses_add_to_shopping_card() {
        mainFunc.click(shoppingCard);
        Assert.assertTrue(mainFunc.isElementDisplayed(seaTunic));
        Assert.assertTrue(mainFunc.isElementDisplayed(stellaSunglasses));
    }
}
