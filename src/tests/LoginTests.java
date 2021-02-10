package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
	@BeforeMethod
	public void setup(){
		mainPage.navigateToMyAccount();
	}

	@Test(priority = 0)
	public void successifulLogIn(){
		String username = excelReader.getData("Sheet1", 2, 2);
		String password = String.valueOf(excelReader.getData("Sheet1", 3, 2));		
		myAccountPage.logIn(username, password);
		String textForAssert = myAccountPage.getLogOutLabel().getText();
		Assert.assertEquals(textForAssert, excelReader.getData("Sheet1", 8, 2));
	}
	
	@Test(priority = 1)
	public void loginWithoutCredentials(){
		String username = "";
		String password = "";	
		myAccountPage.logIn(username, password);
		Assert.assertEquals(myAccountPage.getErrorCredentialsLabel().getText(), excelReader.getData("Sheet1", 18, 2));
	}

	@Test(priority = 2)
	public void loginWithWrongCredential(){
		String username = excelReader.getData("Sheet1", 4, 2);
		String password = excelReader.getData("Sheet1", 3, 2);
		myAccountPage.logIn(username, password);	
		Assert.assertEquals(myAccountPage.getLogInButton().getText(), excelReader.getData("Sheet1", 13, 2));
	}

	@Test (priority = 3)
	public void logOut(){
		successifulLogIn();
		myAccountPage.logOutLabelClick();
		Assert.assertEquals(myAccountPage.getLogInButton().getText(), excelReader.getData("Sheet1", 13, 2));
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
