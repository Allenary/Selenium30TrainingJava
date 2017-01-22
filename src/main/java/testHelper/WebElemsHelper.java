package testHelper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class WebElemsHelper {
    public static List<String> getElemsTexts(List<WebElement> elems){
        List<String> elemsTexts = new ArrayList<>();
        elems.forEach((el) -> {
            elemsTexts.add(el.getText());
        });
        return elemsTexts;
    }
	 
    public static List<String> getListOfIds(List<WebElement> elems){
        List<String> elemsIds = new ArrayList<>();
        elems.forEach((el) -> {
            elemsIds.add(el.getAttribute("id"));
        });
        return elemsIds;
    }
    public static List<String> getListOfUrls(List<WebElement> elems){
        List<String> urls = new ArrayList();
        elems.forEach(p->urls.add(p.getAttribute("href")));
        return urls;
    }
	 
	 
}
