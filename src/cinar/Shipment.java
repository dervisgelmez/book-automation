/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

/**
 *
 * @author dervis
 */
public class Shipment {
    
    private int id;
    private int user;
    private int orderNumber;
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
    
    public int getOrderNumber()
    {
        return this.orderNumber;
    }
    
    public void setOrderNumber(int value)
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
}
