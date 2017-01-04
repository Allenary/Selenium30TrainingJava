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
public class AddNewProductInformationTab extends AbstractPageComponent{
    @FindBy(name="manufacturer_id")
    private WebElement manufacturer;
    @FindBy(name="keywords")
    private WebElement keyword;
    @FindBy(name="short_description[en]")
    private WebElement shortDescription;
    @FindBy(className = "trumbowyg-editor")
    private WebElement fullDescription;
    @FindBy(name="head_title[en]")
    private WebElement title;
    @FindBy(name="meta_description[en]")
    private WebElement meta;
    
    public AddNewProductInformationTab(WebDriver driver) {
        super(driver);
    }
    
    public void populateData(){
        new Select(manufacturer).selectByIndex(1);
        keyword.sendKeys("test keyword");
        shortDescription.sendKeys("test short desription");
        fullDescription.sendKeys("test full description");
        title.sendKeys("test title");
        meta.sendKeys("test meta");
    }
    
}
