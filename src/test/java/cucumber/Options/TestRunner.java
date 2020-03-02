package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
features="src\\test\\java\\com\\qa\\Features\\Features.feature",
glue = {"com.qa.StepDefinition"},
plugin = "json:target/jsonReports/cucumber-reports.json",
dryRun=false,
tags= {"@DeleteAPI"},
strict = true
)
//
public class TestRunner {

	
	
}
