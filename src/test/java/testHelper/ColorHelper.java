/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHelper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.Colors;

/**
 *
 * @author nd
 */
public class ColorHelper {
    
    public static boolean isGrey(String name){
        List<String> greys = (new ArrayList<>());
        greys.add(Colors.GRAY.name());
        greys.add(Colors.GREY.name());
        greys.add(Colors.DIMGRAY.name());
        greys.add(Colors.DIMGREY.name());
        return greys.contains(name);
    }
    
    public static String getColorName(String hex){
        float dist = Float.MAX_VALUE;
        String nearestColor = "";
        for(Colors c: Colors.values()){
            float tdist = computeDistance(c.getColorValue().asHex(),hex);
            if(tdist < dist){
                dist = tdist;
                nearestColor = c.name();   
            }
        }
        return nearestColor;
    }
    
    private static float computeDistance(String hexColor1, String hexColor2){
        float[] colors1 = getComponentsFromHex(hexColor1);
        float[] colors2 = getComponentsFromHex(hexColor2);
        float diff=0;
        for(int i=0;i<colors1.length;i++){
            diff+=Math.abs(colors1[i]-colors2[i]);
        }
        return diff;
    }
    private static float[] getComponentsFromHex(String hex){
        Color color1 = Color.decode(hex);
        float[] components = new float[4];
        return color1.getRGBComponents(components);
    }
}
