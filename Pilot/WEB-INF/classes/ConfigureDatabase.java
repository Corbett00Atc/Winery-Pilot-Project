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
    Used to fill database with tables and data
    Called from "Configure the Database" link on home page 
*/


public class ConfigureDatabase extends TagSupport 
{
	@Override
	public int doStartTag() throws JspException
	{
        JspWriter pw = pageContext.getOut();
        Connection con = null;
        Statement stmt = null;

        try
        {
            pw.println("---------------------------------------------");
            pw.println("<br />");
            pw.println("---------------------------------------------");
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

        // creates tables
        try
        {
            // holds data about various wines
            stmt.executeUpdate("CREATE TABLE WINES ("
                + "WINEID NUMBER(5), "
                + "NAME VARCHAR(25), "
                + "COLOR VARCHAR (10), "
                + "YEAR VARCHAR(4), "
                + "ORIGIN VARCHAR(35), "
                + "TASTENOTES VARCHAR(50), "
                + "WINERYUSER VARCHAR(35)"
                + ")");
            pw.println("Creating table Wines...");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            stmt.executeUpdate("CREATE SEQUENCE WINES_seq "
                + "START WITH     1 "
                + "INCREMENT BY   1 "
                + "NOCACHE "
                + "NOCYCLE ");
            pw.println("Table Created.");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            // holds data about various wineries
            stmt.executeUpdate("CREATE TABLE WINERY ("
                + "WINERYUSER VARCHAR(35) PRIMARY KEY, "
                + "PASSWORD VARCHAR(25), "
                + "NAME VARCHAR(30), "
                + "LOCATION VARCHAR(30) "
                + ")");
            pw.println("Creating table Winery...");
            pw.println("<br />");
            pw.println("Table Created");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            // holds data about various wine importers
            stmt.executeUpdate("CREATE TABLE IMPORTER ("
                + "IMPORTERUSER VARCHAR(25) PRIMARY KEY, "
                + "PASSWORD VARCHAR(25), "
                + "NAME VARCHAR(30), "
                + "LOCATION VARCHAR(30)"
                + ")");
            pw.println("Creating table Importer...");
            pw.println("<br />");
            pw.println("Table Created.");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch(Exception e) {}

        try
        {
            pw.println("All tables Created.");
            pw.println("<br />");
            pw.println("---------------------------------------------");
            pw.println("<br />");
            pw.println("---------------------------------------------");
            pw.println("<br />");
        }
        catch (Exception e) {}

        // inserts data into tables
        try
        {
            // holds data about various wines
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Red Wine', 'Red', '1998', 'France', 'Earthy, Floral', 'Red Winery')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Matinee', 'White', '1877', 'Belgium', 'Robust, Ginger', 'Mason Wines')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Parque', 'Red', '1965', 'Spain', 'Ripe, Sweet', 'Vintage Wines')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Vincent', 'White', '1987', 'America', 'Fresh, Dark', 'Japan Wines')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Marque', 'White', '1999', 'England', 'Vibrant, Pure', 'Mason Winery')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'La Chatea', 'Red', '2001', 'France', 'Cedar, Cassis', 'Camelot Wines')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'De Marisa', 'Red', '2010', 'France', 'Licorice, Sugar', 'Road Winery')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Viqual', 'Red', '1756', 'Japan', 'Robust, Ripe', 'Vicquer Winery')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Coarish', 'White', '1945', 'China', 'Creme, Honey', 'Red Winery')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'La Vietium', 'White', '1999', 'Russia', 'Fruity, Floral', 'Velvot Creation')");
            stmt.executeUpdate("INSERT INTO WINES VALUES (WINES_seq.NextVAL, 'Se Delier', 'White', '2003', 'Vietnam', 'Bold, Exotic', 'Vicquer Winery')");
            pw.println("Inserting data into table Wines...");
            pw.println("<br />");
            pw.println("Table Updated.");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {    
            // holds data about various wineries
            stmt.executeUpdate("INSERT INTO WINERY VALUES('RedWinery', 'fe4thsvf', 'Red Winery', 'France')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('MWines', '7asdgb3k', 'Mason Wines', 'England')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('VWines', '4sdfn3', 'Vintage Wines', 'America')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('Camelot', 'asdf4g', 'Camelot Winery', 'France')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('RoadWinery', 'asdf3f2af', 'Road Winery', 'France')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('Vicquer', 'afsgh2', 'Vicquer Winery', 'Japan')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('Velvot', '93ndfg', 'Velvot Creation', 'America')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('FloatWines', '435sfg', 'Float Winery', 'America')");
            stmt.executeUpdate("INSERT INTO WINERY VALUES('Japan', '890sfad', 'Japan Wines', 'Japan')");
            pw.println("Inserting data table Winery...");
            pw.println("<br />");
            pw.println("Table Updated");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch (Exception e) {}

        try
        {
            // holds data about various wine importers
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('WineCo', '89asdf3', 'Wine Co', 'Germany')");
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('Luxerious', 'fag2haef', 'Luxerious', 'France')");
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('MarknSons', 'asg3hahf', 'Mark and Sons', 'America')");
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('VTS', 'ahafh3', 'Viva Tele Sarat', 'Japan')");
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('Marque', '890sfasdfad', 'Marque Wines', 'England')");
            stmt.executeUpdate("INSERT INTO IMPORTER VALUES('Vivacity', 'asdf3gha', 'Vivacity Imports', 'Japan')");
            pw.println("Inserting data table Importer...");
            pw.println("<br />");
            pw.println("Table Updated.");
            pw.println("<br />");
            pw.println("<br />");
            pw.println("<br />");
        }
        catch(Exception e) {}

        try
        {
            pw.println("All tables updated.");
            pw.println("<br />");
            pw.println("---------------------------------------------");
            pw.println("<br />");
            pw.println("---------------------------------------------");
            stmt.close();
            con.close();
        }
        catch (Exception s) {}

		return SKIP_BODY;
	}
}