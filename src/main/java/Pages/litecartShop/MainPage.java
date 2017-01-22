/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages.litecartShop;

import Pages.AbstractPage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static testHelper.WebElemsHelper.getListOfUrls;

/**
 *
 * @author nd
 */
public class MainPage extends AbstractPage{
    @FindBy(css = "#box-most-popular a.link")
    List<WebElement> popularProducts;
    
    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(getUrl());
    }

    public List<String> PopularProductsUrls(){
        return getListOfUrls(popularProducts);
    }
    
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/en/";
    }
    
}
