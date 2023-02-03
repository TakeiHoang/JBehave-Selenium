package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GoogleResultPage {
	@FindBys(@FindBy(css = "a h3"))
	List<WebElement> resultsElement = new ArrayList<>();;

	public boolean validateIfResultsContainText(String expectedResult) {
		boolean flag = false;
		for (WebElement e : resultsElement) {
			if (e.getText().contains(expectedResult)) {
				flag = true;
				break;
			}
			flag = false;
		}
		return flag;
	}
}
