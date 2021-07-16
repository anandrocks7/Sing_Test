package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.TodoMVCPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataPojos.Data;

public class TodoListScenariosStepDef {

	private WebDriver driver;
	public Data data;

	public TodoListScenariosStepDef() {
		this.driver= Hooks.getDriver();
	}
	TodoMVCPage todoMVCPage;

	@Given("^User is on the ToDo list Page$")
	public void empty_todo_list_is_available() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);	        
		Assert.assertTrue(todoMVCPage.getHeaderText().equalsIgnoreCase("todos"), "Header text message is not correct");	        
	}

	@When("^user add first item \"([^\"]*)\"$")
	public void user_add_first_item(String arg1) throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.enterItem(arg1);
		todoMVCPage.pressEnterKey();
	}

	@Then("^only that item is displayed$")
	public void only_that_item_is_displayed() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		data= new Data();
		Assert.assertTrue(todoMVCPage.returnItemLabelBasedOnNumber(1).equalsIgnoreCase(data.item1), "Item label is not correctly displayed");
	}

	@Then("^the list summary shows \"([^\"]*)\"$")
	public void the_list_summary_shows(String arg1) throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		Assert.assertTrue(todoMVCPage.countLeftText().equalsIgnoreCase(arg1), "Footer count is not displayed correctly");

	}
	@Then("^the lists selection is set to All$")
	public void the_lists_selection_is_set_to_All() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		data= new Data();
		Assert.assertTrue(todoMVCPage.footerLinkAllIsSelected().equalsIgnoreCase(data.selected), "Footer ALL link is not selected");
	}


	@Then("^Clear completed button is not displayed$")
	public void clear_completed_button_is_not_displayed() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		Assert.assertTrue(!todoMVCPage.clearCompletedButtonIsDisplayed(), "Clear completed button is displayed: Fail");
	}


	@Given("^User is on the  ToDo list Page$")
	public void user_is_on_the_ToDo_list_Page() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		Assert.assertTrue(todoMVCPage.getHeaderText().equalsIgnoreCase("todos"), "Header text message is not correct");
	}

	@When("^user add Two items$")
	public void user_add_Two_items() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.addTwoMoreItems();
	}

	@Then("^only those item are displayed$")
	public void only_those_item_are_displayed() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		data= new Data();
		Assert.assertTrue(todoMVCPage.returnItemLabelBasedOnNumber(2).equalsIgnoreCase(data.item2), "Item label is not correctly displayed");
	}



	@Given("^Todo list with two or more items$")
	public void todo_list_with_two_or_more_items() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.addTwoMoreItems();
	}

	@When("^the first item is marked as complete$")
	public void the_first_item_is_marked_as_complete() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.clickFirstRadioButtonToComplete();

	}

	@Then("^only the second item is listed as active$")
	public void only_the_second_item_is_listed_as_active() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.clickFiterLinkActive();
		int itemsleft= todoMVCPage.getSizeOfItems();
		data= new Data();
		Assert.assertTrue(todoMVCPage.returnItemLabelBasedOnNumber(itemsleft).equalsIgnoreCase(data.item2), "Item label is correct: Fail");	
	}

	@Then("^Clear completed button is displayed$")
	public void clear_completed_button_is_displayed() throws Throwable {

		todoMVCPage = new TodoMVCPage(driver);
		Assert.assertTrue(todoMVCPage.clearCompletedButtonIsDisplayed(), "Clear completed button is not  displayed: Fail");
	}

	@When("^user clicks on Completed filter$")
	public void user_clicks_on_Completed_filter() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.clickFiterLinkCompleted();
		todoMVCPage.waitForPageLoad();
	}

	@Then("^only the completed item is displayed$")
	public void only_the_completed_item_is_displayed() throws Throwable {

		todoMVCPage = new TodoMVCPage(driver);
		data= new Data();
		int itemsCompleted= todoMVCPage.getSizeOfItems();
		Assert.assertTrue(todoMVCPage.returnItemLabelBasedOnNumber(itemsCompleted).equalsIgnoreCase(data.item1), "Completed item is not displayed");	
	}

	@When("^user clicks on Active filter$")
	public void user_clicks_on_Active_filter() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.clickFiterLinkActive();
	}

	@Then("^the completed item is not displayed$")
	public void the_completed_item_is_not_displayed() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		int itemsActive= todoMVCPage.getSizeOfItems();
		data= new Data();
		Assert.assertTrue(todoMVCPage.returnItemLabelBasedOnNumber(itemsActive).equalsIgnoreCase(data.item2), "Active items not  displayed");
	}


	@When("^user clicks on Clear Completed button$")
	public void user_clicks_on_Clear_Completed_button() throws Throwable {
		todoMVCPage = new TodoMVCPage(driver);
		todoMVCPage.clickButtonClearCompleted();
	}

}
