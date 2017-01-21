/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartShop;

import Pages.litecartShop.CartWidget;
import Pages.litecartShop.MainPage;
import Pages.litecartShop.ViewProductPage;
import java.util.List;
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
public class CartTest extends TestAncestor{
    
    @Test
    public void hello() {
        List<String> productUrls =new MainPage(driver).PopularProductsUrls();
        int countProducts = new CartWidget(driver).countProducts();
        //add products
        for (int i=0; i<3; i++){
            ViewProductPage productPage = new ViewProductPage(driver, productUrls.get(i));
            WebElement e = driver.findElement(By.className("quantity"));
            productPage.addToCart();
            countProducts++;
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.textToBe(By.className("quantity"), String.valueOf(countProducts)));
            //assertEquals(countProducts, new CartWidget(driver).countProducts());
        }
        new CartWidget(driver).openCart();
        for (int i=0; i<3; i++){
            WebElement table = driver.findElement(By.id("order_confirmation-wrapper"));
            driver.findElement(By.name("remove_cart_item")).click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.stalenessOf(table));
        }
    }
}
