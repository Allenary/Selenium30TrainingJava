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
        List<String> urls = new ArrayList();
        popularProducts.forEach(p->urls.add(p.getAttribute("href")));
        return urls;
    }
    
    @Override
    public String getUrl() {
        return "http://litecart.resscode.org.ua/en/";
    }
    
}
