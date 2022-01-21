package com.flink.ta.steps;

import org.openqa.selenium.By;

import com.flink.ta.pages.Homepage;
import com.flink.ta.pages.MoisturizersPage;
import com.flink.ta.pages.ProductCategoryPage;
import com.flink.ta.pages.SunscreensPage;
import com.flink.ta.utils.BrowserTypes;
import com.flink.ta.utils.Country;
import com.flink.ta.utils.WebDriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PerformanceSteps {
	
	private final Homepage Homepage = new Homepage();
	
	public static String browserType = null;
	//private final ProductCategoryPage productcategorypage = new ProductCategoryPage();
	
	private static int current_Temp;
	
	private final By  currentTemp = By.xpath("//div[@id='weather']"); 
	//span[@id='temperature']
	//div[@id='weather']
	//span[@id='temperature']/text()
	private final By  buyMoisturizers = By.xpath("//button[contains(text(),'Buy moisturizers')]");
	private final By  buySunscreens = By.xpath("//button[contains(text(),'Buy sunscreens')]");
	
	
	
	
	@Given("User open {} browser")
	public void user_open_browser(final String browser) {
		browserType=browser;
		WebDriverFactory.initialize_Browser(browserType);
	}

	@When("User opens weather shopper website")
	public void user_opens_weather_shopper_website() throws InterruptedException {
		Homepage.gets();
		//Thread.sleep(2000);
	}

	@Then("User verify current tempereture")
	public void user_verify_current_tempereture() {
		String sTemp = WebDriverFactory.getDriver().findElement(currentTemp).getText();
		current_Temp=Homepage.getCurrentTempreture(currentTemp);
	}
	
	
	@Then("User verify current tempereture and add product to cart")
	public void user_verify_current_tempereture_and_add_product_to_cart() {

		current_Temp=Homepage.getCurrentTempreture(currentTemp);
		if (current_Temp < 19) {
			System.out.println("User buy Moisturizers");
			WebDriverFactory.click(buyMoisturizers);
			MoisturizersPage.addLeastPriceProductToCart("Aloe");
			MoisturizersPage.addLeastPriceProductToCart("almond");
		} else if (current_Temp > 34) {
			System.out.println("User buy Sunscreens");
			WebDriverFactory.click(buySunscreens);
			SunscreensPage.addLeastPriceProductToCartSS("SPF-50");
			SunscreensPage.addLeastPriceProductToCartSS("SPF-30");
		} else {
			System.out.println("User buy nothing");
		}
	}
	
	
	
	
	
	
	
	
	@Given("User opens weather shopper website on {} browser")
	public void user_opens_weather_shopper_website_on_chrome_browser(final String browser) {

	}
	
	
	

	@When("Verify current tempereture")
	public void verify_current_tempereture() {

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Given("User opens Hilti website for country {}")
	public void userOpensHiltiWebsite(final Country country) {
		Homepage.get(country);		
	}
	
	
	@When("User navigates to category page for {}")
	public void userNavigatesToCategoryPage(final String url) throws InterruptedException {
		Homepage.navigateToURL(url);
	}
	
	
	
}
