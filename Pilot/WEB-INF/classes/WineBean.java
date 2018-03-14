/*
Andrew Corbett
Bean for adding data into wines table
*/

package andrew.beans;


import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.net.URL;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import oracle.jdbc.OracleResultSetMetaData;
import java.util.*;


public class WineBean
{
	private String name;
	private String color;
	private String year;
	private String origin;
	private String tasteNotes;
	private String wineryUser;
	
	private ResultSet rs = null;
	private Connection con = null;
	private Statement stmt = null;
	private String userID = "student1";
	private String userPass = "pass";

	public WineBean() {}

	public void setName(String s)
	{
		name = s;
	}
	public String getName()
	{
		return name;
	}

	public void setColor(String s)
	{
		color = s;
	}
	public String getColor()
	{
		return color;
	}

	public void setYear(String s)
	{
		year = s;
	}
	public String getYear()
	{
		return year;
	}

	public void setOrigin(String s)
	{
		origin = s;
	}
	public String getOrigin()
	{
		return origin;
	}

	public void setTasteNotes(String s)
	{
		tasteNotes = s;
	}
	public String getTasteNotes()
	{
		return tasteNotes;
	}

	public void setWineryUser(String s)
	{
		wineryUser = s;
	}
	public String getWineryUser()
	{
		return wineryUser;
	}

	public void updateDatabase()
	{
		try
		{
			DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", userID, userPass);
			stmt = con.createStatement();
    	}
    	catch(Exception e){}

    	try
    	{
			stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NEXTVAL, '" 
				+ name + "', '" 
				+ color + "', '" 
				+ year + "', '" 
				+ origin + "', '" 
				+ tasteNotes + "', '" 
				+ wineryUser + "')");
    	}
    	catch(SQLException e) {}

    	try
    	{
	        stmt.close();
    	    con.close();
      	}
      	catch(SQLException e) {}
  	}
}