package litecartAdmin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.AdminLoginPage;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import static testHelper.ArrayHelper.isSortedAsc;
import static testHelper.WebDriverHelper.getDriver;
import static testHelper.WebElemsHelper.getElemsTexts;

@RunWith(Parameterized.class)
public class CountriesPageTest extends TestAncestor {
    @Parameterized.Parameter 
    public String url;
    
	@Ignore
        @Test
	public void ListCountries_ShouldBeSortedAsc() {
		(new AdminLoginPage(driver)).login();
		driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
		List<String> columnHeaders = getElemsTexts(driver.findElements(By.tagName("th")));
                int columnId = columnHeaders.indexOf("Name") + 1;
		List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child("+columnId+")"));
		List<String> countryNames = WebElemsHelper.getElemsTexts(elems);
	        assertTrue(isSortedAsc(countryNames));
	}
        
        @Parameters
	public static Collection<Object[]> GeoZones_ShouldBeSortedAsc() {
            WebDriver driver = getDriver();
            (new AdminLoginPage(driver)).login();
            driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
            List<String> columnHeaders = getElemsTexts(driver.findElements(By.tagName("th")));
            int columnId = columnHeaders.indexOf("Zones")+1;
            int nameColumnId = columnHeaders.indexOf("Name")+1;
            List<WebElement> rows = driver.findElements(By.className("row"));
            Collection<Object[]> urls = new ArrayList();
            for(WebElement row: rows){
                if(!row.findElement(By.cssSelector("td:nth-child("+columnId+")")).getText().equalsIgnoreCase("0")){
                    urls.add(new Object[] {row.findElement(By.cssSelector("td:nth-child("+nameColumnId+") a")).getAttribute("href")});
                }
            }
           return urls; 
        }	
	
	
	
	
	
}
