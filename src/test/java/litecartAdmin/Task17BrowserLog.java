/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartAdmin;

import Pages.litecartAdmin.AdminLoginPage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import testHelper.TestAncestor;

/**
 *
 * @author nd
 */
public class Task17BrowserLog extends TestAncestor{

     @Test
     public void checkBrowserLogOnEditProductPage() {
        new AdminLoginPage(driver).login();
        driver.get("http://litecart.resscode.org.ua/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> products = driver.findElements(By.cssSelector("td:nth-child(3)>a[href*=product_id]"));
        List<String> urls = new ArrayList<>();
        products.forEach((c)->urls.add(c.getAttribute("href")));
        for(String url:urls){
            driver.get(url);
            driver.manage().logs().get(LogType.BROWSER).getAll().forEach(l->System.out.println(l));
            assertEquals("no message in log",0,driver.manage().logs().get(LogType.BROWSER).getAll().size());
        }
    }
}
