/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hardik
 * 
 * 
 */

public class Admin extends User{
    
    String Tenure;

    public String getTenure() {
        return Tenure;
    }
    public int validate(String username, String password) {   // Validate Login
        int newid  = 0;
        //JOptionPane.showMessageDialog(null, username, password, 1);
               try{
                   try (Connection con = DB.getConnection()) {
                       PreparedStatement ps=con.prepareStatement("select * from admin where username=? and password = ?");
                       ps.setString(1,username);
                       ps.setString(2,password);
                       ResultSet rs=ps.executeQuery();
                       if(rs.next()!=false){
                           return 1;
                       }
                   }
               }catch(SQLException e){System.out.println(e);}
               return newid;
    }
    
    
    
}
