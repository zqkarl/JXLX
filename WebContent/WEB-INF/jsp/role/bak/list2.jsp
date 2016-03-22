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
rolelist
<table class="table">
    <thead>
        <tr>
        	<th>ID</th>
            <th>角色名称</th>
            <th>角色描述</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${roleList}" var="role">
            <tr>
            	<td>${role.id}</td>
                <td>${role.role}</td>
                <td>${role.roleDesc}</td>
                
                <td><a href="${pageContext.request.contextPath}/role/${role.id}/update">修改</a></td>
                <td><a href="${pageContext.request.contextPath}/role/${role.id}/delete">删除</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/role/add">新增</a>
</body>
</html>