package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private WebDriverWait wait;
	
	private static final int TIMEOUT = 20;
    private static final int POLLING = 5;
	
	public BasePage (WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, TIMEOUT ,POLLING);
		PageFactory.initElements(driver, this);
			
	}
	

	   public void waitForElementToVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementToClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	   public void sendKeys(WebElement element, String textToSend) {
	        waitForElementToVisible(element);
	        element.clear();
	        element.sendKeys(textToSend);
	    }

	  public  void click(WebElement element) {
	        waitForElementToClickable(element);
	        element.click();
	    }

	    protected void clickUsingMouseAction(WebElement elementToClick) throws Exception{
	        scrollIntoView(elementToClick);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(elementToClick);
	        actions.click().build().perform();
	        waitForPageLoad();
	    }
	    
	    protected void clickUsingJavascriptExecutor(WebElement elementToClick) throws Exception {
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
	 		waitForPageLoad();
	    }
	    protected void scrollIntoView(WebElement element) throws Exception {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        waitForPageLoad();
	    }
	    
	   public void waitForPageLoad() throws Exception   {
		   
		   Thread.sleep(2000);
	   }

}
