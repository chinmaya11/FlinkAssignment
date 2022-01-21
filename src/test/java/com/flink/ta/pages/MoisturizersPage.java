package com.flink.ta.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flink.ta.utils.PerformanceLevel;
import com.flink.ta.utils.WebDriverFactory;

public class MoisturizersPage {
	

	
	
	static HashMap<String, String> mapProductDetails = new HashMap<>();
	static HashMap<Integer, String> mapProductDetailsSort = new HashMap<>();
	
	static HashMap<Integer, String> mapProductDetailsNew = new HashMap<Integer, String>();
	
	static HashMap<Integer, String> mapFinalProductDetailsNew = new HashMap<Integer, String>();
	static HashMap<Integer, String> mapFinalProductDetailsSunScreen = new HashMap<Integer, String>();

	private static List<WebElement> elementsList;

	
	private static String productNamelist;
	private static String productDetailslist;

	

	private static ArrayList<String> performanceList = new ArrayList<String>();

	
	private static ArrayList<String> productList = new ArrayList<String>();
	private static ArrayList<String> productPriceList = new ArrayList<String>();

	
	
	private final static By  addBtn = By.xpath("//button[@class='btn btn-primary']");
	
	public static int i;
	
	public static int iLowestPrice=0;
	
	public static HashMap<Integer, String> q;
	
	public static int iProdPrice;
	public static String sProdName;
	public static String s;
	public static int pr;
	
	
	public static void addLeastPriceProductToCart(String mosType) {
		try {
			String prodToBeAdd=mosType;
			q=getProductNameAndPrice();
			Set<Integer> keys= q.keySet();
			ArrayList<Integer> listSortProduct= new ArrayList<Integer>(keys);
			Collections.sort(listSortProduct);
			
			int getLowestPrice=listSortProduct.get(0);		
			
			 for(int i:listSortProduct){  

			     String hmapValues=q.get(i);
					System.out.println("hmapValues value is Lipsa: "+hmapValues+" and price :"+i);					
					String filterPrice= Integer.toString(i);		
					
					if (hmapValues.contains(mosType) ) {
						if (mosType.equalsIgnoreCase("aloe")) {
							mapFinalProductDetailsNew.put(i, hmapValues);	
						} else if (mosType.equals("Almond") || mosType.equalsIgnoreCase("almond")) {
							mapFinalProductDetailsSunScreen.put(i, hmapValues);
						}
						
					}
					System.out.println("Started Mosriture mapFinalProductDetailsNew: "+mapFinalProductDetailsNew);
					System.out.println("Started Sunscreen mapFinalProductDetailsSunScreen: "+mapFinalProductDetailsSunScreen);
					
			 }
			String hmapValue=q.get(getLowestPrice);
			
			}			
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	
	

	
	
	
	
	public static void ProductToCarts(String type, int price) {
		try {
			String prodToBeAddType=type;
			int prodToBeAddPrice=price;		

			WebDriverFactory.waitUntilLocatorDLocated(addBtn);
			elementsList = WebDriverFactory.getDriver().findElements(addBtn);

			int count=0;
			for (int i=0; i<elementsList.size();i++){
				productDetailslist = elementsList.get(i).getAttribute("onclick");				
				if (productDetailslist.contains(prodToBeAddType) && productDetailslist.contains(Integer.toString(prodToBeAddPrice))) {
					WebElement el=elementsList.get(i);
					el.click();
					break;
				} else if (productDetailslist.toLowerCase().contains("almond")  && productDetailslist.contains(Integer.toString(prodToBeAddPrice))){
					WebElement el=elementsList.get(i);
					el.click();
					break;
				}
			}
			}			
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public static void ProductToCart(String type, int price) {
		try {
			String prodToBeAddType=type;
			int prodToBeAddPrice=price;			
			System.out.println("Started adding ProductToCart");
			WebDriverFactory.waitUntilLocatorDLocated(addBtn);
			elementsList = WebDriverFactory.getDriver().findElements(addBtn);

			int count=0;
			for (int i=0; i<elementsList.size();i++){
				productDetailslist = elementsList.get(i).getAttribute("onclick");				
				if (productDetailslist.contains(prodToBeAddType) && productDetailslist.contains(Integer.toString(prodToBeAddPrice))) {
					WebElement el=elementsList.get(i);
					el.click();
					break;
				} else if (productDetailslist.toLowerCase().contains("almond")  && productDetailslist.contains(Integer.toString(prodToBeAddPrice))){
					WebElement el=elementsList.get(i);
					el.click();
					break;
				} else {

				}
			}
			}			
		catch (Exception e) {
			e.getMessage();
		}
		}
	
	public static HashMap<Integer, String> getProductNameAndPrice() {
		try {			

			WebDriverFactory.waitUntilLocatorDLocated(addBtn);
			elementsList = WebDriverFactory.getDriver().findElements(addBtn);
	
			for (int i=0; i<elementsList.size();i++){
				productDetailslist = elementsList.get(i).getAttribute("onclick");
				productList.add(productDetailslist);
				String[] arrOfStr=productDetailslist.split(",");
				
				String s=arrOfStr[1].replace(")", "");
				int a=Integer.parseInt(s);
				mapProductDetails.put(arrOfStr[0], arrOfStr[1]);
				productPriceList.add(s);
				mapProductDetailsNew.put(Integer.valueOf(a), arrOfStr[0]);
				mapProductDetailsSort.put(Integer.valueOf(a), arrOfStr[0]);
			}

		}
		catch (Exception e) {
			e.getMessage();
		}
		return mapProductDetailsSort;

	}
	

	
	
	
	
	
}
