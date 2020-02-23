package com.qa.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
features="src\\main\\java\\com\\qa\\Features\\Features.feature",
glue = {"com.qa.StepDefinition"},
dryRun=false,
strict = true,
tags= {"@DeleteAPI"})

public class TestRunner {

	
	
}
