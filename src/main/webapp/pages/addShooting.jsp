<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/demo/shooting/addShooting.action" method="post">
		计划课程名称：<input  type="text" id="fullName" name="fullName" /><br/>
		教师姓名：<input id="phone" name="phone" type="text"/><br/>
		预计开课时间：<input id="telphone" name="telphone" type="text"/><br/>
		课程分类：<input id="gender" name="gender" type="text"/><br/>
		图片地址：<input type="file" name="file" id="file" ><br/>
		<input type="submit"  name="submit" value="submit"  /><br/>
		
		${error }
	</form>
</body>
</html>