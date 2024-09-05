<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reset Password</title>
<link rel="stylesheet" href="resetPassword.css">
<link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">

</head>
<body>
	<h2>Reset Password</h2>
	<%
		String email = (String) session.getAttribute("email");
        String token = (String) session.getAttribute("resettoken");
    	String errorMessage = (String) request.getAttribute("errorPassword");

        if (token == null || token.isEmpty()) { %>

	<p class="error">Invalid or expired reset link. Please request a
		new password reset.</p>

	<% }else{ %>
	<%  if (errorMessage != null && !errorMessage.isEmpty()) { %>
	<p class="error"><%=errorMessage%></p>
	<% } %>
	<form action="updatePassword" method="post">
		<input type="hidden" name="email" value="${sessionScope.email}" /> <label
			for="newPassword">New Password:</label> <input type="password"
			id="newPassword" name="newPassword" required /> <br> <br>
		<label for="confirmPassword">Confirm New Password:</label> <input
			type="password" id="confirmPassword" name="confirmPassword" required />
		<br> <br>
		<button type="submit">Reset Password</button>
	</form>
	<%} %>
</body>
</html>
