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


public class LoginBean
{
	private ResultSet rs = null;
	private Connection con = null;
	private Statement stmt = null;
	private String userID = "student1";
	private String userPass = "pass";
	private String user;
	private String pass;
	private boolean status = false;

	public void setUser(String u)
	{
		user = u;
	}
	public String getUser()
	{
		return user;
	}

	public void setPass(String p)
	{
		pass = p;
	}
	public String getPass()
	{
		return pass;
	}

	public LoginBean() {}

  	public boolean login()
  	{
  		try
        {
          DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", userID, userPass);
          stmt = con.createStatement();
        }
        catch(Exception e){}

        // if user is found in database, it'll return true
        try
        {
          rs = stmt.executeQuery("SELECT * FROM WINERY WHERE WINERYUSER = '" + user + "' AND PASSWORD = '" + pass + "'");

          status = rs.next();

          if (status == true)
          {
          	return status;
          }
        }
        catch(Exception e){}

        try
        {
          rs = stmt.executeQuery("SELECT * FROM IMPORTER WHERE IMPORTERUSER = '" + user + "' AND PASSWORD = '" + pass + "'");


          status = rs.next();

        }
        catch(Exception e){}

        return status;
  	}
}

