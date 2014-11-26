<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<video controls>
    <source src="${pageContext.request.contextPath}/video/chrome.webm#t=5" type="video/webm">
    <source src="chrome.mp4" type="video/mp4">
    <p>This browser does not support the video element.</p>
  </video>
</body>
</html>