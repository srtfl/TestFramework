package com.tfl.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/report_example.json"}, 
		glue = { "com.tfl.test.steps" },
		features = { "classpath:basic/" }
		,monochrome=true
)
public class RunJourneyPlannerFeature {
	//This is just a runner
	
}
