package com.tfl.test.steps.jp;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;

import com.tfl.test.pages.jp.JourneyPlannerResultsPage;
import com.tfl.test.pages.jp.PlanAJourneyPage;
import com.tfl.test.steps.CommonSteps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * TASK: Write all the steps necessary to drive your test scenarios to
 * completion 
 * 
 * Note: Please make use of page objects 
 * 
 */
public class JourneyPlannerSteps extends CommonSteps{

	public static final String PLAN_A_JOURNEY = "plan-a-journey/";

	@Before
	public void initialise() {
		driver.get(url + PLAN_A_JOURNEY);
		journeyPage = PageFactory.initElements(driver, PlanAJourneyPage.class);
		
	}
	
	@Given("^I am on Plan A Journey page$")
	public void iAmOnJourneyPage(){
		journeyPage.clickOnPlan();
		Assert.assertTrue(journeyPage.checkWeAreInJourneyPage());
	}
	
	@When("^I enter From (.*) and To (.*) and click on Plan A Journey button$")
	public void enterStationDetails(String station1,String station2){
		journeyPage.enterFromStation(station1);
		journeyPage.enterToStation(station2);
		journeyPage.clickPlanAJourney();
	}
	
	@Then("^I should see the journey planner results page$")
	public void iSeeResultPage(){
		journeyPage.clickPlanAJourneyButtonAndPass();
	}
}
	


