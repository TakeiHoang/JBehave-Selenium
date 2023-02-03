package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.Driver;
import core.Page;

public class GoogleHomePage extends Page {
	@FindBy(name = "q")
	WebElement inputSearchBox;

	public void open(String url) {
		Driver.driver.get(url);
	}

	public GoogleResultPage enterSearchText(String searchText) {
		inputSearchBox.isDisplayed();
		type(inputSearchBox, searchText);
		submit(inputSearchBox);
		return new GoogleResultPage();
	}
}
