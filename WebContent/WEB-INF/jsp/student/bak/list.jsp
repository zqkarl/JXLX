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
studentlist
<table class="table">
    <thead>
        <tr>
        	<th>学号</th>
            <th>学生名字</th>
			<th>班级</th>
			<th>联系电话</th>          
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
            	<td>${student.id}</td>
                <td>${student.studentName}</td>
                <td>${student.classId}</td>
                <td>${student.contactPhone}</td>
                
                <td><a href="${pageContext.request.contextPath}/student/${student.id}/update">修改</a></td>
                <td><a href="${pageContext.request.contextPath}/student/${student.id}/delete">删除</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<form action="${pageContext.request.contextPath}/student/add" method="post">
id:<input type="text" name="id"><br>
name:<input type="text" name="studentName"><br>
class:<select name="classId">
<c:forEach items="${classeList }" var="classe">
<option value="${classe.id }">${classe.className }</option>
</c:forEach>
</select><br>
contactPhone:<input type="text" name="contactPhone"><br>
<input type="submit" value="新增">
</form>
</body>
</html>