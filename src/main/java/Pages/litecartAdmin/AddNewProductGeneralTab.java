/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartAdmin;

import Pages.AbstractPageComponent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nd
 */
public class AddNewProductGeneralTab extends AbstractPageComponent{
    @FindBy(css = "[name=status][value='1']")
    private WebElement statusEnabled;
    @FindBy(name = "new_images[]")
    private WebElement image;
    @FindBy(name="name[en]")
    private WebElement productName;
    @FindBy(name="code")
    private WebElement code;
    @FindBy(name="quantity")
    private WebElement quantity;
    @FindBy(name="date_valid_from")
    private WebElement dateFrom;
    @FindBy(name="date_valid_to")
    private WebElement dateTo;
    
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public AddNewProductGeneralTab(WebDriver driver) {
        super(driver);
    }
    
    public void makeProductEnabled(){
        statusEnabled.click();
    }
    public void setDates(Date dateFrom, Date dateTo){
        this.dateFrom.sendKeys(dateFormat.format(dateFrom));
        this.dateTo.sendKeys(dateFormat.format(dateTo));
    }
    public void setProductName(String name){
        productName.sendKeys(name);
    }
    public void setCode(String code){
        this.code.sendKeys(code);
    }
    public void SetQuantity(String quantity){
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }
    public void updloadProductImage(File file){
        image.sendKeys(file.getAbsolutePath()); 
    }

}
