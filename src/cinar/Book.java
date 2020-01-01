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
public class Book {
    
    private int id;
    private int category;
    private int publisher;
    private String title;
    private String author;
    private String description;
    private int year;
    private double price;
    private int numberOfPages;
    private String dought;
    private int numberOfPrints;
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int value)
    {
        this.id = value;
    }
    
    public int getCategory()
    {
        return this.category;
    }
    
    public void setCategory(int value)
    {
        this.category = value;
    }
        
    public int getPublisher()
    {
        return this.publisher;
    }
    
    public void setPublisher(int value)
    {
        this.publisher = value;
    }
        
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String value)
    {
        this.title = value;
    }
        
    public String getAuthor()
    {
        return this.author;
    }
    
    public void setAuthor(String value)
    {
        this.author = value;
    }
        
    public String getDescription()
    {
        return this.description;
    }
    
    public void setDescription(String value)
    {
        this.description = value;
    }
        
    public int getYear()
    {
        return this.year;
    }
    
    public void setYear(int value)
    {
        this.year = value;
    }
        
    public double getPrice()
    {
        return this.price;
    }
    
    public void setPrice(double value)
    {
        this.price = value;
    }
        
    public int getNumberOfPages()
    {
        return this.numberOfPages;
    }
    
    public void setNumberOfPages(int value)
    {
        this.numberOfPages = value;
    }
        
    public String getDought()
    {
        return this.dought;
    }
    
    public void setDought(String value)
    {
        this.dought = value;
    }
        
    public int getNumberOfPrints()
    {
        return this.numberOfPrints;
    }
    
    public void setNumberOfPrints(int value)
    {
        this.numberOfPages = value;
    }      
    
    public String[][] serialize()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String[][] data = new String[20][6];
        
        try 
        { 
            String query = "SELECT b.title, a.name as author, p.name, b.year, b.price FROM book b LEFT JOIN publisher p ON b.publisher_id = p.id LEFT JOIN author a ON b.author_id=a.id";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i=0;
            while (rs.next())
            {
                data[i][0] = rs.getString("title");
                data[i][1] = rs.getString("author");
                data[i][2] = rs.getString("name");
                data[i][3] = String.valueOf(rs.getInt("year"));
                data[i][4] = String.valueOf(rs.getDouble("price"));
                data[i][5] = "Sepete Ekle";
                
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
