/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar;

import cinar.Interface.index;
import cinar.Interface.login;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author dervis
 */
public class Cinar {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        login lgn = new login();
        lgn.setVisible(true);
    }
    
}
