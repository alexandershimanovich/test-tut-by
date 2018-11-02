package tut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static tut.utils.PropertiesReader.getPropertyValue;

public class MainPage extends AbstractPage {

	private static final String URL = getPropertyValue("URL");

	@FindBy(className = "enter")
	WebElement buttonEnter;

	@FindBy(name = "login")
	WebElement inputLogin;

	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement buttonSubmit;
	
	@FindBy(xpath = "//li[@class='topbar__li'][2]//a")
	WebElement buttonMail;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.get(URL);
	}

	public void clickButtonEntry() {
		buttonEnter.click();
	}

	public void enterEmailLogin(String login) {
		inputLogin.sendKeys(login);
	}

	public void enterEmailPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void clickButtonSubmit() {
		buttonSubmit.click();
	}
	
	public MailPage clickMailButton() {
		buttonMail.click();
		return new MailPage(driver);
	}

}
