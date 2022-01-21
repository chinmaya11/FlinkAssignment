package com.flink.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.flink.ta.utils.WebDriverFactory;

public abstract class PageObject {

	

	/**
	 * asking driver to wait for element to be located in the DOM
	 * 
	 * @param locator to identify and wait until element is located
	 */
    protected boolean isElementVisible(final By locator) {
        try {
            final WebElement uiLocator = WebDriverFactory.getWebDriverWait(2).until(ExpectedConditions.presenceOfElementLocated(locator));
            return uiLocator.isDisplayed();
        } catch (final TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }


}
