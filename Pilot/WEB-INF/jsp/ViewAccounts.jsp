<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@ taglib prefix = "cd" uri = "/WEB-INF/custom.tld"%>

<!-- view all accounts -->

<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#99ccff">
  		<center>
  			<h1>Browse Accounts</h1>
	    	<img src="${pageContext.servletContext.contextPath}/images/search.png" alt="Image of winery." width="15%" height="15%">
  		</center>

      <!-- Displays accounts -->
      <cd:accounts/>

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