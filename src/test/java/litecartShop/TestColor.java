/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litecartShop;

import org.junit.Test;

/**
 *
 * @author nd
 */
public class TestColor {
    
    @Test
	public void test() {
		org.openqa.selenium.support.Color colorSel =  org.openqa.selenium.support.Color.fromString("rgba(119, 119, 119, 1)");
		java.awt.Color colorAwt= colorSel.getColor();
		System.out.println(colorAwt.getGreen());
	}
}
