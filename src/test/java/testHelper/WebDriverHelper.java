/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHelper;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author nd
 */
public class WebDriverHelper {
     public static WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;
     }
}
