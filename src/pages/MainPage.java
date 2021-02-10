package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement cartTab;
	WebElement myAccountTab;
	WebElement shopTab;

	public WebElement getCartTab() {
		return driver.findElement(By.xpath("//a[text()='Cart']"));
	}

	public WebElement getMyAccauntTab() {
		return driver.findElement(By.className("page-item-10"));
	}

	public WebElement getShopTab() {
		return driver.findElement(By.xpath("//a[text()='Shop']"));
	}

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToCartTab() {
		this.getCartTab().click();
	}

	public void navigateToShopTab() {
		this.getShopTab().click();
	}

	public void navigateToMyAccount() {
		this.getMyAccauntTab().click();
	}
}
