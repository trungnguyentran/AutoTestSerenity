package steps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ecomerce.CommonMethod;
import ecomerce.Constants;
import ecomerce.InforProduct;
import net.thucydides.core.annotations.Step;

public class MainSteps { 
	
	CommonMethod objCommonMethod = new CommonMethod();
	
	@Step("Open Ebay Website")
	public void gotoURLEbay(WebDriver driver) {
		
		String url = "https://www.ebay.com/";
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Step("Search iPhone 12 64GB")
	public void searchEbay(String dataCond, 
					       String xPathTextBoxSearch, 
					       String xPathEleSearch,
					       WebDriver driver) {
		
		boolean statusLoadingPage = objCommonMethod.isLoadingPage(driver);
		
		if (statusLoadingPage) {
			
			WebElement eleTextboxSearch = objCommonMethod.findElementXPathConditionExist(xPathTextBoxSearch, driver);
			eleTextboxSearch.sendKeys(dataCond);
			
			WebElement eleButtonSearch = objCommonMethod.findElementXPathConditionExist(xPathEleSearch, driver);
			eleButtonSearch.click();
			
		}
		
	}
	
	@Step("get the results display search in Ebay")
	public void getValidateResultDisplaySearchProductEbay (String xPathListNameProduct,
												 		   String xPathListPriceProduct,
												 		   String xPathListLinkProduct, 
												 		   WebDriver driver,
												 		   List<InforProduct> lstInforProduct,
												 		   ArrayList<Boolean> lstDisplayInforProduct) {
		
		try {
			
			boolean statusLoadingPage = objCommonMethod.isLoadingPage(driver);
			
			if (statusLoadingPage) {

				List<WebElement> lstEleNameProduct = objCommonMethod.findElementsXPathConditionExist(xPathListNameProduct, driver);
				List<WebElement> lstElePriceProduct = objCommonMethod.findElementsXPathConditionExist(xPathListPriceProduct, driver);
				List<WebElement> lstEleLinkProduct = objCommonMethod.findElementsXPathConditionExist(xPathListLinkProduct, driver);
				
				int sizelstEleNameProduct = lstEleNameProduct.size();
				int sizelstElePriceProduct = lstElePriceProduct.size();
				int sizelstEleLinkProduct = lstEleLinkProduct.size();
//				
//				if (sizelstEleNameProduct == sizelstElePriceProduct
//					&& sizelstElePriceProduct == sizelstEleLinkProduct
//					&& sizelstEleLinkProduct == sizelstEleNameProduct) {
					
						int idx = 0;
						
						while (idx < sizelstEleNameProduct) {
							
							WebElement eleNameProduct = lstEleNameProduct.get(idx);
							WebElement elePriceProduct = lstElePriceProduct.get(idx);
							WebElement eleLinkProduct = lstEleLinkProduct.get(idx);
							
							lstDisplayInforProduct.add(eleNameProduct.isDisplayed());
							lstDisplayInforProduct.add(elePriceProduct.isDisplayed());
							lstDisplayInforProduct.add(eleLinkProduct.isDisplayed());
							
							String nameProduct = eleNameProduct.getText();
							String priceProduct;
							
							if (elePriceProduct.getText().contains("to")) {
							
								int idxTo = elePriceProduct.getText().indexOf("to");
								priceProduct = elePriceProduct.getText().substring(0, idxTo).replace("VND", "")
										              .replace(",", "").trim();	
								
							} else {
								
								int idxVND = elePriceProduct.getText().indexOf("VND");
								priceProduct = elePriceProduct.getText().substring(0, idxVND).replace(",", "").trim();
								
							}
							
							String linkProduct = eleLinkProduct.getAttribute("href");
							String nameWebSite = "Ebay";
							
							InforProduct objInforProduct = new InforProduct();
							objInforProduct.setNameWebsite(nameWebSite);
							objInforProduct.setNameProduct(nameProduct);
							objInforProduct.setPriceProduct(priceProduct);
							objInforProduct.setLinkProduct(linkProduct);
							lstInforProduct.add(objInforProduct);	
							
							idx++;
							
						}
						
				//}
				
				String displayTest = sizelstEleNameProduct + " --- " + sizelstElePriceProduct + " --- " + sizelstEleLinkProduct;
				System.out.println(displayTest);
				
			}
			
		} catch (Exception ex) {
			
		     System.out.println("getValidateResultDisplaySearchProductEbay is " + ex);
			
		}	
		
	}
	
	@Step("Close Ebay Website")
	public void closeEbayWebsite(WebDriver driver) {
	
		driver.quit();
	
	}
	
	@Step("Open Tiki Website")
	public void gotoURLTiki(WebDriver driver) {
		
		String url = "https://tiki.vn/";
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Step("Search iPhone 12 64GB on Tiki")
	public void searchTiki(String dataCond, 
					   	   String xPathTextBoxSearch, 
					       String xPathEleSearch,
					       String xPathBoQuaButtonTiki,
					       WebDriver driver) {
		
		try {
		
			boolean statusLoadingPage = objCommonMethod.isLoadingPage(driver);
			
			if (statusLoadingPage) {
				
				WebElement eleBoQuaButtonTiki = objCommonMethod.findElementXPathConditionExist(xPathBoQuaButtonTiki, driver);
				if (eleBoQuaButtonTiki !=null) {
					
					    Thread.sleep(Constants.TIME_WAIT_DISPLAY_POPUP_TIKI);
						eleBoQuaButtonTiki.click();
						
				}
				
				WebElement eleTextboxSearch = objCommonMethod.findElementXPathConditionExist(xPathTextBoxSearch, driver);
				eleTextboxSearch.sendKeys(dataCond);
				
				WebElement eleButtonSearch = objCommonMethod.findElementXPathConditionExist(xPathEleSearch, driver);
				eleButtonSearch.click();
				
			}
			
			
		} catch (Exception ex) {
			
			System.out.println("searchTiki is error exception: " + ex);
			
		}	
	}
	
	@Step("get the results display search in Tiki")
	public void getValidateResultDisplaySearchProductTiki (String xPathListNameProduct,
												 		   String xPathListPriceProduct,
												 		   String xPathListLinkProduct, 
												 		   WebDriver driver,
												 		   List<InforProduct> lstInforProduct,
												 		   ArrayList<Boolean> lstDisplayInforProduct) {
		
		try {
			
			boolean statusLoadingPage = objCommonMethod.isLoadingPage(driver);
			
			if (statusLoadingPage) {

				List<WebElement> lstEleNameProduct = objCommonMethod.findElementsXPathConditionExist(xPathListNameProduct, driver);
				List<WebElement> lstElePriceProduct = objCommonMethod.findElementsXPathConditionExist(xPathListPriceProduct, driver);
				List<WebElement> lstEleLinkProduct = objCommonMethod.findElementsXPathConditionExist(xPathListLinkProduct, driver);
				
				int sizelstEleNameProduct = lstEleNameProduct.size();
				int sizelstElePriceProduct = lstElePriceProduct.size();
				int sizelstEleLinkProduct = lstEleLinkProduct.size();
				
				if (sizelstEleNameProduct == sizelstElePriceProduct
					&& sizelstElePriceProduct == sizelstEleLinkProduct
					&& sizelstEleLinkProduct == sizelstEleNameProduct) {
					
						int idx = 0;
						
						while (idx < sizelstEleNameProduct) {
							
							WebElement eleNameProduct = lstEleNameProduct.get(idx);
							WebElement elePriceProduct = lstElePriceProduct.get(idx);
							WebElement eleLinkProduct = lstEleLinkProduct.get(idx);
							
							lstDisplayInforProduct.add(eleNameProduct.isDisplayed());
							lstDisplayInforProduct.add(elePriceProduct.isDisplayed());
							lstDisplayInforProduct.add(eleLinkProduct.isDisplayed());
							
							String nameProduct = eleNameProduct.getText().trim();
							int idxD = elePriceProduct.getText().indexOf("đ");
							String priceProduct = elePriceProduct.getText().substring(0, idxD).replace(".", "").trim();
							String linkProduct = eleLinkProduct.getAttribute("href");
							String nameWebSite = "Tiki";
							
							InforProduct objInforProduct = new InforProduct();
							objInforProduct.setNameWebsite(nameWebSite);
							objInforProduct.setNameProduct(nameProduct);
							objInforProduct.setPriceProduct(priceProduct);
							objInforProduct.setLinkProduct(linkProduct);
							lstInforProduct.add(objInforProduct);
							
							idx++;
							
						}
						
				}
				
				String displayTest = sizelstEleNameProduct + " --- " + sizelstElePriceProduct + " --- " + sizelstEleLinkProduct;
				System.out.println(displayTest);
				
			}
			
		} catch (Exception ex) {
			
		     System.out.println("getValidateResultDisplaySearchProductTiki is " + ex);
			
		}	
		
	}
	
	@Step("sort the result in ascending order of price")
	public void sortTheResultInAscendingOrderOftPrice(List<InforProduct> lstInforProduct) throws InterruptedException {
		
		  Collections.sort(lstInforProduct, new Comparator<InforProduct>() {
	            @Override
	            public int compare(InforProduct pro1, InforProduct pro2) {
	            	
	            	double pro1PriceProduct = Double.parseDouble(pro1.getPriceProduct());
	            	double pro2PriceProduct = Double.parseDouble(pro2.getPriceProduct());
	            	
	                if (pro1PriceProduct > pro2PriceProduct) {
	                    return 1;
	                } else {
	                    if (pro1PriceProduct == pro2PriceProduct) {
	                        return 0;
	                    } else {
	                        return -1;
	                    }
	                }
	            }
	        });
		
	}
	
	@Step("Display Information Product")
	public void displayInforProduct(List<InforProduct> lstInforProduct) {
		
		for (InforProduct objInforProduct : lstInforProduct) {
			
			   String displayInforProduct = objInforProduct.getNameWebsite() 
					                           + " === " 
					                           + objInforProduct.getNameProduct()
					                           + " === "
					                           + objInforProduct.getPriceProduct()
					                           + " === "
					                           + objInforProduct.getLinkProduct();
			   
			   System.out.println(displayInforProduct);
			
		}	  
		
	} 
	
	@Step("Vefify Display Information Product in Ebay and in Tiki")
	public void VerifyDisplayInforProduct(ArrayList<Boolean> lstDisplayInforProduct) {
		
		boolean isDisplayInforProduct = lstDisplayInforProduct.contains(false);
		assertTrue(isDisplayInforProduct);
		
	}
}
