/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dervis
 */
public class Basket 
{
    private static Map<String, String> map = new HashMap<String, String>();
    
    private static double totalPrice = 0.0;
    
    public void set(String key, String value)
    {
        Basket.map.put(key, value);
    }
    public String get(String key)
    {
        return Basket.map.get(key);
    }
    
    public String[][] getItems()
    {
        Book book = new Book();
        String[][] data = new String[Basket.map.size()+3][3];
        
        int i = 0;
        double total = 0;
        
        for (String key : Basket.map.keySet()) {
            String[] inf = book.find(Integer.valueOf(key));
            data[i][0] = inf[4];
            data[i][1] = "1 adet";
            data[i][2] = inf[7] + " TL";
            
            total = total + Double.valueOf(inf[7]);
            i++;
        }
        
        Basket.totalPrice = total+6.99;
        
        data[Basket.map.size()][0] = "";
        data[Basket.map.size()][1] = "";
        data[Basket.map.size()][2] = "";
        
        data[Basket.map.size()][0] = "Kargo Ücreti";
        data[Basket.map.size()][1] = "";
        data[Basket.map.size()][2] = "6.99 TL";
        
        data[Basket.map.size()+1][0] = "Toplam";
        data[Basket.map.size()+1][1] = "";
        data[Basket.map.size()+1][2] = String.valueOf(total+6.99) + " TL";
        
        return data;
    }
    
    public String total()
    {
        return String.valueOf(Basket.totalPrice);
    }
    
    public void clear()
    {
        Basket.map.clear();
    }
}
