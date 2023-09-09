package Test_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import POM.Base;

public class Order {
	WebDriver driver;
	Base HP;
	//Read_data data= new Read_data();

	
	@BeforeTest
	public void beforetest() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			HP= new Base(driver);
			}
	
	@Test(priority=1)
	public void Verify_Login_Page() {
			Assert.assertEquals(HP.get_page_title(),"Swag Labs");
			}
	
	@Test(priority=2)
	public void Validate_true_login() {
			String res=HP.Login("standard_user","secret_sauce");
			Assert.assertEquals(res,"https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority=3)
	public void Validate_add_to_cart() {
		String res=HP.add_item_to_cart();
		Assert.assertEquals(res,"1");
	}
	
	@Test(priority=4)
	public void Validate_cart_checkout() {
		String res=HP.Checkout("test", "test1", "11211");
		Assert.assertEquals(res,"Thank you for your order!");
	}
	
	@Test(priority=5)
	public void Validate_logout() {
		String res=HP.logout();
		Assert.assertEquals(res,"https://www.saucedemo.com/");
	}
	
	
	@AfterTest
	public void aftertest() {
		driver.close();
	}

}
