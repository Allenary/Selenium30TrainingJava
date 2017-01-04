/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author nd
 */
public class AbstractPageComponent {
    protected WebDriver driver;
    
    public AbstractPageComponent(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
}
