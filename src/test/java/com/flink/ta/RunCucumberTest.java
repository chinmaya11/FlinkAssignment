package com.flink.ta;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" },
		glue = { "com.flink.ta.steps"},
		plugin = {"html:target/cukes", "json:target/cucumber-report.json", "junit:target/cucumber-report.xml", "pretty"},
		strict = true,
		dryRun = false,
		tags = { "@Smoke" , "@Sample" },
		monochrome = true)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
