Narrative:
In order to get search result
As a user
I want to make sure that google search page works as expected

Scenario: Negative test log in page.
Given I am on https://google.com page
When I entered <searchText> and submit search
Then I validate that a result should have What is JBehave? if i entered JBehave

Examples:
| searchText |
| JBehave    |
| Others     |