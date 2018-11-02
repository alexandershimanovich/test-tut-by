package tut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends AbstractPage {

	@FindBy(xpath = "//span[@class = 'mail-NestedList-Item-Info-Link-Text']")
	WebElement numberOfEmails;

	public MailPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
	}

	public int tackNumberOfEmails() {
		return Integer.parseInt(numberOfEmails.getText());
	}

}
