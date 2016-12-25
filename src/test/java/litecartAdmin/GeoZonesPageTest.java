/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartAdmin;

import Pages.AdminLoginPage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static testHelper.ArrayHelper.isSortedAsc;
import testHelper.TestAncestor;
import static testHelper.WebDriverHelper.getDriver;
import testHelper.WebElemsHelper;

/**
 *
 * @author nd
 */
@RunWith(Parameterized.class)
public class GeoZonesPageTest extends TestAncestor {
    @Parameter 
    public String url;
    
    @Parameters
     public static Collection<Object[]> getAllUrl() {
         WebDriver driver = getDriver();
         (new AdminLoginPage(driver)).login();
            driver.get("http://litecart.resscode.org.ua/admin/?app=geo_zones&doc=geo_zones");
            List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            List<Object[]> hrefs = new ArrayList();
            elems.forEach((e) -> {
                hrefs.add(new Object[] {e.getAttribute("href")});
            });
           driver.quit();
           return hrefs;
     }
    
     @Test
     public void geoZones_ShouldBeSortedAsc(){
        (new AdminLoginPage(driver)).login();
        driver.get(url);
        List<WebElement> elems = driver.findElements(By.cssSelector("[name*=zone_code][selected]"));
        List<String> geoZonesNames = WebElemsHelper.getElemsTexts(elems);
        Assert.assertEquals(true,isSortedAsc(geoZonesNames));
     }
}
