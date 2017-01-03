package litecartAdmin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.DateHelper;
import testHelper.TestAncestor;
import Pages.AdminLoginPage;

public class AddProductTest extends TestAncestor {

	@Test
	public void test() {
		(new AdminLoginPage(driver)).login();
        driver.get("http://litecart.resscode.org.ua/admin/?app=catalog&doc=catalog");
        driver.findElement(By.linkText("Add New Product")).click();
        //General tab
        driver.findElement(By.name("name[en]")).sendKeys("TestName");
        driver.findElement(By.name("code")).sendKeys("TestCode");
        WebElement quantity =driver.findElement(By.name("quantity")); 
        quantity.clear();
        quantity.sendKeys("3");
        File file = new File("resources/test.jpg");
        String absolutePath = file.getAbsolutePath();
        driver.findElement(By.name("new_images[]")).sendKeys(absolutePath);
        
        Date dateStart = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        driver.findElement(By.name("date_valid_from")).sendKeys(dateFormat.format(dateStart));
        Date dateEnd = DateHelper.getTodayPlusOneYear();
        driver.findElement(By.name("date_valid_to")).sendKeys(dateFormat.format(dateEnd));
        
  
	}

}
