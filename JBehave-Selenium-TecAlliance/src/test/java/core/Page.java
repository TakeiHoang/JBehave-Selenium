package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	public Page() {
		PageFactory.initElements(Driver.driver, this);
	}

	protected boolean isElementPresent(By locator) {
		Driver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> elements = Driver.driver.findElements(locator);
		Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	protected void type(WebElement webElement, String text) {
		webElement.clear();
		webElement.sendKeys(text);
	}

	protected void submit(WebElement webElement) {
		webElement.submit();
	}

	protected void waitUntilVisible(WebElement locator, int seconds) {
		WebDriverWait waiter = new WebDriverWait(Driver.driver, seconds);
		waiter.until(ExpectedConditions.visibilityOf(locator));
	}
}
