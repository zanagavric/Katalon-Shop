package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	WebDriver driver;
	WebElement addCart1;
	WebElement addCart2;
	WebElement addCart3;

	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddCart1() {
		return driver.findElement(By.xpath("//a[@data-product_id='54']"));
	}

	public WebElement getAddCart2() {
		return driver.findElement(By.xpath("//a[@aria-label='Add “Ninja Silhouette” to your cart']"));
	}

	public WebElement getAddCart3() {
		return driver.findElement(By.xpath("//a[@aria-label='Add “Premium Quality” to your cart']"));
	}

	public void probaClick() {	
		getAddCart1().click();
	}
	
	public void addCartClick(WebElement element) {	
		element.click();
	}
}
