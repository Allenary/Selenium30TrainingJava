/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartAdmin;

import Pages.AbstractPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nd
 */
public class CatalogPage extends AbstractPage{
    @FindBy(css="[name^=products]")
    List<WebElement> productRows;
    
    public CatalogPage(WebDriver driver) {
        super(driver);
    }
    
    public int countProducts(){
        return productRows.size();
    }
    public void navigateToAddProductPage(){
        driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();
    }
    
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/admin/?app=catalog&doc=catalog";
    }
    
}
