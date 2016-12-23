package testHelper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class WebElemsHelper {
	 public static List<String> getElemsTexts(List<WebElement> elems){
		List<String> elemsTexts = new ArrayList<String>();
		for(WebElement el: elems){
			elemsTexts.add(el.getText());
		}
		return elemsTexts;
	 }
	 
	 public static  List<String> getListOfIds(List<WebElement> elems){
			List<String> elemsIds = new ArrayList<String>();
			for(WebElement el: elems){
				elemsIds.add(el.getAttribute("id"));
//				System.out.println("subMenuItemId: "+ el.getAttribute("id"));
			}
			return elemsIds;
		}
	 
	 
}
