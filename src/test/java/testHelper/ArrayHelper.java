/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHelper;

import java.util.List;

/**
 *
 * @author nd
 */
public class ArrayHelper {
    
    public static boolean isSortedAsc(List<String> list){
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).compareTo(list.get(i-1)) < 0) return false;
        }
        return true;
    }
}
