/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dervis
 */
public class Command {
    
    public void setIndex(JTable table)
    {      
        Database db = new Database();
        db.initalize();
        
        Book book = new Book();
        Object[][] data = book.serialize();
        
        String[] column = {"Kitap adı","Yazar","Yayınevi","Yayın Tarihi","Fiyat",""};
        JTable jt = new JTable(data,column);
        table.setModel(jt.getModel());
    }
    
    public void setCategory(JTable table)
    {      
        Database db = new Database();
        db.initalize();
        
        Category cat = new Category();
        String[][] data = cat.serialize();
        
        String[] column = {"Kategori Adı","Kitap Adedi"};
        JTable jt = new JTable(data,column);
        table.setModel(jt.getModel());
    }
    
    public void setAuthor(JTable table)
    {      
        Database db = new Database();
        db.initalize();
        
        Author aut = new Author();
        String[][] data = aut.serialize();
        
        String[] column = {"Yazar Adı","Kitap Adedi"};
        JTable jt = new JTable(data,column);
        table.setModel(jt.getModel());
    }
    
}
