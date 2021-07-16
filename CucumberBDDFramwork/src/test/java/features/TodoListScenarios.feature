Feature: TODO List Scenarios

Scenario: Add first item to empty List

Given User is on the  ToDo list Page
When user add first item "Test1"
Then only that item is displayed
And the list summary shows "1 item left"
And the lists selection is set to All
And Clear completed button is not displayed


Scenario: Add Two item to empty List

Given User is on the  ToDo list Page
When user add Two items
Then only those item are displayed
And the list summary shows "2 items left"
And the lists selection is set to All
And Clear completed button is not displayed


Scenario: Mark Item as completed and check summary
Given  Todo list with two or more items
When the first item is marked as complete
Then only the second item is listed as active
And the list summary shows "1 item left"
And Clear completed button is displayed


Scenario: Completed item is visible under completed filter
Given  Todo list with two or more items
When the first item is marked as complete
And user clicks on Completed filter
Then only the completed item is displayed


Scenario: Completed item is not visible under Active filter
Given  Todo list with two or more items
When the first item is marked as complete
And user clicks on Active filter
Then  the completed item is not displayed


Scenario: Click on clear completed button and verify
Given  Todo list with two or more items
When the first item is marked as complete
And user clicks on Clear Completed button
Then  the completed item is not displayed
