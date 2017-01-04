/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartAdmin;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nd
 */
public class AddNewProductPage extends AbstractPage{
    @FindBy(css=".tabs li:nth-child(2)")
    private WebElement informationTab;
    @FindBy(css=".tabs li:nth-child(4)")
    private WebElement pricesTab;
    @FindBy(name="save")
    private WebElement buttonSave;
    
    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }
    public void saveData(){
        buttonSave.click();
    }
    public void navigateToInformationTab(){
        informationTab.click();
    }
    public void navigateToPricesTab(){
        pricesTab.click();
    }
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/admin/?category_id=0&app=catalog&doc=edit_product";
    }
    
}
