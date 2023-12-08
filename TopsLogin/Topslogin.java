package TopsLogin;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.DriverConnection;

public class Topslogin {

	static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new DriverConnection().getConnectionDriver();
		driver.get("https://careercenter.tops-int.com/");
	}

	@Test(dataProvider = "dp")
	public void login(String mobile, String password) throws InterruptedException {
		WebElement num = driver.findElement(By.id("mobile"));
		num.clear();
		num.sendKeys(mobile);
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.clear();
		pswd.sendKeys(password);
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/input"));
		login.click();
	}
	@Test(priority = 5)
 public void mycourses() {
	 WebElement course = driver.findElement(By.id("course-dropdown"));
	 course.click();
	}
	 @Test(priority =6)
	 public void coursedetails () {
		 WebElement coursedetails = driver.findElement(By.linkText("Course Details"));
		 coursedetails.click();
	 }
	 
	 
 
	@DataProvider(name = "dp")
	public Object[][] dpmethod() {
		Object o[][] = new Object[4][2];

		o[0][0] = "123456789";
		o[0][1] = "123456789";

		o[1][0] = "Dip";
		o[1][1] = "Dip";

		o[2][0] = "123456789";
		o[2][1] = "Dip";

		o[3][0] = "8866017935";
		o[3][1] = "8866017935";
		return o;
	}
}
