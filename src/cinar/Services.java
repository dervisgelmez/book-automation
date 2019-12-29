/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author dervis
 */
public class Services {
    
    public String md5(String value)
    {
        String hashing = "";
        try 
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            hashing = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        }
        
        return hashing;
    }
    
    
    public void alert(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public void alert(String type, String msg)
    {
        String title;
        int icon;
        
        if (type == "error") {
            icon = JOptionPane.ERROR_MESSAGE;
            title = "Hata";
        }
        else if(type == "warning") {
            icon = JOptionPane.WARNING_MESSAGE;
            title = "Uyarı";
        }
        else {
            icon = JOptionPane.INFORMATION_MESSAGE;
            title = "Bildirim";
        }
        
        JOptionPane.showMessageDialog(null, msg, title, icon);
    }
    
    
    
}
