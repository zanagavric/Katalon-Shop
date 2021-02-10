package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ShopPage;

public class BaseTest {

	WebDriver driver;
	MyAccountPage myAccountPage;
	MainPage mainPage;
	ExcelReader excelReader;
	ShopPage shopTab;
	CartPage cartTab;
	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.mainPage = new MainPage(driver);
		this.excelReader = new ExcelReader("data/test plan.xlsx");
		this.shopTab = new ShopPage(driver);
		this.cartTab = new CartPage(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.navigate().to("http://cms.demo.katalon.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void theAnd() throws IOException {
		driver.close();
		excelReader.fis.close();
	}
}
