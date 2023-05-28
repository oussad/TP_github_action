package test_runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features" }, 
glue = { "steps" }, 
tags = "@tag8",
monochrome = true, 
//plugin = { "pretty","html:rapport01.html" },
plugin = { "pretty","json:target/json-report/cucumber.json" },
dryRun = false

)
public class Test_runner {

}
