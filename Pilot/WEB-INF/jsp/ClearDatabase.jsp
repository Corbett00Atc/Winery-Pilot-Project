<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@ taglib prefix = "cd" uri = "/WEB-INF/custom.tld"%>

<!-- deletes all database information -->

<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#ff9980">
  		<center>
        <h1>Clearing Database</h1>
        <img src="${pageContext.servletContext.contextPath}/images/delete.jpg" alt="Image of winery." width='10%' height='10%' border="8">
      </center>

      <!-- tag to work with database -->
      <!-- Creates tables -->
      <cd:dropDatabase/>

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
