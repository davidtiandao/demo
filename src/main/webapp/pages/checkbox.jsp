<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/demo/account/setUserStatus.action" method="post"> 
	您喜欢的水果？<br /><br /> 
	<label><input name="id" type="checkbox" value="127622ef-33b2-46df-b981-f57e4f92cd38" />1 </label> 
	<label><input name="id" type="checkbox" value="2b510ffa-469a-49ed-8776-4a8a03521e0c" />2</label> 
	<label><input name="id" type="checkbox" value="3f28ad40-f27c-4fcc-8dbf-2a0409221e5a" />3 </label> 
	<label><input name="id" type="checkbox" value="43511cc7-95a6-4244-b2d1-57ee7563bf24" />4 </label> 
	<input type="text" name="userStatus" id="status"/>
	<input type="submit" value="submit" name="submit">
</form> 
</body>
</html>