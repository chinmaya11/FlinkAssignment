package com.flink.ta.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flink.ta.utils.Country;
import com.flink.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */
public class Homepage extends PageObject {

	private static final String FLINK_URL = "http://weathershopper.pythonanywhere.com/";
	private static String current_URL;
	
	private final By  currentTemp = By.xpath("//div[@id='weather']");

	
	
	private static WebElement element;
	private static List<WebElement> elementsList;
	private static int temp;
	
	/**
	 * Opens Hilti homepage for given country.
	 * 
	 * @param country
	 *            {@link Country}getCurrentTempreture
	 */
	public void gets() {
		try {
			WebDriverFactory.getDriver().get(FLINK_URL);
		}
		catch (Exception e) {
			e.getMessage();
		}

	}
	
	public int getCurrentTempreture(By currentTemp) {
		try {
			//WebDriverFactory.waitUntilLocatorDLocated(currentTemp);
			String sTemp = WebDriverFactory.getDriver().findElement(currentTemp).getText();
			String[] arrOfStr = sTemp.split(" ");
			//System.out.println("arrOfStr[0] :"+arrOfStr[0]);
			temp=Integer.parseInt(arrOfStr[0]);
			//System.out.println("temp :"+temp);
		}
		catch (Exception e) {
			e.getMessage();
		}
		return temp;
	}

	/**
	 * Opens Hilti homepage for given country.
	 * 
	 * @param country
	 *            {@link Country}
	 */
	public void get(final Country country) {
		try {
			WebDriverFactory.getDriver().get(FLINK_URL + country.getDomain());
		}
		catch (Exception e) {
			e.getMessage();
		}

	}



	/**
	 * Navigate to Hilti Product categorry  page for given country home page.
	 * 
	 * @param URL
	 *            {@link URL}
	 * @throws InterruptedException 
	 */
	public void navigateToURL(final String url) throws InterruptedException {
		try {
			current_URL = WebDriverFactory.getDriver().getCurrentUrl();
			WebDriverFactory.getDriver().get(current_URL + "c" + url);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}




}
