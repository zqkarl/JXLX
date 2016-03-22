<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
list
<table>
<thead>
<tr>
<th>id</th>
<th>资源名称</th>
<th>资源描述</th>
<th>url</th>
<th>permission</th>
</tr>
</thead>
<tbody>

<c:forEach items="${resourceList}" var="resource">
<tr>
<td><c:out value="${resource.id}"/></td>
<td><c:out value="${resource.resourceName}"/></td>
<td><c:out value="${resource.resourceDesc}"/></td>
<td><c:out value="${resource.url}"/></td>
<td><c:out value="${resource.permission}"/></td>
</tr>
</c:forEach>

</tbody>
</table>
<a href="${pageContext.request.contextPath}/resource/showedit">add</a>
</body>
</html>