<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/demo/account/addUser.action" method="post">
		名字：<input  type="text" id="fullName" name="fullName" /><br/>
		电话：<input id="phone" name="phone" type="text"/><br/>
		家庭电话：<input id="telphone" name="telphone" type="text"/><br/>
		性别：<input id="gender" name="gender" type="text"/><br/>
		性别：<input id="birthday" name="birthday" type="text"/><br/>
		家庭地址：<input id="hometown" name="hometown" type="text"/><br/>
		现居地：<input id="livePlace" name="livePlace" type="text"/><br/>
		用户状态：<input id="userStatus" name="userStatus" type="text"><br>
		用户登录帐号：<input  type="text" id="username" name="userName" /><br/>
		用户登录密码： <input id="password" name="password" type="password"/><br/>
				<input type="submit"  name="submit" value="submit"  /><br/>
		${error }
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
	$.ajax({
		url:'${pageContext.request.contextPath}/manager/listUser.action?pageNo=1',
		method:'get',
		success:function(date){
			alert(date);
		}
		
	});
	</script>
	
</body>
</html>