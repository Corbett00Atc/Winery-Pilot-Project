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


public class ImporterBean
{
	private String importUser;
	private String password;
	private String name;
	private String location;
	
	private ResultSet rs = null;
	private Connection con = null;
	private Statement stmt = null;
	private String userID = "student1";
	private String userPass = "pass";

	public ImporterBean() {}

	public void setImportUser(String s)
	{
		importUser = s;
	}

	public String getImportUser()
	{
		return importUser;
	}

	public void setPassword(String s)
	{
		password = s;
	}

	public String getPassword()
	{
		return password;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getName()
	{
		return name;
	}

	public void setLocation(String s)
	{
		location = s;
	}

	public String getLocation()
	{
		return location;
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
			stmt.executeUpdate("INSERT INTO IMPORTER VALUES ('" + importUser + "', '" + password + "', '" + name + "', '" + location + "')");
    	}
    	catch(SQLException e){}

    	try
    	{
	        stmt.close();
    	    con.close();
      	}
      	catch(SQLException e) {}
  	}
}