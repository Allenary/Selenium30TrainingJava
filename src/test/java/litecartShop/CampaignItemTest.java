package litecartShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import testHelper.ColorHelper;
import static testHelper.ColorHelper.getColorName;

import testHelper.TestAncestor;

public class CampaignItemTest extends TestAncestor{

	@Test
	public void test() {
		driver.get("http://litecart.resscode.org.ua/en/");
		WebElement product = driver.findElement(By.cssSelector("#box-campaigns li:first-child"));
		
		WebElement oldPriceElement_mainPage = product.findElement(By.className("regular-price"));
		verifyOldPriceStyles(oldPriceElement_mainPage);
		
		WebElement newPriceElement_mainPage = product.findElement(By.className("campaign-price"));
		verifyNewPriceStyles(newPriceElement_mainPage);
		
		isNewPriceBigger(oldPriceElement_mainPage, newPriceElement_mainPage);
		
		String productName = product.findElement(By.className("name")).getText();
		String productUrl = product.findElement(By.tagName("a")).getAttribute("href");
		String oldPrice_mainPage = oldPriceElement_mainPage.getText();
		String newPrice_mainPage = newPriceElement_mainPage.getText();
		
		product.click();
		assertEquals(productUrl,driver.getCurrentUrl());
		assertEquals(productName, driver.findElement(By.tagName("h1")).getText());
		
		WebElement oldPriceElement_productPage = driver.findElement(By.className("regular-price"));
		verifyOldPriceStyles(oldPriceElement_productPage);
		
		WebElement newPriceElement_productPage = driver.findElement(By.className("campaign-price"));
		verifyNewPriceStyles(newPriceElement_productPage);
		
		isNewPriceBigger(oldPriceElement_productPage, newPriceElement_productPage);
		
		assertEquals(oldPrice_mainPage, oldPriceElement_productPage.getText());
		assertEquals(newPrice_mainPage, newPriceElement_productPage.getText());
	}
	
	private void verifyOldPriceStyles(WebElement price){
                Color color = Color.fromString(price.getCssValue("color"));
                assertTrue(ColorHelper.isGrey(getColorName(color.asHex())));
                
                assertEquals("s", price.getTagName());
	}
	private void verifyNewPriceStyles(WebElement price){
                Color color = Color.fromString(price.getCssValue("color"));
                assertEquals("RED", getColorName(color.asHex()));
                
		assertEquals("strong", price.getTagName());
	}
	private void isNewPriceBigger(WebElement oldPrice, WebElement newPrice){
		assertTrue(oldPrice.getSize().height < newPrice.getSize().height);
	}

}
