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
public class OrderItem {
    
    private int id;
    private int user;
    private int book;
    private String orderNumber;
    
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
    
    public int getBook()
    {
        return this.user;
    }
    
    public void setBook(int value)
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
    
    public void create()
    {
        
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
              
        try 
        {
            String query = "INSERT INTO order_item(user_id,book_id,order_number) VALUES (?,?,?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.user);            
            preparedStmt.setInt (2, this.book);            
            preparedStmt.setString(3, this.orderNumber);  
            preparedStmt.execute();
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
    }
}
