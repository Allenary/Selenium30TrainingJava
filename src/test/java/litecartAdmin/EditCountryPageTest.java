package litecartAdmin;

import static testHelper.ArrayHelper.isSortedAsc;
import static testHelper.WebDriverHelper.getDriver;
import static testHelper.WebElemsHelper.getElemsTexts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;
import testHelper.WebElemsHelper;
import Pages.AdminLoginPage;

@RunWith(Parameterized.class)
public class EditCountryPageTest extends TestAncestor {
	@Parameterized.Parameter 
    public String url;
	
	@Parameters
	public static Collection<Object[]> getEditCountryPagesUrl() {
        WebDriver driver = getDriver();
        (new AdminLoginPage(driver)).login();
        driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=countries");
        List<String> columnHeaders = getElemsTexts(driver.findElements(By.tagName("th")));
        int columnZoneId = columnHeaders.indexOf("Zones")+1;
        List<WebElement> countryNames = driver.findElements(By.xpath(".//td["+columnZoneId+"][text()!='0']/preceding-sibling::td[1]/a"));
        Collection<Object[]> urls = new ArrayList<Object[]>();
        countryNames.forEach((c)->urls.add(new Object[] {c.getAttribute("href")}));
        driver.quit();
        return urls; 
    }
	
	@Test
	public void  GeoZones_ShouldBeSortedAsc() {
		(new AdminLoginPage(driver)).login();
        driver.get(url);
        List<WebElement> elems = driver.findElements(By.xpath(".//input[contains(@name,'[name]') and @type='hidden']/.."));
        List<String> geoZonesNames = WebElemsHelper.getElemsTexts(elems);
        Assert.assertEquals(true,isSortedAsc(geoZonesNames));
	}

}
