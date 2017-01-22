/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author nd
 */
public class CartPage extends AbstractPage{
    @FindBy(css = "td.item")
    List<WebElement> products;
    @FindBy(id = "order_confirmation-wrapper")
    WebElement table;
    

    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    public void removeProduct(){
        driver.findElement(By.name("remove_cart_item")).click();
    }
    
    public int countProducts(){
        return products.size();
    }
    
    public void waitForTableUpdate(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.stalenessOf(table));
    }
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/en/checkout";
    }
    
}
