package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest{
	@BeforeMethod
	public void setup(){
		mainPage.navigateToShopTab();
	}

	@Test(priority = 0)
	public void addItem() throws InterruptedException{
		shopTab.addCartClick(shopTab.getAddCart1());
		Thread.sleep(1000);
		mainPage.navigateToCartTab();
		excelReader.checkWithAssert("Sheet1", 10, 3, cartTab.getProductName1().getText());
	}

	@Test(priority = 1)
	public void deleteItem() throws InterruptedException{
		addItem();
		mainPage.navigateToCartTab();
		cartTab.removeClick();
		Assert.assertEquals(cartTab.getText().getText(), excelReader.getData("Sheet1", 9, 2));
	}	
	
	@Test(priority = 2)
	public void add2Item() throws InterruptedException{
		shopTab.addCartClick(shopTab.getAddCart2());
		Thread.sleep(1000);
		shopTab.addCartClick(shopTab.getAddCart3());
		Thread.sleep(1000);
		mainPage.navigateToCartTab();
		Assert.assertEquals(cartTab.getProductName2().getText(), excelReader.getData("Sheet1", 11, 3));
		Assert.assertEquals(cartTab.getProductName3().getText(), excelReader.getData("Sheet1", 12, 3));
	}
	
	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
