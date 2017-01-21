package litecartAdmin;

import static org.junit.Assert.assertTrue;
import static testHelper.ArrayHelper.isSortedAsc;
import static testHelper.WebElemsHelper.getElemsTexts;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.litecartAdmin.AdminLoginPage;

public class CountriesPageTest extends TestAncestor {
    
    @Test
	public void ListCountries_ShouldBeSortedAsc() {
		(new AdminLoginPage(driver)).login();
		driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
		List<String> columnHeaders = getElemsTexts(driver.findElements(By.tagName("th")));
        int columnId = columnHeaders.indexOf("Name") + 1;
		List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child("+columnId+")"));
		List<String> countryNames = WebElemsHelper.getElemsTexts(elems);
                assertTrue(countryNames.size()>0);
	    assertTrue(isSortedAsc(countryNames));
	}
        
}
