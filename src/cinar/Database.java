/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dervis
 */
public class Database {
    
    private String host     = "localhost";
    private String username = "root";
    private String password = "root";
    
    private String database = "cinar";
    private String port     = "3306";
    
    private Services service = new Services();
    
    public Connection connection = null;
    
    
    
    public void initalize()
    {
        String config = "jdbc:mysql://"+this.host+":"+this.port+"/"+this.database;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Deneme", "1", JOptionPane.ERROR_MESSAGE);
        }
        
        try
        {
            this.connection = (Connection) DriverManager.getConnection(config,username,password);
        }
        catch (Exception e) {
            service.alert("error", e.getMessage());
        }
        
        if (this.connection == null) {
            service.alert("error", "Veritabanına bağlanılamadı, bir sorun oluştu.");
        }
    }
    
    public void close()
    {
        try
        {
            this.connection.close();
        }
        catch (Exception e)
        {
            
        }
    }
}
