package com.flink.ta.steps;


import com.flink.ta.utils.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


/**
 * Cucumber hook steps definition class responsible for actions taken before and after test execution.
 */
public class BackgroundSteps {
	
	
	

	/**
	 * Cucumber hook steps definition class responsible for intialize webdriver.
	 * 
	 * @param Fetching arguments being passed while executing a maven goal to run scripts in GUI and headless mode
	 */
/*	@Before
	public void beforeUITests() {
			String browser=PerformanceSteps.browserType;
			System.out.println("browser 3:"+browser);
		WebDriverFactory.initialize_Env(System.getProperty("runmode"), browser);	
			//WebDriverFactory.initialize(System.getProperty("runmode"));	
	}*/
	
	
	
	
	/**
	 * Cucumber hook steps definition class responsible for quit webdriver.
	 */
	@After
	public void afterUITests(final Scenario scenario) {
		if (!scenario.isFailed()) {
			WebDriverFactory.quitCurrentDriver();
		}
	}
}
