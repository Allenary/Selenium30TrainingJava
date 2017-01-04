package Pages.litecartAdmin;

import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends AbstractPage {
	private String adminLogin = "admin";
	private String adminPass = "admin123";
	
	public AdminLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(){
		driver.get(getUrl());
		driver.findElement(By.name("username")).sendKeys(adminLogin);
		driver.findElement(By.name("password")).sendKeys(adminPass);
		driver.findElement(By.name("login")).click();
	}

	@Override
	public String getUrl() {
		return "http://litecart.resscode.org.ua/admin/login.php";
	}

}
