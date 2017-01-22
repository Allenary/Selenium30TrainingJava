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
        int totalCountProducts = 3;
        
        //add products
        for (int countProducts = 1; countProducts <= totalCountProducts; countProducts++){                     
            ViewProductPage productPage = new ViewProductPage(driver, productUrls.get(countProducts));
            productPage.addToCart(); 
            cartWidget.waitForCountUpdateTo(countProducts);
        }
        
        CartPage cartPage = cartWidget.openCart();
        
        //remove products
        for (int countProducts = totalCountProducts; countProducts >= 0; --countProducts){
            cartPage.removeProduct();
            cartPage.waitForCountProductsToBe(countProducts);
        }
    }
}
