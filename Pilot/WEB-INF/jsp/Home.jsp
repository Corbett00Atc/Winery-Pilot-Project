<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>

<!-- Homepage for the application -->


<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#737373">
  		
	  	<!-- Title -->
	  	<h1><center><font size="240">Wellnet</font></center></h1>
	  	<br /> 
	    <center>
	    	<img src="${pageContext.servletContext.contextPath}/images/homepage.jpg" alt="Image of winery." width="25%" height="25%" border="8">
	    </center>
	    <br />

	  	<!-- Links -->
	  	<h2>Welcome to Wellnet. Select a link to continue...</h2>
	  	<table style='width:100%'>
	  		<tr>
	  			<td><h3>Accounts</h3></td>
	  			<td><h3>Browse Database</h3></td>
	  			<td><h3>Update Database</h3></td>
  			</tr>
  			<tr>
  				<td><a href="/Pilot/WineryAccount">Create a Winery Account</a></td>
  				<td><a href="/Pilot/BrowseWines">Browse Wines</a></td>
				<td><a href="/Pilot/NewWine">Add a new wine</a></td>
			</tr>
			<tr>
				<td><a href="/Pilot/ImporterAccount">Create an Importer Account</a></td>
				<td><a href="/Pilot/ViewAccounts">Browse Accounts</a></td>
				<td><a href="/Pilot/CreateDatabase">Configure the Database</a></td>
			</tr>
			<tr>
				<td><a href="/Pilot/Login">Login to Account</a></td>
				<td></td>
				<td><a href="/Pilot/ClearDatabase">Clear the Database</a></td>
			</tr>
		</table>
  	</body>
</html>
