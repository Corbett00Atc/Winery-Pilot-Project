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
    displays database information for wines
*/


public class WinesTag extends TagSupport 
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
          rs = stmt.executeQuery("SELECT * FROM WINES");
        }
        catch (SQLException s) 
        {
			return SKIP_BODY;
        }

        // print table for winery
        try
        {
            pw.println("<h2>Wine List</h2>");
	        pw.println("<table style='width:100%' border='1' cellpadding='5' cellspacing='1' bordercolor='black'>");
	          	pw.println("<tr>");
	            pw.println("<th>Name:</th>");
	            pw.println("<th>Color:</th>");
	            pw.println("<th>Year:</th>");
                pw.println("<th>Origin:</th>");
                pw.println("<th>Taste Notes:</th>");
                pw.println("<th>Owned by Winery:</th>");
	        pw.println("</tr>");
    	}
    	catch (Exception e) {}

        try
        {
          	while (rs.next())
         	{
		        pw.println("<tr>");
		      	    pw.println("<td>" + rs.getString("NAME").trim() + " </td>");
		            pw.println("<td>" + rs.getString("COLOR").trim() + " </td>");
		            pw.println("<td>" + rs.getString("YEAR").trim() + " </td>");
                    pw.println("<td>" + rs.getString("ORIGIN").trim() + " </td>");
                    pw.println("<td>" + rs.getString("TASTENOTES").trim() + " </td>");
                    pw.println("<td>" + rs.getString("WINERYUSER").trim() + " </td>");
		        pw.println("</tr>");
          	}

       		pw.println("</table>");
        }
        catch(Exception e) {}

        // close connections
        try
        {
          stmt.close();
          con.close();
        }
        catch (SQLException s) {}

		return SKIP_BODY;
	}
}