package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.driver = driver;
	}
	
	public abstract String getUrl();

}
