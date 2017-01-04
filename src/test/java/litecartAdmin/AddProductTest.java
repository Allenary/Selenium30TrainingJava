package litecartAdmin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testHelper.DateHelper;
import testHelper.TestAncestor;
import Pages.AdminLoginPage;

public class AddProductTest extends TestAncestor {

	@Test
	public void test() {
		/*TODO: verify in FF
		 *  change names to unique
		 *   change selectors to more efficient than searching by text
		 *   add assertion
		 *   make product enabled
		 *   use pageObject
		 */
		(new AdminLoginPage(driver)).login();
        driver.get("http://litecart.resscode.org.ua/admin/?app=catalog&doc=catalog");
        //driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();
        //General tab
        driver.findElement(By.name("name[en]")).sendKeys("TestName");
        driver.findElement(By.name("code")).sendKeys("TestCode");
        WebElement quantity =driver.findElement(By.name("quantity")); 
        quantity.clear();
        quantity.sendKeys("3");
        File file = new File("src/test/resources/test.jpg");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        driver.findElement(By.name("new_images[]")).sendKeys(absolutePath);
        
        Date dateStart = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        driver.findElement(By.name("date_valid_from")).sendKeys(dateFormat.format(dateStart));
        Date dateEnd = DateHelper.getTodayPlusOneYear();
        driver.findElement(By.name("date_valid_to")).sendKeys(dateFormat.format(dateEnd));
        
        //Information tab
        //driver.findElement(By.linkText("Information")).click();
        driver.findElement(By.cssSelector(".tabs li:nth-child(2)")).click();
        new Select(driver.findElement(By.name("manufacturer_id"))).selectByIndex(1);
        driver.findElement(By.name("keywords")).sendKeys("test keyword");
        driver.findElement(By.name("short_description[en]")).sendKeys("test short desription");
        
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("test full description");
        driver.findElement(By.name("head_title[en]")).sendKeys("test title");
        driver.findElement(By.name("meta_description[en]")).sendKeys("test meta");
        
        //Prices tab
        //driver.findElement(By.linkText("Prices")).click();
        driver.findElement(By.cssSelector(".tabs li:nth-child(4)")).click();
        driver.findElement(By.name("purchase_price")).sendKeys("5");
        new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByValue("USD");
        
       driver.findElement(By.name("save")).click();
	}

}
