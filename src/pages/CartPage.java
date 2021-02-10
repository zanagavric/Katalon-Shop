package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement productName1;
	WebElement productName2;
	WebElement productName3;
	WebElement remove;
	WebElement text;
	WebElement textmessage;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTextmessage() {
		return driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
	}

	public WebElement getText() {
		return driver.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
	}

	public WebElement getRemove() {
		return driver.findElement(By.className("remove"));
	}	
	
	public WebElement getProductName1() {
		return driver.findElement(By.xpath("//a[text()='Flying Ninja']"));      
	}

	public WebElement getProductName2() {
		return driver.findElement(By.xpath("//a[text()='Ninja Silhouette']"));
	}

	public WebElement getProductName3() {
		return driver.findElement(By.xpath("//a[text()='Premium Quality']"));
	}

	public void removeClick() {
		driver.findElement(By.className("remove")).click();
	}
	
	public void assertProductName(WebElement element){
		element.getText();
	}

}
