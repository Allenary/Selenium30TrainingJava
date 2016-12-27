package litecartShop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

import testHelper.TestAncestor;

public class UserRegistration extends TestAncestor{

	@Test
	public void test() {
		driver.get("http://litecart.resscode.org.ua/en/create_account");
		driver.findElement(By.name("firstname")).sendKeys("testFirstName");
		driver.findElement(By.name("lastname")).sendKeys("testLastName");
		driver.findElement(By.name("address1")).sendKeys("testAddress1");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		driver.findElement(By.name("city")).sendKeys("testCity");
		String email = "mail"+System.currentTimeMillis()+"@test.com";
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phone")).sendKeys("123456789");
		String password = "testPass123"; 
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmed_password")).sendKeys(password);
		driver.findElement(By.name("create_account")).click();
		
		driver.findElement(By.cssSelector("#box-account li:last-child")).click();
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		
		System.out.println(email);
	}

}
