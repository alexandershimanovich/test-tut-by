package tut.steps;

import org.openqa.selenium.WebDriver;

import tut.driver.DriverSingleton;
import tut.pages.MailPage;
import tut.pages.MainPage;

public class Steps {
	
	private WebDriver driver;
	private MainPage mainPage;
	private MailPage mailPage;

	public void openBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	public void closeBrowser() {
		DriverSingleton.closeDriver();
	}
	
	public void openWebSite() {
		mainPage = new MainPage(driver);
		mainPage.openPage();
	}
	
	public void logInToMail(String login, String password) {
		mainPage = new MainPage(driver);
		mainPage.clickButtonEntry();
		mainPage.enterEmailLogin(login);
		mainPage.enterEmailPassword(password);
		mainPage.clickButtonSubmit();
	}
	
	public void enterToMailPage() {
		mainPage = new MainPage(driver);
		mainPage.clickMailButton();
	}
	
	public int checkNumberOfMail() {
		mailPage = new MailPage(driver);
		return mailPage.tackNumberOfEmails();
	}

}
