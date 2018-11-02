package tut.driver;

import static tut.utils.PropertiesReader.getPropertyValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverSingleton {

	private static final int IMPLICIT_WAIT = Integer.parseInt(getPropertyValue("IMPLICIT_WAIT"));
	private static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(getPropertyValue("PAGE_LOAD_TIMEOUT"));
	protected static WebDriver driver;
	
	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}

}
