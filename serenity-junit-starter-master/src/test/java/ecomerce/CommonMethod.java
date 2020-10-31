package ecomerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethod {
	
	public WebElement findElementXPathConditionExist(String xPathName, 
												     WebDriver driver) {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Constants.TIME_WAIT_FIND_ELEMENT_EXIST_DOM);
			By ByElement = getByElementXPath(xPathName);
			// check this element exist on DOM 
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ByElement));

			return element;
		} catch (TimeoutException ex) {
			return null;
		}
	}

	public List<WebElement> findElementsXPathConditionExist(String xPathName, 
															WebDriver driver) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Constants.TIME_WAIT_FIND_ELEMENT_EXIST_DOM);
			By ByElement = getByElementXPath(xPathName);

			// check this element exist on DOM 
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ByElement));
			List<WebElement> selectResultsAsListCollection = element.findElements(ByElement);

			return selectResultsAsListCollection;
			
		} catch (Exception ex) {
			return null;
		}

	}

	private By getByElementXPath(String xPathName) {
		
			By byXPathName = By.xpath(xPathName);
		
			return byXPathName;
	}
	
	public boolean isLoadingPage(WebDriver driver) {
    	
    	boolean check = false;
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	
    	while (Constants.IS_NOT_FINISH_LOADING_PAGE) {
    		
    		check = ((String) js.executeScript("return document.readyState")).equals("complete");
    		
    		if (check) {
    		    
    			break;
    			
    		}	
    		
    	}
    	
    	return check;
    }
}
