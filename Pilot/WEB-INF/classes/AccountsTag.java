package andrew.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.net.URL;
import javax.servlet.http.*;
import javax.servlet.*;
import oracle.jdbc.OracleResultSetMetaData;

/* 
    displays database information for both winery and importer accounts
*/


public class AccountsTag extends TagSupport 
{
	@Override
	public int doStartTag() throws JspException
	{

		JspWriter pw = pageContext.getOut();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // set up database connections
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            stmt = con.createStatement();
        }
        catch(Exception e) {}

        // grab first data set from database
        try
        {
          rs = stmt.executeQuery("SELECT * FROM WINERY");
        }
        catch (SQLException s) 
        {
            return SKIP_BODY;
        }

        // print table for winery
        try
        {
            pw.println("<h2>Winery Accounts</h2>");
	        pw.println("<table style='width:100%' border='1' cellpadding='5' cellspacing='1' bordercolor='blue'>");
	          	pw.println("<tr>");
	            pw.println("<th>Winery Name:</th>");
	            pw.println("<th>Username:</th>");
	            pw.println("<th>Location:</th>");
	        pw.println("</tr>");
    	}
    	catch (Exception e) {}

        try
        {
          	while (rs.next())
         	{
		        pw.println("<tr>");
		      	    pw.println("<td>" + rs.getString("NAME").trim() + " </td>");
		            pw.println("<td>" + rs.getString("WINERYUSER").trim() + " </td>");
		            pw.println("<td>" + rs.getString("LOCATION").trim() + " </td>");
		        pw.println("</tr>");
          	}

       		pw.println("</table>");
        }
        catch(Exception e) {}


        // grab second data set from database
        try
        {
          rs = stmt.executeQuery("SELECT * FROM IMPORTER");
        }
        catch (SQLException s) {}

        // print table for importer
        try
        {
            pw.println("<h2>Importer Accounts</h2>");
            pw.println("<table style='width:100%' border='1' cellpadding='5' cellspacing='1' bordercolor='blue'>");
                pw.println("<tr>");
                pw.println("<th>Importer Name:</th>");
                pw.println("<th>Username:</th>");
                pw.println("<th>Location:</th>");
            pw.println("</tr>");
        }
        catch (Exception e) {}

        try
        {
            while (rs.next())
            {
                pw.println("<tr>");
                    pw.println("<td>" + rs.getString("NAME").trim() + " </td>");
                    pw.println("<td>" + rs.getString("IMPORTERUSER").trim() + " </td>");
                    pw.println("<td>" + rs.getString("LOCATION").trim() + " </td>");
                pw.println("</tr>");
            }

            pw.println("</table>");
        }
        catch(Exception e) {}

        try
        {
          stmt.close();
          con.close();
        }
        catch (SQLException s) {}

		return SKIP_BODY;
	}
}