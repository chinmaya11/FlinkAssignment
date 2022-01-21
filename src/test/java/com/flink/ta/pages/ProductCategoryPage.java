package com.flink.ta.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import com.flink.ta.utils.Country;
import com.flink.ta.utils.PerformanceLevel;
import com.flink.ta.utils.WebDriverFactory;


/**
 * Page Object Model representing ProductCategoryPage.
 */
public class ProductCategoryPage extends PageObject{



	private final By  performancetypeCountry_All = By.xpath("//shrd-uic-mastercard/div/div[1]/div[3]/div[1]/shrd-uic-indicator-label/div/span");

	private static List<WebElement> elementsList;

	private static String productNamelist;
	private static String current_URL;

	private static ArrayList<String> performanceList = new ArrayList<String>();
	private static HashSet<String> performanceSet=new HashSet<String>();




	/**
	 * User can see different performance level products on category page
	 * 
	 * @param locator to locate performance level in the DOM
	 * @throws  StaleElementReferenceException
	 */
	public void verifyDiffPerformanceLevelProductCategoryPage() throws InterruptedException {	
		verifyDiffPerformanceProductOnProductCategoryPage(performancetypeCountry_All);
	}




	/**
	 * the function verify that there is at least one product on the category page matching each of the performance levels
	 * 
	 * @param locator to locate performance level in the DOM
	 * @throws  StaleElementReferenceException
	 * 
	 */
	public void verifyDiffPerformanceProductOnProductCategoryPage(By locator) throws StaleElementReferenceException {
		try {
			WebDriverFactory.waitUntilLocatorDLocated(locator);
			elementsList = WebDriverFactory.getDriver().findElements(locator);
			for (int i=0; i<elementsList.size();i++){
				productNamelist = elementsList.get(i).getText();
				Assert.assertEquals(productNamelist, PerformanceLevel.valueOf(productNamelist).toString());
				performanceSet.add(productNamelist);
			}
			Assert.assertEquals(performanceSet.size(), PerformanceLevel.values().length);
		}
		catch (StaleElementReferenceException e) {
			verifyDiffPerformanceProductOnProductCategoryPage(locator);
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			performanceSet.clear();
		}
	}






	/**
	 * User selects performance level <> in the filters
	 * 
	 * @param performance to filter product on performance level apply
	 * 
	 * @throws  InterruptedException
	 */
	public void SelectProductTypeApplyFilters(final String performancetype) throws InterruptedException {
		try {
			PerformanceLevel pl = PerformanceLevel.valueOf(performancetype.toUpperCase());
			switch(pl) {		

			case PREMIUM: {
				WebDriverFactory.driverClickJSE(By.xpath(PerformanceLevel.PREMIUM.getXPath()));
				break;
			}
			case STANDARD:{				
				WebDriverFactory.driverClickJSE(By.xpath(PerformanceLevel.STANDARD.getXPath()));
				break;
			}
			case ULTIMATE: {
				WebDriverFactory.driverClickJSE(By.xpath(PerformanceLevel.ULTIMATE.getXPath()));
				break;
			}
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
	}




	/**
	 * User can see only performance level products on category page on apply filter
	 * 
	 * @param performance to filter product on performance level apply
	 * 
	 * @throws  InterruptedException
	 */
	public void verifyProductTypeOnApplyFilters(final String performancetypeFilter) throws InterruptedException {	
		verifyOnlyProductPerformanceLevelsDisplayedWhenApplyFilter(performancetypeFilter, performancetypeCountry_All);	
	}


	/**
	 * the function verify that all visible products on the page are of selected performance level 
	 * 
	 * also verify that there is at least one product being presented
	 * 
	 * @param locator to locate performance level in the DOM
	 * @throws  StaleElementReferenceException
	 * 
	 */
	public void verifyOnlyProductPerformanceLevelsDisplayedWhenApplyFilter_bkp(final String performancetypeFilter, By locator) throws InterruptedException {
		try {
			WebDriverFactory.waitUntilLocatorDLocated(locator);
			elementsList = WebDriverFactory.getDriver().findElements(locator);
			for (int i=0; i<elementsList.size();i++){
				productNamelist = elementsList.get(i).getText();
				Assert.assertEquals(productNamelist.toUpperCase(), performancetypeFilter.toUpperCase());
				performanceList.add(productNamelist);
				performanceSet.add(productNamelist);
			}
			Assert.assertEquals(performanceSet.size(), 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			performanceList.clear();
			performanceSet.clear();
		}
	}
	

	
	public void verifyOnlyProductPerformanceLevelsDisplayedWhenApplyFilter(final String performancetypeFilter, By locator) throws InterruptedException {
		try {
			WebDriverFactory.waitForProductNavigationToAppear(locator);
			elementsList = WebDriverFactory.getDriver().findElements(locator);
			for (int i=0; i<elementsList.size();i++){
				productNamelist = elementsList.get(i).getText();
				Assert.assertEquals(productNamelist.toUpperCase(), performancetypeFilter.toUpperCase());
				performanceList.add(productNamelist);
				performanceSet.add(productNamelist);
			}
			Assert.assertEquals(performanceSet.size(), 1);
		}
		catch (StaleElementReferenceException e) {
			verifyOnlyProductPerformanceLevelsDisplayedWhenApplyFilter(performancetypeFilter, locator);
		}
		finally {
			performanceList.clear();
			performanceSet.clear();
		}
	}





	/**
	 * User resets the performance level filter
	 * 
	 * 
	 * @throws  InterruptedException
	 */
	public void resetPerformanceFilter() throws InterruptedException {
		try {
			current_URL = WebDriverFactory.getDriver().getCurrentUrl();
			if (current_URL.contains(Country.US.getDomain())) {
				WebDriverFactory.driverClickJSE(By.xpath(Country.US.noPreferences()));
			} else if (current_URL.contains(Country.FR.getDomain())) {
				WebDriverFactory.driverClickJSE(By.xpath(Country.FR.noPreferences()));
			} else if (current_URL.contains(Country.DE.getDomain())) {
				WebDriverFactory.driverClickJSE(By.xpath(Country.DE.noPreferences())); 
			}
			WebDriverFactory.getDriver().navigate().refresh();
		}
		catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		catch (Exception e) {
			e.getMessage();
		}
	}




}



