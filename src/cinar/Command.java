/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dervis
 */
public class Command extends Services {
    
    public void setIndex(JTable table)
    {
        Book book = new Book();
        String[] column = {"Barcode","Kitap adı","Yazar","Yayınevi","Yayın Tarihi","Fiyat"};
        Object[][] data = book.serialize();
        
        //this function in extends class
        setTableModels(table, column, data);
    }
    
    public void setCategory(JTable table)
    {
        Category cat = new Category();
        String[] column = {"Kategori Adı","Kitap Adedi"};
        String[][] data = cat.serialize();
        
        //this function in extends class
        setTableModels(table, column, data);
    }
    
    public void setAuthor(JTable table)
    {
        Author aut = new Author();
        String[] column = {"Yazar Adı","Kitap Adedi"};
        String[][] data = aut.serialize();
        
        //this function in extends class
        setTableModels(table, column, data);
    }
    
    public void setBasket(JTable table)
    {
        Basket basket = new Basket();
        String[] column = {"id","Kitap Adı","Fiyat"};
        setTableModels(table, column, basket.getItems());
    }
    
}
