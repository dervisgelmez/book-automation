/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.sql.PreparedStatement;

/**
 *
 * @author dervis
 */
public class Shipment {
    
    private int id;
    private int user;
    private String orderNumber;
    private String address;
    private Double total;
    
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int value)
    {
        this.id = value;
    }
    
    public int getUser()
    {
        return this.user;
    }
    
    public void setUser(int value)
    {
        this.user = value;
    }
    
    public String getOrderNumber()
    {
        return this.orderNumber;
    }
    
    public void setOrderNumber(String value)
    {
        this.orderNumber = value;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String value)
    {
        this.address = value;
    }
    
    public double getTotal()
    {
        return this.total;
    }
    
    public void settotal(double value)
    {
        this.total = value;
    }
    
    public void create()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
              
        try 
        {
            String query = "INSERT INTO shipment(user_id,order_number,address,total_price) VALUES (?,?,?,?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.user);            
            preparedStmt.setString(2, this.orderNumber);            
            preparedStmt.setString (3, this.address);              
            preparedStmt.setDouble(4, this.total);  
            preparedStmt.execute();
            
            service.alert("Siparişiniz 3 iş günü içerisinde adresinize ulaşacaktır."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
    }
}
