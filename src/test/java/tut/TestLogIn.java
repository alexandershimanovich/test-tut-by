package tut;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tut.utils.PropertiesReader.getPropertyValue;

import tut.steps.Steps;

public class TestLogIn {
	private Steps steps;
	private static final String MAIL_LOGIN = getPropertyValue("EMAIL_LOGIN");
	private static final String PASSWORD_ENTER = getPropertyValue("PASSWORD_ENTER");
	private static final int NUMBER_OF_MAILS = Integer.parseInt(getPropertyValue("NUMBER_OF_MAILS"));

	@BeforeMethod(description = "Open WebSite")
	public void start() {
		steps = new Steps();
		steps.openBrowser();
		steps.openWebSite();
	}

	@Test
	public void checkNumberOfInboxMessage() {
		steps.logInToMail(MAIL_LOGIN, PASSWORD_ENTER);
		steps.enterToMailPage();
		assertEquals(steps.checkNumberOfMail(), NUMBER_OF_MAILS);
	}

	@AfterMethod(description = "Close Browser")
	public void finish() {
		steps.closeBrowser();
	}

}
