package com.flink.ta.utils;

import java.util.Locale;

/**
 * Enumeration class containing part of countries supported by HILTI website.
 */
public enum Country {
	US("United States", ".com","//span[contains(text(),'No preference')]" , Locale.US),
	FR("France", ".fr","//span[contains(text(),'Sans préférence')]" , Locale.FRANCE),
	DE("Germany", ".de","//span[contains(text(),'Keine Präferenz')]" , Locale.GERMANY);

	private String name;
	private String domain;
	private String noPreferences;
	private Locale defaultLocale;


	Country(final String name, final String domain, final String noPreferences, final Locale defaultLocale) {
		this.name = name;
		this.domain = domain;
		this.noPreferences = noPreferences;
		this.defaultLocale = defaultLocale;
	}

	public String getName() {
		return name;
	}

	public String getDomain() {
		return domain;
	}

	public String noPreferences() {
		return noPreferences;
	}
	
	public Locale getDefaultLocale() {
		return defaultLocale;
	}
}
