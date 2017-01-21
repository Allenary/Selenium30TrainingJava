/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartAdmin;

import Pages.litecartAdmin.AdminLoginPage;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestAncestor;

/**
 *
 * @author nd
 */
public class Task14ExternalLinks  extends TestAncestor{
    
     @Test
     public void hello() {
         new AdminLoginPage(driver).login();
         driver.get("http://litecart.resscode.org.ua/admin/?app=countries&doc=edit_country&country_code=AF");
         List<WebElement> links = driver.findElements(By.className("fa-external-link"));
         String mainWindow = driver.getWindowHandle();
         Set<String> allOpenedWindows = driver.getWindowHandles();
         for(WebElement link: links){
             link.click();
             WebDriverWait wait = new WebDriverWait(driver, 5);
             wait.until(ExpectedConditions.numberOfWindowsToBe(allOpenedWindows.size()+1));
             Set<String> allWindows = driver.getWindowHandles();
             allWindows.removeAll(allOpenedWindows);
             driver.switchTo().window(allWindows.iterator().next());
             driver.close();
             driver.switchTo().window(mainWindow);
         }
     }
}
