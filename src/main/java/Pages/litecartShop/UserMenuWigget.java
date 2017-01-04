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
public class UserMenuWigget extends AbstractPageComponent{
    @FindBy(css = "#box-account li:last-child a")
    private WebElement logout; 
    
    public void logout(){
        logout.click();
    }
    public UserMenuWigget(WebDriver driver) {
        super(driver);
    }

}
