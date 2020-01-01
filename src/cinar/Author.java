/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dervis
 */
public class Author {
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
    
    public String[][] serialize()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String[][] data = new String[20][2];
        
        try 
        { 
            String query = "SELECT a.name,COUNT(b.id) as count FROM author a LEFT JOIN book b ON b.category_id = a.id GROUP BY a.name";
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
}
