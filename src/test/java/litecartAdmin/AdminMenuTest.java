package litecartAdmin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;

public class AdminMenuTest extends TestAncestor {
	private String url = "http://litecart.resscode.org.ua/admin/";
	private String adminLogin = "admin";
	private String adminPass = "admin123";
	
	private void login(){
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(adminLogin);
		driver.findElement(By.name("password")).sendKeys(adminPass);
		driver.findElement(By.name("login")).click();
	}
	
	@Test
	public void VerifyMenuList() {
		login();
		int countMenuItems = driver.findElements(By.id("app-")).size();
		for (int i=1; i<= countMenuItems; i++){
			verifyMenuItem(By.cssSelector("[id=app-]:nth-of-type("+i+")"));
			
			List<WebElement> subMenuItems = driver.findElements(By.cssSelector("[id^=doc-]"));
			if(subMenuItems.size()>0){
				List<String> subMenuIds = getListofIds(subMenuItems);
				for(String id:subMenuIds ){
					verifyMenuItem(By.id(id));
				}
				
			}
		}
	}
	
	private void verifyMenuItem(By locator){
		driver.findElement(locator).click();
		assertEquals(1, driver.findElements(By.tagName("h1")).size());
	}
	
	private List<String> getListofIds(List<WebElement> elems){
		List<String> elemsIds = new ArrayList<String>();
		for(WebElement el: elems){
			elemsIds.add(el.getAttribute("id"));
			System.out.println("subMenuItemId: "+ el.getAttribute("id"));
		}
		return elemsIds;
	}

}
