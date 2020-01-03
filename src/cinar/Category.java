/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author dervis
 */
public class Category {
    
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
            String query = "INSERT INTO category(name) VALUES (?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString (1, this.name);  
            preparedStmt.execute();
                            
            service.alert("Kategori eklenmiştir."); 
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
            String query = "UPDATE category SET name=? WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString (1, this.name);            
            preparedStmt.setInt (2, this.id);
            preparedStmt.execute();
            
            service.alert("Kategori güncellenmiştir."); 
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
            String query = "DELETE FROM category WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.id);
            preparedStmt.execute();
            
            service.alert("Kategori silinmiştir."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
    }
    
    public int count()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        int count = 0;
      
        try 
        {
            String query = "SELECT COUNT(*) as cnt FROM category";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next())
            {
                count = rs.getInt("cnt");
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
        
        return count;
    }
    
    public String[][] serialize()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String[][] data = new String[20][2];
        
        try 
        { 
            String query = "SELECT c.name,COUNT(b.id) as count FROM category c LEFT JOIN book b ON b.category_id = c.id GROUP BY c.name";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i=0;
            while (rs.next())
            {
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("count");
                
                i++;
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
       
        db.close();  
        return data;
    }
    
    public void toList(JComboBox box)
    {
        String[] values = new String[this.count()]; 
        
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        try 
        { 
            String query = "SELECT * FROM category";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i=0;
            while (rs.next())
            {
                values[i] = rs.getString("name");
                i++;
            }
            
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close(); 
        
        box.setModel(new DefaultComboBoxModel<String>(values));
    }
    
    public int getSelectedId(JComboBox box)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        int id = 1;
        
        try 
        {
            String query = "SELECT * FROM category WHERE name=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,box.getSelectedItem().toString());

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
    
    public String find(int id)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String name = "";
        
        try 
        {
            String query = "SELECT * FROM category WHERE id=?";
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
            String query = "SELECT * FROM category WHERE name=?";
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
