import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
            features = {"src/test/resources/features"},
            glue = "stepDef",
            monochrome = true,
            dryRun = false,
            plugin = {
                    "json:build/cucumber-reports/cucumber.json",
                    "rerun:build/cucumber-reports/rerun.txt"
            }
    )

public class TestRunner extends AbstractTestNGCucumberTests {
}




