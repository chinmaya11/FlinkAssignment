package com.flink.ta.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flink.ta.utils.WebDriverFactory;

public class SunscreensPage {
	

	
	static HashMap<String, String> mapProductDetails = new HashMap<>();
	static HashMap<Integer, String> mapProductDetailsSort = new HashMap<>();
	
	static HashMap<Integer, String> mapProductDetailsNew = new HashMap<Integer, String>();

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
	
	
	public static void addLeastPriceProductToCartSS(String mosType) {
		try {
			String prodToBeAdd=mosType;
			q=getProductNameAndPrice();
			
			Set<Integer> keys= q.keySet();
			ArrayList<Integer> listSortProduct= new ArrayList<Integer>(keys);
			Collections.sort(listSortProduct);
			
			int getLowestPrice=listSortProduct.get(0);

			
			   for(int i:listSortProduct){  

				     String hmapValues=q.get(i);
				   } 
			
			String hmapValue=q.get(getLowestPrice);			
			ProductToCart(prodToBeAdd, getLowestPrice);
			}			
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	
	public static void ProductToCart(String type, int price) {
		try {
			String prodToBeAddType=type;
			int prodToBeAddPrice=price;
			WebDriverFactory.waitUntilLocatorDLocated(addBtn);
			elementsList = WebDriverFactory.getDriver().findElements(addBtn);
			int count=0;
			for (int i=0; i<elementsList.size();i++){
				productDetailslist = elementsList.get(i).getAttribute("onclick");
			
				if (productDetailslist.contains("SPF-30") && productDetailslist.contains(Integer.toString(prodToBeAddPrice))) {
					WebElement el=elementsList.get(i);
					el.click();
					break;
				} else if (productDetailslist.contains("SPF-50")  && productDetailslist.contains(Integer.toString(prodToBeAddPrice))){
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
	
	public static int getTotalNumberOfProduct(By addBtn) {
		try {			
			WebDriverFactory.waitUntilLocatorDLocated(addBtn);
			elementsList = WebDriverFactory.getDriver().findElements(addBtn);
			
			for (int i=0; i<elementsList.size();i++){
				productNamelist = elementsList.get(i).getText();				
				productDetailslist = elementsList.get(i).getAttribute("onclick");				
				performanceList.add(productNamelist);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return performanceList.size();
	}
	
	
	
	
	
}