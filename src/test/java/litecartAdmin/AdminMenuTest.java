package litecartAdmin;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.AdminLoginPage;

public class AdminMenuTest extends TestAncestor {
	
	@Test
	public void VerifyMenuList() {
		(new AdminLoginPage(driver)).login();
		int countMenuItems = driver.findElements(By.id("app-")).size();
		for (int i=1; i<= countMenuItems; i++){
			verifyMenuItemHeader(By.cssSelector("[id=app-]:nth-of-type("+i+")"));
			
			List<WebElement> subMenuItems = driver.findElements(By.cssSelector("[id^=doc-]"));
			if(subMenuItems.size()>0){
				List<String> subMenuIds = WebElemsHelper.getListOfIds(subMenuItems);
				for(String id:subMenuIds ){
					verifyMenuItemHeader(By.id(id));
				}
				
			}
		}
	}
	
	private void verifyMenuItemHeader(By locator){
		driver.findElement(locator).click();
		assertEquals(1, driver.findElements(By.tagName("h1")).size());
	}
	
	

}
