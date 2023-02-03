package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class Driver {
	private Driver() {

	}

	public static WebDriver driver;

	public static void init() {
		// Configurations for file properties using
		Properties properties = new Properties();
		FileInputStream propFile;
		try {
			propFile = new FileInputStream("test.properties");
			properties.load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		@SuppressWarnings("unchecked")
		Enumeration<String> e = (Enumeration<String>) properties.propertyNames();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			System.setProperty(key, properties.getProperty(key));
		}

		// Setting up WebDriver
		String browser = System.getProperty("test.browser");
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("incognito");
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
		} else {
			throw new AssertionError("Unsupported browser: " + System.getProperty("test.browser"));
		}

		// Configurations for synchronization
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.timeout")),
				TimeUnit.SECONDS); // Configurations for synchronization
	}

	public static void tearDown() {
		driver.quit();
	}
}
