<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>  
            <% if (request.getAttribute("error") != null) {%>          
 <div id = "message" class ="<%=request.getAttribute("error")%>">
    	  			<%= request.getAttribute("error") %>
              <%} %>
   </div>   
</body>
</html>