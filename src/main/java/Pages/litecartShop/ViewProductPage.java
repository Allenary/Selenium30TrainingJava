/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author nd
 */
public class ViewProductPage  extends AbstractPage{
    @FindBy(name ="add_cart_product")
    private WebElement butonAddToCart;
    @FindBy(name="options[Size]")
    private List<WebElement> sizeDropdown;
    
    private final String url;
    
    public ViewProductPage(WebDriver driver, String url){
        super(driver);  
        this.url = url;
        driver.get(url);
    }
    
    public boolean selectSizeIfPresent(int index){
        if(sizeDropdown.size()>0){
            Select s = new Select(sizeDropdown.get(0));
            s.selectByIndex(index);
            return true;
        }
        return false;
    }
    public void addToCart(){
        selectSizeIfPresent(1);
        butonAddToCart.click();
    }
    
    @Override
    public String getUrl() {
        return url;
    }
    
}
