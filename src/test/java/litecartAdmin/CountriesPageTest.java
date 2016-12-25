package litecartAdmin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.AdminLoginPage;
import org.junit.Ignore;

public class CountriesPageTest extends TestAncestor {

	@Ignore
        @Test
	public void ListCountries_ShouldBeSortedAsc() {
		(new AdminLoginPage(driver)).login();
		driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
		int columnId = getColumnIdByName("Name");
		List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child("+columnId+")"));
		List<String> countryNames = WebElemsHelper.getElemsTexts(elems);
		for (int i = 1; i < countryNames.size(); i++) {
	        assertTrue(countryNames.get(i).compareTo(countryNames.get(i-1)) > 0);
	    }
	}
        
	@Ignore
        @Test
	public void GeoZones_ShouldBeSortedAsc() {
            (new AdminLoginPage(driver)).login();
            driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
            int columnId = getColumnIdByName("Zones");
            int nameColumnId = getColumnIdByName("Name");
            List<WebElement> rows = driver.findElements(By.className("row"));
            for(WebElement row: rows){
                if(!row.findElement(By.cssSelector("td:nth-child("+columnId+")")).getText().equalsIgnoreCase("0")){
                    System.out.println(row.findElement(By.cssSelector("td:nth-child("+nameColumnId+")")).getAttribute("href"));
                }
            }
            
        }	
	private int getColumnIdByName(String columnName){
		List<WebElement> headerCells = driver.findElements(By.tagName("th"));
		for (int i=0; i< headerCells.size(); i++){
			if(headerCells.get(i).getText().matches(columnName)) return i+1;
		}
		return -1;
	}
	
	
	
	
}
