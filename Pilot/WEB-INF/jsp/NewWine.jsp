<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>

<!-- page to add new wine to the database -->


<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
 	<body bgcolor="#ff9999">
  		<!-- sends data to bean to upload to database -->
	    <%
    		if (request.getMethod().equals("GET"))
	   		{
	    %>

  		<center>
  			<h1>Add a New Wine </h1>
	    	<img src="${pageContext.servletContext.contextPath}/images/wine.jpg" alt="Image of winery." width="25%" height="25%" border="8">
	    </center>

  		<form action="http://localhost:7070/Pilot/NewWine" method="post">
	      <label>Wine Name:</label>
	      <br />
	      <input type="text" name="name" size = 30 />
	      <br />
	      <label>Wine Color:</label>
	      <br />
	      <input type="text" name="color" size = 30 />
	      <br />
	      <label>Wine Year:</label>
	      <br />
	      <input type="text" name="year" size = 30 />
	      <br />
	      <label>Wine Origin:</label>
	      <br />
	      <input type="text" name="origin" size = 30 />
	      <br />
	      <label>Wine Taste Notes:</label>
	      <br />
	      <input type="text" name="notes" size = 30 />
	      <br />
	      <label>Winery:</label>
	      <br />
	      <input type="text" name="winery" size = 30 />
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
		   	<h1>New Wine Added!</h1>
	    	<img src="${pageContext.servletContext.contextPath}/images/wine.jpg" alt="Image of winery." width="25%" height="25%" border="8">
		    <p>Submit form again to add another entry or select "home" to return to the homepage.</p>
		</center>

	    <jsp:useBean id='bean' class='andrew.beans.WineBean' />
	    <jsp:setProperty name='bean' property='name' value='<%=request.getParameter("name")%>' />
	    <jsp:setProperty name='bean' property='color' value='<%=request.getParameter("color")%>' />
	    <jsp:setProperty name='bean' property='year' value='<%=request.getParameter("year")%>' />
	    <jsp:setProperty name='bean' property='origin' value='<%=request.getParameter("origin")%>' />
	    <jsp:setProperty name='bean' property='tasteNotes' value='<%=request.getParameter("notes")%>' />
	    <jsp:setProperty name='bean' property='wineryUser' value='<%=request.getParameter("winery")%>' />

	    <!-- redisplay form -->
	    <form action="http://localhost:7070/Pilot/NewWine" method="post">
	      <label>Wine Name:</label>
	      <br />
	      <input type="text" name="name" size = 30 />
	      <br />
	      <label>Wine Color:</label>
	      <br />
	      <input type="text" name="color" size = 30 />
	      <br />
	      <label>Wine Year:</label>
	      <br />
	      <input type="text" name="year" size = 30 />
	      <br />
	      <label>Wine Origin:</label>
	      <br />
	      <input type="text" name="origin" size = 30 />
	      <br />
	      <label>Wine Taste Notes:</label>
	      <br />
	      <input type="text" name="notes" size = 30 />
	      <br />
	      <label>Winery:</label>
	      <br />
	      <input type="text" name="winery" size = 30 />
	      <br />
	      <input type="submit" />
	    </form>

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