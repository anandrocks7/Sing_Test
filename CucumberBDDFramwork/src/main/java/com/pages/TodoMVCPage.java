package com.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataPojos.Data;

public class TodoMVCPage extends BasePage {

	public TodoMVCPage(WebDriver driver) {
		super(driver);

	}

	// WebElements
	@FindBy(xpath="//h1")  WebElement headerElement;
	@FindBy(xpath="//input[@class='new-todo']")  WebElement inputBox;
	@FindBy(xpath="(//ul[@class='todo-list']//li//label)")  List<WebElement> firstItemLabel;
	@FindBy(xpath="//span[@class='todo-count']")  WebElement countLeft;
	@FindBy(xpath="//ul[@class='todo-list']//li")  List<WebElement> itemList;	
	@FindBy(xpath="//ul[@class='filters']//li/a[text()='All']")  WebElement footerlinkALL;
	@FindBy(xpath="//ul[@class='filters']//li/a[text()='Active']")  WebElement footerlinkActive;
	@FindBy(xpath="//ul[@class='filters']//li/a[text()='Completed']")  WebElement footerlinkCompleted;
	@FindBy(xpath="//button[@class='clear-completed']")  WebElement clearCompletedButton;
	@FindBy(xpath="(//ul[@class='todo-list']//li//label)[1]//preceding-sibling::input")  WebElement radioButtonFirst;



	// Action Methods

	public String getHeaderText() {
		waitForElementToVisible(headerElement);
		return	headerElement.getText();

	}

	public void enterItem(String item) {
		waitForElementToVisible(inputBox);
		sendKeys(inputBox, item);

	}

	public void pressEnterKey() {
		waitForElementToVisible(inputBox);
		inputBox.sendKeys(Keys.ENTER); 
	}

	public void addTwoMoreItems() {
		Data data = new Data();
		enterItem(data.item1);
		pressEnterKey();
		enterItem(data.item2);
		pressEnterKey();

	}

	public String returnItemLabelBasedOnNumber(int number) {
		String label="";
		for(int i=0 ;i<number;i++) {
			label =firstItemLabel.get(i).getText();
		}
		return label;		
	}

	public int getSizeOfItems() {
		
		return itemList.size();		
	}

	public String countLeftText() {
		waitForElementToVisible(countLeft);
		return countLeft.getText();
	}


	public String footerLinkAllIsSelected() {
		waitForElementToVisible(footerlinkALL);
		return footerlinkALL.getAttribute("class");
	}

	public boolean clearCompletedButtonIsDisplayed() {
		return clearCompletedButton.isDisplayed();		
	}

	public void clickFirstRadioButtonToComplete() throws Exception {
		waitForPageLoad();
		clickUsingJavascriptExecutor(radioButtonFirst);
	}
	
	public void clickFiterLinkALL() {
		waitForElementToVisible(footerlinkALL);
		click(footerlinkALL);
	}
	public void clickFiterLinkActive() {
		waitForElementToVisible(footerlinkActive);
		click(footerlinkActive);
	}

	public void clickFiterLinkCompleted() {
		waitForElementToVisible(footerlinkCompleted);
		click(footerlinkCompleted);
	}
	public void clickButtonClearCompleted() {
		waitForElementToVisible(clearCompletedButton);
		click(clearCompletedButton);
	}
	

}
