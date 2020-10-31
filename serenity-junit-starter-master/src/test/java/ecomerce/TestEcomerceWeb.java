package ecomerce;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.MainSteps;

@RunWith(SerenityRunner.class)
public class TestEcomerceWeb {
	
	public static List<InforProduct> arrobjInforProduct = new ArrayList<InforProduct>();
	public static ArrayList<Boolean> lstDisplayInforProduct = new ArrayList<Boolean>();
	
	@Steps
	MainSteps objMainSteps;
	@Managed(driver = "chrome")
	WebDriver objDriver;
	
	@Test
	public void search_product_Ebay_Web() throws InterruptedException {
		
		objMainSteps.gotoURLEbay(objDriver);	
		
		String xPathTextBoxSearchEbay = ".//input[@id='gh-ac']";
		String xPathButtonSearchEbay = ".//input[@value='Search']";
		String dataSearch = "iPhone 11";
		
		objMainSteps.searchEbay(dataSearch, 
							    xPathTextBoxSearchEbay, 
							    xPathButtonSearchEbay,
				   			    objDriver);
		
		String xPathListNameProduct = "//ul[contains(@class, 'srp-results')]/li//h3[1]";
		String xPathListPriceProduct = "//ul[contains(@class, 'srp-results')]/li//span[@class='s-item__price']";
		String xPathListLinkProduct = "//ul[contains(@class, 'srp-results')]/li/div[1]/div[2]/a[1]";
		
		objMainSteps.getValidateResultDisplaySearchProductEbay(xPathListNameProduct, 
															   xPathListPriceProduct, 
															   xPathListLinkProduct, 
															   objDriver,
															   arrobjInforProduct, 
															   lstDisplayInforProduct);
		
		objMainSteps.closeEbayWebsite(objDriver);
		
		objMainSteps.gotoURLTiki(objDriver);
		
		String xPathTextBoxSearchTiki = "//input[@data-view-id='main_search_form_input']";
		String xPathButtonSearchTiki = "//button[@data-view-id='main_search_form_button']";
		String xPathBoQuaButtonTiki = "//button[@id='onesignal-slidedown-cancel-button']";
		
		String dataSearchTiki = "iPhone 11";
		objMainSteps.searchTiki(dataSearchTiki, 
								xPathTextBoxSearchTiki, 
								xPathButtonSearchTiki,
								xPathBoQuaButtonTiki,
					   			objDriver);
		
		String xPathListNameProductTiki = "//div[@class='product-box-list']//div[contains(@class, 'product-item')]/a[1]//p[@class='title']";
		String xPathListPriceProductTiki = "//div[@class='product-box-list']//div[contains(@class, 'product-item')]/a[1]//span[@class='final-price']";
		String xPathListLinkProductTiki = "//div[@class='product-box-list']//div[contains(@class, 'product-item')]/a[1]"; 
		
		objMainSteps.getValidateResultDisplaySearchProductTiki(xPathListNameProductTiki, 
															   xPathListPriceProductTiki, 
															   xPathListLinkProductTiki, 
															   objDriver, 
															   arrobjInforProduct, 
															   lstDisplayInforProduct);
		
		//objMainSteps.sortTheResultInAscendingOrderOftPrice(arrobjInforProduct);
		
		objMainSteps.displayInforProduct(arrobjInforProduct);
		
		//objMainSteps.VerifyDisplayInforProduct(lstDisplayInforProduct);
		
	}
	
}
