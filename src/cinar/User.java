/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import cinar.Interface.index;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;

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
    
    
    public void setId(int value)
    {
        this.id = value;
    }
    
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
    
    public int count()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        int count = 0;
      
        try 
        {
            String query = "SELECT COUNT(*) as cnt FROM user";
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
    
    public int create()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        String pass = service.md5(this.password);
        
        int control = 0;
              
        try 
        {
            if (this.check(this.username, this.email) == 0) 
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
            else if(this.check(this.username, this.email) == 1)
            {
                service.alert("warnin", "Bu kullanıcı adı daha önce alınmış");
                control = 1;
            }
            else
            {
                service.alert("warnin", "Bu mail adresi ile daha önce üye olunmuş."); 
                control = 2;
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
        
        return control;
    }
    
    public void login(JFrame value)
    {
        Database db = new Database();
        db.initalize();
        
        Session session = new Session();
        Services service = new Services();
      
        try 
        {
            String query = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,this.username);            
            preparedStmt.setString(2,service.md5(this.password));

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                session.set("login", "true");
                session.set("id", String.valueOf(rs.getInt("id")));
                session.set("name", (rs.getString("first_name") + " "+rs.getString("last_name")));
                session.set("firstName", rs.getString("first_name"));
                session.set("lastName", rs.getString("last_name"));
                session.set("username", rs.getString("username"));
                session.set("email", rs.getString("email"));
                session.set("role", rs.getString("roles"));
            }
            
            if (!session.get("id").isEmpty()) {
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
    
    public void update()
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        try 
        {
            String query = "UPDATE user SET first_name=?,last_name=?,email=? WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1, this.firstName);
            preparedStmt.setString(2, this.lastName);
            preparedStmt.setString(3, this.email);
            preparedStmt.setInt (4, this.id);
            preparedStmt.execute();
            
            service.alert("Bilgiler güncellendi."); 
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
            String query = "DELETE FROM user WHERE id=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setInt (1, this.id);
            preparedStmt.execute();
            
            service.alert("Kullanıcı silindi.");
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        
        db.close();
    }
    
    public int check(String username, String email)
    {
        Database db = new Database();
        db.initalize();
        
        Services service = new Services();
        
        int control = 0;
      
        try 
        {
            String query = "SELECT * FROM user WHERE username=?";
            PreparedStatement preparedStmt = db.connection.prepareStatement(query);
            preparedStmt.setString(1,this.username);

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                control = 1;
            }
            
            String query2 = "SELECT * FROM user WHERE email=?";
            PreparedStatement preparedStmt2 = db.connection.prepareStatement(query2);
            preparedStmt2.setString(1,this.email);

            ResultSet rs2 = preparedStmt2.executeQuery();
            while (rs2.next()) {
                control = 2;
            }
        }
        catch(Exception e)
        {
            service.alert("error", e.getMessage()); 
        }
        db.close();
        
        return control;
    }
            
}
