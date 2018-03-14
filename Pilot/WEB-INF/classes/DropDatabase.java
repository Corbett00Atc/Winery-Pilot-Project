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
    Used to delete database with tables and data
    Called from "Clear the Database" link on home page 
*/


public class DropDatabase extends TagSupport 
{
	@Override
	public int doStartTag() throws JspException
	{
        JspWriter pw = pageContext.getOut();
        Connection con = null;
        Statement stmt = null;

        // grab connections
        try
        {
            pw.println("Connecting to database...");
            pw.println("<br />");
            pw.println("<br />");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            stmt = con.createStatement();
        }
        catch(Exception e)
        {

            try
            {
                pw.println("Error in connection to database");
            }
            catch(Exception ex) {}
        }

        try
        {
            // holds data about various wines
            stmt.executeUpdate("DROP TABLE WINES");
            stmt.executeUpdate("DROP SEQUENCE WINES_seq");
            pw.println("Deleting table Wines...");
            pw.println("<br />");
            pw.println("Table removed.");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            // holds data about various wineries
            stmt.executeUpdate("DROP TABLE WINERY");
            pw.println("Deleting table Winery...");
            pw.println("<br />");
            pw.println("Table removed");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            // holds data about various wine importers
            stmt.executeUpdate("DROP TABLE IMPORTER");
            pw.println("Deleting table Importer...");
            pw.println("<br />");


            pw.println("Table removed.");
            pw.println("<br />");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch(Exception e) {}

        try
        {
            pw.println("All tables removed.");
            pw.println("<br />");
            pw.println("<br />");
            pw.println("<br />");

        }
        catch (Exception e) {}

        try
        {
            stmt.close();
            con.close();
        }
        catch (SQLException s) {}

		return SKIP_BODY;
	}
}