/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartShop;

import Pages.litecartShop.CartPage;
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
import testHelper.TestConstants;

/**
 *
 * @author nd
 */
public class CartTest extends TestAncestor{
    
    @Test
    public void CartComplexTest() {
        List<String> productUrls =new MainPage(driver).PopularProductsUrls();
        CartWidget cartWidget = new CartWidget(driver);
        //add products
        for (int i=0; i<3; i++){           
            int countProducts = cartWidget.countProducts();
            ViewProductPage productPage = new ViewProductPage(driver, productUrls.get(i));
            productPage.addToCart();          
            cartWidget.waitForCountUpdateTo(countProducts+1);
        }
        CartPage cartPage = cartWidget.openCart();//new CartWidget(driver).openCart();
        //remove products
        for (int i=3; i>0; i--){
            WebElement table = driver.findElement(By.id("order_confirmation-wrapper"));
            cartPage.removeProduct();
            WebDriverWait wait = new WebDriverWait(driver, TestConstants.EXPLICIT_WAIT_SECONDS);
            wait.until(ExpectedConditions.stalenessOf(table));
            assertEquals(i-1,cartPage.countProducts());
        }
    }
}
