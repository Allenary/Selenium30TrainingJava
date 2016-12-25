/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartAdmin;

import Pages.AdminLoginPage;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testHelper.TestAncestor;
import testHelper.WebElemsHelper;

/**
 *
 * @author nd
 */
public class GeoZonesPageTest extends TestAncestor {
    
    @Ignore 
    @Test
     public void hello() {
         (new AdminLoginPage(driver)).login();
            driver.get("http://litecart.resscode.org.ua/admin/?app=geo_zones&doc=geo_zones");
            List<WebElement> elems = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            List<String> hrefs = new ArrayList();
            for(WebElement e:elems){
                hrefs.add(e.getAttribute("href"));
            }
            hrefs.forEach((h)->System.out.println(h));
     }
     
     @Test
     public void geoZonesSortOrder(){
        driver.get("http://litecart.resscode.org.ua/admin/?app=geo_zones&doc=edit_geo_zone&page=1&geo_zone_id=1");
        List<WebElement> elems = driver.findElements(By.cssSelector("[name*=zone_code][selected]"));
        List<String> geoZonesNames = WebElemsHelper.getElemsTexts(elems);
        for (int i = 1; i < geoZonesNames.size(); i++) {
	        assertTrue(geoZonesNames.get(i).compareTo(geoZonesNames.get(i-1)) > 0);
	    }
     }
}
