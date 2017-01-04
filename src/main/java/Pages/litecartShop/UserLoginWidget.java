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
public class UserLoginWidget extends AbstractPageComponent{
    @FindBy(name = "email")
    private WebElement email; 
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement buttonLogin;
    
    public UserLoginWidget(WebDriver driver) {
        super(driver);
    }
     public void login(String email, String password){
        this.email.sendKeys(email);
	this.password.sendKeys(password);
	buttonLogin.click(); 
     }

}
