package litecartShop;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Ignore;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testHelper.TestAncestor;

public class MainPageTest extends TestAncestor {
	private String url = "http://litecart.resscode.org.ua/en/";

	
	@Ignore
        @Test
	public void eachProduct_shouldHave1Sticker() {
		driver.get(url);
		List<WebElement> products = driver.findElements(By.className("product"));
		for(WebElement product: products){
			List<WebElement> stickers = product.findElements(By.className("sticker"));
			assertEquals(1, stickers.size());
		}
	}
	
	

}
