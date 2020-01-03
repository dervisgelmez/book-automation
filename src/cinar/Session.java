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
public class Session 
{
    private static Map<String, String> map = new HashMap<String, String>();
    
    public Session()
    {
        Session.map.put("login", "false");
    }
    
    public void set(String key, String value)
    {
        Session.map.put(key, value);
    }
    public String get(String key)
    {
        return Session.map.get(key);
    }
    
    
}
