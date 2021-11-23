<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%int cnt = 100;
String cnt_ = request.getParameter("cnt");

if(cnt_ != null && !cnt_.equals("")){
	cnt = Integer.parseInt(cnt_);
}

%>

<body>
	<%for(int i = 0; i<cnt;i++){ %>
	안녕 서블릿
	<br>
	<% } %>
</body>
</html>