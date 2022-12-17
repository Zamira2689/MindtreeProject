package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/cucumber.json",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@smoke",
        dryRun = false
)

public class CukesRunner {
}
