package steps;

import org.jbehave.core.annotations.*;
import org.testng.Assert;

import core.Base;
import pages.GoogleHomePage;
import pages.GoogleResultPage;

public class GoogleSteps extends Base {
	private GoogleHomePage googleHomePage;
	private GoogleResultPage googleResultPage;

	@Given("I am on $url page")
	public void i_am_on_web_page(String url) {
		googleHomePage = new GoogleHomePage();
		googleHomePage.open(url);
	}

	@When("I entered <searchText> and submit search")
	public void i_entered_search_text_and_submit_search(@Named("searchText") String searchText) {
		googleResultPage = googleHomePage.enterSearchText(searchText);
	}

	@Then("I validate that a result should have $expectedResult if i entered $text")
	public void validate_result(String expectedResult, String text) {
		if (text == "JBehave") {
			Assert.assertTrue(googleResultPage.validateIfResultsContainText(expectedResult),
					"Expect search result with JBehave value to have 'What is JBehave?' but found nothing!");
		} else {
			Assert.assertFalse(googleResultPage.validateIfResultsContainText(expectedResult),
					"Expect the result not show 'What is JBehave?' but expected result appeared!");
		}
	}
}
