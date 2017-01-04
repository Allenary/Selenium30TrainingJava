/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartAdmin;

import Pages.AbstractPageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author nd
 */
public class AddNewProductPricesTab extends AbstractPageComponent{
    @FindBy(name = "purchase_price")
    private WebElement purchasePrice;
    @FindBy(name = "purchase_price_currency_code")
    private WebElement currency;
    @FindBy(name="prices[USD]")
    private WebElement usdPrice;
    @FindBy(name="gross_prices[USD]")
    private WebElement usdPriceWithTax;
    @FindBy(name="prices[EUR]")
    private WebElement eurPrice;
    @FindBy(name="gross_prices[EUR]")
    private WebElement eurPriceWithTax;
    
    public AddNewProductPricesTab(WebDriver driver) {
        super(driver);
    }
    
    public void addPurchasePrice(String price, String currency){
        purchasePrice.clear();
        purchasePrice.sendKeys(price);
        new Select(this.currency).selectByValue(currency);
    }
    public void addUsdPrices(String price, String priceWithTax){
        usdPrice.clear();
        usdPrice.sendKeys(price);
        usdPriceWithTax.clear();
        usdPriceWithTax.sendKeys(priceWithTax);
    }
    
}
