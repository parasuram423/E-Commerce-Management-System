 <!DOCTYPE html>
<%@page import="com.codegnan.app.javawebapp18.dto.UserDto"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDto userDto = (UserDto) session.getAttribute("USERDTO");
		int userId = userDto.userId();
	%>
	<form action="addaddress" method="post">
		<input type="hidden" name="userid" value="<%= userId %>">
		Line 1<input type="text" name="line1"><br>
		Line 2<input type="text" name="line2"><br>
		Line 3<input type="text" name="line3"><br>
		City<input type="text" name="city"><br>
		State<input type="text" name="state"><br>
		Pincode<input type="text" name="pincode"><br>
		Label<select name="label">
		<option>Home</option>
		<option>Work</option>
		<option>Office</option>
		<option>Other</option>
		</select><br>
		<button type="submit">Add</button>
	</form>
</body>
</html>