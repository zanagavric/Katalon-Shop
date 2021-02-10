package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement logInButton;
	WebElement userNameInputField;
	WebElement passwordNameInputField;
	WebElement logOutLabel;
	WebElement errorCredentialsLabel;

	public WebElement getErrorCredentialsLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li"));
	}

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.name("login"));
	}

	public WebElement getUserNameInputField() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordNameInputField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLogOutLabel() {
		return driver.findElement(By.linkText("Log out"));
	}

	public void insertUsername(String username) {
		this.getUserNameInputField().sendKeys(username);
	}

	public void insertPassword(String password) {
		this.getPasswordNameInputField().sendKeys(password);
	}

	public void logInButtonClick() {
		this.getLogInButton().click();
	}

	public void logOutLabelClick() {
		this.getLogOutLabel().click();
	}

	public void logIn(String username, String password) {
		this.insertUsername(username); 
		this.insertPassword(password);
		this.logInButtonClick();
	}
}
