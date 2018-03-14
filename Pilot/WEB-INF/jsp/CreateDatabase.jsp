<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@ taglib prefix = "cd" uri = "/WEB-INF/custom.tld"%>

<!-- Page to set up all the database tables and fill with data -->

<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#b3b3ff">

  		<center>
        <h1>Configuring Database</h1>
        <img src="${pageContext.servletContext.contextPath}/images/diagram.png" alt="Image of winery." width='10%' height='10%'>
      </center>

  		<!-- tag to work with database -->
  		<!-- Creates tables -->
  		<cd:configureDatabase/>
         

  	</body>
  	<footer>
  		<center>
	     	<br />
	     	<br />
	     	<br />
          	<img src="${pageContext.servletContext.contextPath}/images/grapes.png" alt="Image of winery." width='2%' height='2%'>
	  		<a href="/Pilot/Winery">Home</a>
	  		<img src="${pageContext.servletContext.contextPath}/images/grapes.png" alt="Image of winery." width='2%' height='2%'>
	  	</center>
  	</footer>
</html>
