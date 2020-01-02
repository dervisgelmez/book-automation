/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author dervis
 */
public class Publisher {
    private int id;
    private String name;
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int value)
    {
        this.id = value;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String value)
    {
        this.name = value;
    }
    public void create()
    {    
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
      
        try 
        {
            String query = "INSERT INTO publisher(name) VALUES (?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString (1, this.name);  
            preparedStmt.execute();
                            
            service.alert("Yayın evi eklenmiştir."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
        
    }
   
    public void update()
    {    
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
      
        try 
        {
            String query = "UPDATE publisher SET name=? WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString (1, this.name);            
            preparedStmt.setInt (2, this.id);
            preparedStmt.execute();
            
            service.alert("Yayın evi güncellenmiştir."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
    }
    
    public void delete()
    {
        
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
      
        try 
        {
            String query = "DELETE FROM publisher WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.id);
            preparedStmt.execute();
            
            service.alert("Yayın Evi silinmiştir."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
    }
    
    public void toList(JComboBox box)
    {
        box.removeAllItems();
        
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        try 
        { 
            String query = "SELECT * FROM publisher";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                box.addItem(rs.getString("name"));
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
       
        db.close();  
    }
    
    public int getSelectedId(JComboBox box)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        int id = 1;
        
        try 
        {
            String query = "SELECT * FROM publisher WHERE name=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,box.getSelectedItem().toString());

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
        
        return id;
    }
    
    public String find(int id)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String name = "";
        
        try 
        {
            String query = "SELECT * FROM publisher WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt(1,id);
            ResultSet rs = preparedStmt.executeQuery();
            
            while (rs.next()) 
            {
                name = rs.getString("name");
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
        
        return name;
    }
    
    public int find(String name)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        int id = 1;
        
        try 
        {
            String query = "SELECT * FROM publisher WHERE name=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,name);
            ResultSet rs = preparedStmt.executeQuery();
            
            while (rs.next()) 
            {
                id = rs.getInt("id");
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
        
        return id;
    }
}
