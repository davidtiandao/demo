<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/demo/account/login.action" method="post">
		<input  type="text" id="username" name="userName" /><br/>
		<input id="password" name="password" type="password"/><br/>
		<input type="submit"  name="submit" value="submit"  />
		${error }
	</form>
</body>
</html>