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
public class Book {
    
    private int id;
    private int category;
    private int publisher;
    private int author;
    private String title;
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
        
    public int getAuthor()
    {
        return this.author;
    }
    
    public void setAuthor(int value)
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
    
    public Object[][] serialize()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        Object[][] data = new String[20][6];
        
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
    
    public void create()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        try 
        {
            String query = "INSERT INTO book(category_id,author_id,publisher_id,title,description,year,price,number_of_pages,dought_type,number_of_prints) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt(1, this.category);
            preparedStmt.setInt(2, this.author);
            preparedStmt.setInt(3, this.publisher);
            preparedStmt.setString (4, this.title);
            preparedStmt.setString (5, this.description);
            preparedStmt.setInt (6, this.year);
            preparedStmt.setDouble (7, this.price);
            preparedStmt.setInt (8, this.numberOfPages);
            preparedStmt.setString (9, this.dought);
            preparedStmt.setInt (10, this.numberOfPrints);
            preparedStmt.execute();
                            
            service.alert("Kitap kaydedilmiştir."); 
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
            String query = "UPDATE book SET category_id=?, author_id=?, publisher_id=?, title=?, description=?, year=?, price=?, number_of_pages=?, dought_type=?, number_of_prints=? WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt(1, this.category);
            preparedStmt.setInt(2, this.author);
            preparedStmt.setInt(3, this.publisher);
            preparedStmt.setString (4, this.title);
            preparedStmt.setString (5, this.description);
            preparedStmt.setInt (6, this.year);
            preparedStmt.setDouble (7, this.price);
            preparedStmt.setInt (8, this.numberOfPages);
            preparedStmt.setString (9, this.dought);
            preparedStmt.setInt (10, this.numberOfPrints);
            preparedStmt.setInt (11, this.id);
            preparedStmt.execute();
            
            service.alert("Kitap güncellenmiştir."); 
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
            String query = "DELETE FROM book WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.id);
            preparedStmt.execute();
            
            service.alert("Kitap silinmiştir."); 
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
            String query = "SELECT * FROM book";
            Statement st = db.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                box.addItem(rs.getString("title"));
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
       
        db.close();  
    }
    
    
    public String[] getSelectedItem(JComboBox box)
    {
        Database db = new Database();
        db.initalize();
        
        Category cat = new Category();
        Author aut = new Author();
        Publisher pub = new Publisher();
        Services service = new Services();
        
        String[] data = new String[11];
        
        try 
        {
            String query = "SELECT * FROM book WHERE title=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,box.getSelectedItem().toString());
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next())
            {
                data[0] = String.valueOf(rs.getInt("id"));
                data[1] = cat.find(rs.getInt("category_id"));
                data[2] = aut.find(rs.getInt("author_id"));
                data[3] = pub.find(rs.getInt("publisher_id"));
                data[4] = rs.getString("title");
                data[5] = rs.getString("description");
                data[6] = String.valueOf(rs.getInt("year"));
                data[7] = String.valueOf(rs.getInt("price"));
                data[8] = String.valueOf(rs.getInt("number_of_pages"));
                data[9] = rs.getString("dought_type");
                data[10] = String.valueOf(rs.getInt("number_of_prints"));
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
