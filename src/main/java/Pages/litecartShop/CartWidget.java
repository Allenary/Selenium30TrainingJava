/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nd
 */
public class CartWidget extends AbstractPageComponent{
    @FindBy(className = "quantity")
    private WebElement countProducts;
    @FindBy(css = "#cart a.link")
    private WebElement checkout;
    
    public CartWidget(WebDriver driver) {
        super(driver);
    }
    
    public int countProducts(){
        return Integer.parseInt(countProducts.getText());
    }
    public CartPage openCart(){
        checkout.click();
        return new CartPage(driver);
    }
}
