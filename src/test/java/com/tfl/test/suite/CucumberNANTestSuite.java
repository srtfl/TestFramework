package com.tfl.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tfl.test.runner.RunJourneyPlannerFeature;


/**
 * Group any number of stories you would like to execute
 *
 */
@RunWith(Suite.class)
@SuiteClasses({RunJourneyPlannerFeature.class})	//Run single feature
public class CucumberNANTestSuite {

}