package elender;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@checkCarTax",
        plugin = {"pretty"},
        features = {"src/test/features"},
        glue = {"elender.steps"})

public class TestRunner {

}
