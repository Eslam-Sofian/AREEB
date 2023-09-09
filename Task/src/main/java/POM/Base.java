package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
	WebDriver driver;
public Base(WebDriver driver) {
	this.driver=driver;
}

By user_name_input=By.cssSelector("#user-name");
By pass_input=By.cssSelector("#password");
By login_button=By.cssSelector("#login-button");
By add_to_cart_button=By.cssSelector("#add-to-cart-sauce-labs-backpack");
By cart_page=By.cssSelector("#shopping_cart_container > a > span");
By cart_button=By.cssSelector("#shopping_cart_container > a");
By checkout_button=By.cssSelector("#checkout");
By first_name_checkout_input=By.cssSelector("#first-name");
By last_name_checkout_input=By.cssSelector("#last-name");
By postalcode_checkout_input=By.cssSelector("#postal-code");
By continue_checkout_button=By.cssSelector("#continue");
By finish_checkout_button=By.cssSelector("#finish");
By order_success_message=By.cssSelector("#checkout_complete_container > h2");
By menu=By.cssSelector("#react-burger-menu-btn");
By logout_button=By.cssSelector("#logout_sidebar_link");

public  String get_page_title() {
	String Get_Title=driver.getTitle();
	return Get_Title;
}

public void insert_user_name(String txt)
{
	driver.findElement(user_name_input).sendKeys(txt);
}

public void insert_pass(String txt)
{
	driver.findElement(pass_input).sendKeys(txt);
}

public String Login(String user, String pass) {
	insert_user_name(user);
	insert_pass(pass);
	driver.findElement(login_button).click();
	return driver.getCurrentUrl();
	
}

public String add_item_to_cart() {
	driver.findElement(add_to_cart_button).click();
	return driver.findElement(cart_page).getText();
} 
public String Checkout(String FN,String LN,String PC) {
	driver.findElement(cart_button).click();
	driver.findElement(checkout_button).click();
	driver.findElement(first_name_checkout_input).sendKeys(FN);
	driver.findElement(last_name_checkout_input).sendKeys(LN);
	driver.findElement(postalcode_checkout_input).sendKeys(PC);
	driver.findElement(continue_checkout_button).click();
	driver.findElement(finish_checkout_button).click();
	return driver.findElement(order_success_message).getText();
}
public String logout() {
	driver.findElement(menu).click();
	driver.findElement(logout_button).click();
	return driver.getCurrentUrl();
}



}
