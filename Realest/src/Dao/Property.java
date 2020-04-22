/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.DB;
import static java.lang.Integer.max;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author hardik
 */
public class Property {
    
    
    
    // private data members
    private String Name;
    private int ownerid;
    private String Location;
    private int cost;
    private int area;

    
    private boolean Type ;// 0 for Sell and 1 for Rent 
    private int id;

    public Property() {
        this.Type = false;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int owner) {
        this.ownerid = owner;
    }
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isType() {
        return Type;
    }

    public void setType(boolean Type) {
        this.Type = Type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // save a property into data base
    public int save(){
		int status=0;
		try{
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement pst1;
                        pst1 = con.prepareStatement("SELECT * FROM property");
                        ResultSet rs1 = pst1.executeQuery();
                        int count = 0;
                        while(rs1.next()){
                            count = max(rs1.getInt("id"),count);
                        }
                        id = count + 1;
                        PreparedStatement ps;
                        ps = con.prepareStatement("insert into property(id,name,location,cost,type,ownerid,area) values(?,?,?,?,?,?,?)");
                        ps.setInt(1,id);
                        ps.setString(2,Name);
                        ps.setString(3,Location);
                        ps.setInt(4,cost);
                        ps.setString(5,Type? "RENT":"SELL");
                        ps.setInt(6,ownerid);
                        ps.setInt(7,area);
                        status=ps.executeUpdate();
                    }
		}catch(SQLException e){
			System.out.println(e);
		}
		return status;
	}
     // delete a property
    public int delete() {
        int status=0;
		try{
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement ps=con.prepareStatement("delete from property where id=? and ownerid = ?");
                        ps.setInt(1,id);
                        ps.setInt(2,this.ownerid);
                        status=ps.executeUpdate();
                    }
		}catch(SQLException e){System.out.println(e);}
		return status;
         
    }
    
    
    
    

    
}
