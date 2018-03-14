<!DOCTYPE html>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="oracle.jdbc.OracleResultSetMetaData"%>

<!-- login page. users can login after creating an account. -->


<html lang="en">
  	<head>
    	<title>Wellnet Home</title>
  	</head>
  	<body bgcolor="#808080">
  		<%
        if (request.getMethod().equals("GET"))
        {
      %>

      <center>
        <h1>Login to Account </h1>
        <img src="${pageContext.servletContext.contextPath}/images/homepage.jpg" alt="Image of winery." width="10%" height="10%" border="8">
      </center>

      <form action="http://localhost:7070/Pilot/Login" method="post">
        <label>Username:</label>
        <br />
        <input type="text" name="user" size = 30 />
        <br />
        <label>Password:</label>
        <br />
        <input type="text" name="pass" size = 30 />
        <br />
        <input type="submit" />
      </form>
      <%
        }
      %>

      <!-- after user submits, credentials will be validated against database information. -->

      <%
        if (request.getMethod().equals("POST"))
        {
          %>
          
          <!-- bean to validat login -->
          <jsp:useBean id='bean' class='andrew.beans.LoginBean' />
          <jsp:setProperty name='bean' property='pass' value='<%=request.getParameter("pass").trim()%>' />
          <jsp:setProperty name='bean' property='user' value='<%=request.getParameter("user").trim()%>' />

          <%
      	  
      	  // user successfully matched credentials
          if (bean.login() == true)
          {
            %>
            <center>
              <h1>Login Successful</h1>
              <img src="${pageContext.servletContext.contextPath}/images/homepage.jpg" alt="Image of winery." width="10%" height="10%" border="8">
              <br />
              <br />
              <br />
              <br />
              <br />
              <h2>Welcome user: <jsp:getProperty property='user' name='bean' />
            </center>
          <%
          }
          // user credentials failed
          else if (bean.login() == false)
          {
          %>
              <h1>Login Failed</h1>
              <img src="${pageContext.servletContext.contextPath}/images/homepage.jpg" alt="Image of winery." width="10%" height="10%" border="8">
              <br />
              <br />
              <br />
              <br />
              <br />
              <h2>Please try logging in again, or return to homepage to create an account.</h2>

              <form action="http://localhost:7070/Pilot/Login" method="post">
                <label>Username:</label>
                <br />
                <input type="text" name="user" size = 30 />
                <br />
                <label>Password:</label>
                <br />
                <input type="text" name="pass" size = 30 />
                <br />
                <input type="submit" />
              </form>
          <%
          }
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


