package shj.training.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/shj/training/cucumber/features"},
        glue = {"shj.training.cucumber.stepDefinitions"},
        format = {
              "json:target/cucumber.json",
              "html:target/site/cucumber-pretty"
        }
)
public class TestRunner {
}
