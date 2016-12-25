package testHelper;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static testHelper.WebDriverHelper.getDriver;

public abstract class TestAncestor {
	protected WebDriver driver;
		
	@Before
	public void start(){
		driver = getDriver();
	}
	@After
	public void finish(){
		driver.quit();
		driver = null;
	}
}
