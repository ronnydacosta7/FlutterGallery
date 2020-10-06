package helper;
import io.cucumber.java.*;
import setup.Config;

public class Hooks {
    Config driver = new Config();
    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
        driver.setup();
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after the Scenario");
        driver.tearDown();
    }
}
