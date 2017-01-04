package litecartShop;

import Pages.litecartShop.UserRegistrationPage;
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
            new UserRegistrationPage(driver).createAccount(email, password);
		
//logout
		driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
//logout		
		driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
	}

}
