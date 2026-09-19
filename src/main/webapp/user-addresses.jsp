 <!DOCTYPE html>
<%@page import="com.codegnan.app.javawebapp18.dto.AddressDto"%>
<%@page import="java.util.List"%>
<%@page import="com.codegnan.app.javawebapp18.dto.UserDto"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	UserDto userDto = (UserDto) session.getAttribute("USERDTO");
	List<AddressDto> addressDtosList = (List) session.getAttribute("ADDRESSLIST");
	%>

	<h2>
		Welcome
		<%=userDto.firstName()%>
		<%=userDto.lastName()%></h2>

	<%
	for (AddressDto addressDto : addressDtosList) {
	%>
		Address ID: <%= addressDto.addressId() %><br>
		Address Type: <%= addressDto.label() %><br>
		Line 1: <input type="text" name="" value="<%= addressDto.line1() %>"><br>
		Line 2: <%= addressDto.line2() %><br>
		Line 3: <%= addressDto.line3() %><br>
		City: <%= addressDto.city() %><br>
		State: <%= addressDto.state() %><br>
		Pincode: <%= addressDto.pincode() %>
		<button type="button">Update</button><br><br>
	<%
	}
	%>
</body>
</html>