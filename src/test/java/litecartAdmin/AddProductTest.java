package litecartAdmin;

import Pages.litecartAdmin.AddNewProductGeneralTab;
import Pages.litecartAdmin.AddNewProductInformationTab;
import Pages.litecartAdmin.AddNewProductPage;
import Pages.litecartAdmin.AddNewProductPricesTab;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testHelper.DateHelper;
import testHelper.TestAncestor;
import Pages.litecartAdmin.AdminLoginPage;
import Pages.litecartAdmin.CatalogPage;
import org.junit.Assert;
import testHelper.DataGenerator;

public class AddProductTest extends TestAncestor {

	@Test
	public void addNewProductTest() {

            String productName = "TestProduct"+DataGenerator.getUniqueString();
            
            new AdminLoginPage(driver).login();
            CatalogPage catalogPage = new CatalogPage(driver);
            driver.get(catalogPage.getUrl());
            int countProductsBeforeTest = catalogPage.countProducts();
            
            catalogPage.navigateToAddProductPage();            
            AddNewProductPage productPage = new AddNewProductPage(driver);
            
            //General tab
            AddNewProductGeneralTab generalTab = new AddNewProductGeneralTab(driver);
            generalTab.makeProductEnabled();
            generalTab.setCode("testcode");
            generalTab.setProductName(productName);
            generalTab.SetQuantity("5");
            
            File file = new File("src/test/resources/test.jpg");
            generalTab.updloadProductImage(file);
        
            generalTab.setDates(new Date(), DateHelper.getTodayPlusOneYear());

            //Information tab
            productPage.navigateToInformationTab();
            new AddNewProductInformationTab(driver).populateData();
        
            //Prices tab
            productPage.navigateToPricesTab();
            AddNewProductPricesTab pricesTab = new AddNewProductPricesTab(driver);
            pricesTab.addPurchasePrice("5", "USD");
            pricesTab.addUsdPrices("5", "8");

            productPage.saveData();
            
            Assert.assertEquals(countProductsBeforeTest+1, new CatalogPage(driver).countProducts());
	}

}
