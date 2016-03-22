<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>  
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/event/add" method="post" enctype="multipart/form-data">
活动标题：<input type="text" name="title"><br>
活动内容：<textarea rows="20" cols="50" name="content"></textarea><br>
<c:forEach items="${classes}" var="c">
<input type="checkbox" name="classes" value="${c.id }"
>${c.className}
</c:forEach>
<br>
附件上传：<input type="file" name="file" accept=".zip,.7z,.rar">
<input type="submit" value="add"> 
</form>
</body>
</html>