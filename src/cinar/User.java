/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import cinar.Interface.index;
import cinar.Interface.login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dervis
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String roles;
    
    
    public int getId()
    {
        return this.id;
    }
    
    public void setFirstName(String value)
    {
        this.firstName = value;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public void setLastName(String value)
    {
        this.lastName = value;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    public void setUsername(String value)
    {
        this.username = value;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setEmail(String value)
    {
        this.email = value;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setPassword(String value)
    {
        this.password = value;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setRoles(String value)
    {
        this.roles = value;
    }
    
    public String getRoles()
    {
        return this.roles;
    }
    
    public void show()
    {
        Database db = new Database();
        db.initalize();
        
        try 
        {
            Statement stmt = db.connection.createStatement();

            String query = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.println("ID:" + rs.getString("id"));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        
    }
    
    public void create()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String pass = service.md5(this.password);
        
      
        try 
        {
            String query = "INSERT INTO user(first_name,last_name,username,email,password,roles) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString (1, this.firstName);            
            preparedStmt.setString (2, this.lastName);            
            preparedStmt.setString (3, this.username);           
            preparedStmt.setString (4, this.email);          
            preparedStmt.setString (5, pass);   
            preparedStmt.setString (6, "user");

            preparedStmt.execute();
                            
            service.alert("Üyeliğiniz, tamamlanmıştır, giriş Yapabilirsiniz."); 
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();   
    }
    
    public void login(JFrame value)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
      
        try 
        {
            int login = 0;
            
            String query = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,this.username);            
            preparedStmt.setString(2,service.md5(this.password));

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                login = rs.getInt("id");
            }
            
            if (login != 0) {
                value.setVisible(false);
                index idx = new index();
                idx.setVisible(true);
            }
            else {
                System.out.format("Hatalı");
                service.alert("warning", "Kullanıcı adı veya parolanızı hatalı girdiniz."); 
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();  
    }
            
}
