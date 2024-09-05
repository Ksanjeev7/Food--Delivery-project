<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Forget-Password</title>
<link rel="stylesheet" href="Passwordreset.css">
<link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">

</head>
<body>
	<form action="ForgotPassword" method="post">
		<%
		if (request.getAttribute("message") != null) {
		%>
		<div id="message" class="<%=request.getAttribute("messageType")%>">
			<%=request.getAttribute("message")%>
		</div>
		<%
		}
		%>

		<label for="email">Email:</label> <input type="email" id="email"
			name="email" required> <input type="submit"
			value="Reset Password">
	</form>

</body>
</html>