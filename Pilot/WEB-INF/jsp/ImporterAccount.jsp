<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>

<!-- page to create an importer account. Adds to database -->


<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#66e0ff">
  		<!-- sends data to bean to upload to database -->
	    <%
    		if (request.getMethod().equals("GET"))
	   		{
	    %>

  		<center>
  			<h1>Create an Importer Account </h1>
	    	<img src="${pageContext.servletContext.contextPath}/images/shipping.jpg" alt="Image of winery." width="25%" height="25%" border="8">
	    </center>

  		<form action="http://localhost:7070/Pilot/ImporterAccount" method="post">
	      <label>Importer Username:</label>
	      <br />
	      <input type="text" name="user" size = 30 />
	      <br />
	      <label>Importer Password:</label>
	      <br />
	      <input type="text" name="pass" size = 30 />
	      <br />
	      <label>Importer Name:</label>
	      <br />
	      <input type="text" name="name" size = 30 />
	      <br />
	      <label>Importer Location:</label>
	      <br />
	      <input type="text" name="loc" size = 30 />
	      <br />
	      <input type="submit" />
	    </form>
	    <%
	    	}
    	%>

	    <!-- sends data to bean to upload to database -->
	    <%
    		if (request.getMethod().equals("POST"))
	   		{
	    %>

	    <center>
		    <h1>New Importer Account Created!</h1>
	    	<img src="${pageContext.servletContext.contextPath}/images/shipping.jpg" alt="Image of winery." width="25%" height="25%" border="8">
		    <p>Submit form again to add another entry or select "home" to return to the homepage.</p>
		</center>

	    <jsp:useBean id='bean' class='andrew.beans.ImporterBean' />
	    <jsp:setProperty name='bean' property='importUser' value='<%=request.getParameter("user")%>' />
	    <jsp:setProperty name='bean' property='password' value='<%=request.getParameter("pass")%>' />
	    <jsp:setProperty name='bean' property='name' value='<%=request.getParameter("name")%>' />
	    <jsp:setProperty name='bean' property='location' value='<%=request.getParameter("loc")%>' />

	    <!-- redisplay form -->
	    <form action="http://localhost:7070/Pilot/ImporterAccount" method="post">
	      <label>Importer Username:</label>
	      <br />
	      <input type="text" name="user" size = 30 />
	      <br />
	      <label>Importer Password:</label>
	      <br />
	      <input type="text" name="pass" size = 30 />
	      <br />
	      <label>Importer Name:</label>
	      <br />
	      <input type="text" name="name" size = 30 />
	      <br />
	      <label>Importer Location:</label>
	      <br />
	      <input type="text" name="loc" size = 30 />
	      <br />
	      <input type="submit" />
	    </form>

	    <!-- adds account to database -->
	    <% 
	    	bean.updateDatabase(); 
	    	}
    	%>


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
