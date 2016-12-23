package litecartAdmin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.AdminLoginPage;

public class CountriesPageTest extends TestAncestor {

	/*
	 * проверить, что страны расположены в алфавитном порядке
	 */
	@Test
	public void test() {
		(new AdminLoginPage(driver)).login();
		driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
		int columnId = getColumnIdByName("Name");
		List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child("+columnId+")"));
		List<String> countryNames = WebElemsHelper.getElemsTexts(elems);
		for (int i = 1; i < countryNames.size(); i++) {
	        assertTrue(countryNames.get(i-1).compareTo(countryNames.get(i)) > 0);
	    }
		
	}
		
	private int getColumnIdByName(String columnName){
		List<WebElement> headerCells = driver.findElements(By.tagName("th"));
		for (int i=0; i< headerCells.size(); i++){
			//System.out.println(headerCells.get(i).getText());
			if(headerCells.get(i).getText().matches(columnName)) return i+1;
		}
		return -1;
	}
	
	
	
	
}
