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
イベント
<table>
	<thead>
		<tr>
			<th>文章标题</th>
			<th>时间</th>
			<th>删除</th>
		</tr>
	</thead>
<tbody>

	<c:forEach items="${eventList}" var="event">
	<tr>
		<td><a href="${pageContext.request.contextPath}/event/${event.id}/info"><c:out value="${event.title}"/></a></td>
		<td><c:out value="${event.entryTime}"/></td>
		<td><a href="${pageContext.request.contextPath}/event/${event.id}/delete">删除</a></td>
	</tr>
	</c:forEach>

</tbody>
</table>
<a href="${pageContext.request.contextPath}/event/add">新增</a>
</body>
</html>