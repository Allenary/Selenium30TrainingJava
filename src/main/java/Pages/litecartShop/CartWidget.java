/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testHelper.TestConstants;

/**
 *
 * @author nd
 */
public class CartWidget extends AbstractPageComponent{
    @FindBy(className = "quantity")
    private WebElement countProducts;
    @FindBy(css = "#cart a.link")
    private WebElement checkout;
    
    private final WebDriverWait wait;
    
    public CartWidget(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TestConstants.EXPLICIT_WAIT_SECONDS);
    }
    
    public int countProducts(){
        return Integer.parseInt(countProducts.getText());
    }
    public CartPage openCart(){
        checkout.click();
        return new CartPage(driver);
    }
    public void waitForCountUpdateTo(int value){
        wait.until(ExpectedConditions.textToBePresentInElement(countProducts, String.valueOf(value)));
    }
}
