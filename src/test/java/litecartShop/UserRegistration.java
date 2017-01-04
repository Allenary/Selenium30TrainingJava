package litecartShop;

import org.junit.Test;
import org.openqa.selenium.By;
import static testHelper.DataGenerator.getUniqueString;

import testHelper.TestAncestor;

public class UserRegistration extends TestAncestor{

	@Test
	public void test() {
            String email = "mail"+getUniqueString()+"@test.com";
            String password = "testPass123";
            
		driver.get("http://litecart.resscode.org.ua/en/create_account");
		driver.findElement(By.name("firstname")).sendKeys("testFirstName");
		driver.findElement(By.name("lastname")).sendKeys("testLastName");
		driver.findElement(By.name("address1")).sendKeys("testAddress1");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		driver.findElement(By.name("city")).sendKeys("testCity");
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phone")).sendKeys("123456789");
		 
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmed_password")).sendKeys(password);
		driver.findElement(By.name("create_account")).click();
		
//logout
		driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
//logout		
		driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
	}

}
