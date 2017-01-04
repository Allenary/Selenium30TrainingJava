/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nd
 */
public class UserRegistrationPage  extends AbstractPage{
    @FindBy(name = "firstname")
    private WebElement firstName; 
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "address1")
    private WebElement address1;
    @FindBy(name = "postcode")
    private WebElement postcode;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirmed_password")
    private WebElement confirmedPassword;
    
    @FindBy(name = "create_account")
    private WebElement buttonCreateAccount;
    
		
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    
    public void populateData(String email, String pass){
        firstName.sendKeys("testfirstname");
        lastName.sendKeys("testLastName");
        address1.sendKeys("testAddress1");
        postcode.sendKeys("12345");
        city.sendKeys("testCity");
        this.email.sendKeys(email);
	phone.sendKeys("123456789");
		 
	password.sendKeys(pass);
	confirmedPassword.sendKeys(pass);
    }
    
    public void createAccount(){
        buttonCreateAccount.click();
    }

    @Override
    public String getUrl() {
       return "http://litecart.resscode.org.ua/en/create_account";
    }
    
}
