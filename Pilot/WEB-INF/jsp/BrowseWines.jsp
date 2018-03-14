<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@ taglib prefix = "cd" uri = "/WEB-INF/custom.tld"%>

<!-- browse offered wines on site.  -->

<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#ffb3cc">
      <center>
  		  <h1>Browse Wines </h1>
        <img src="${pageContext.servletContext.contextPath}/images/wineglass.jpg" alt="Image of winery." width='15%' height='15%' border='4'>
      </center>

      <!-- Displays wines -->
      <cd:wines/>
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


