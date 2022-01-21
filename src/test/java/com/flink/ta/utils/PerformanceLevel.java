package com.flink.ta.utils;

/**
 * Enumeration class containing part of performance levels and locator.
 */
public enum PerformanceLevel {
	PREMIUM("//span[contains(text(),'Premium')]"),
	STANDARD("//span[contains(text(),'Standard')]"),
	ULTIMATE("//span[contains(text(),'Ultimate')]");

	private String xPath;


	PerformanceLevel(final String xPath) {
		this.xPath = xPath;

	}

	public String getXPath() {
		return xPath;
	}
}
