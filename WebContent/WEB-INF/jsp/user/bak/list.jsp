<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
userlist
<table class="table">
    <thead>
        <tr>
        	<th>ID</th>
            <th>教师名字</th>
          
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
            	<td>${user.id}</td>
                <td>${user.teacherName}</td>
                
                <td><a href="${pageContext.request.contextPath}/user/${user.id}/update">修改</a></td>
                <td><a href="${pageContext.request.contextPath}/user/${user.id}/delete">删除</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/user/add">新增</a>
</body>
</html>