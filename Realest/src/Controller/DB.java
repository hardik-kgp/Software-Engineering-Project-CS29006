/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author hardik
 */


// Class to access the database. Returns a connection to the database "test.db"

public class DB {
	public static Connection getConnection(){
                Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estate", "hardik", "agghardik");
		 } catch ( ClassNotFoundException | SQLException e ) {
			System.err.println(e.getClass().getName()+ "main yha fail ho gya" + ": " + e.getMessage() );
		 }
		 return con;
	}

}