<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(document).ready(function(){
    var ids='${checkId}'; //el表达式后台取值为1，2，3....
    $.each( $("input[name='roleIds']"), function(i, n){
    if(ids.indexOf($(this).val())>=0){
    $(this).attr("checked","checked");
    }
    });
});
</script>
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/${op}" method="post">
ID：<input type="text" name="id" value="${user.id}">
教师姓名：<input type="text" name="teacherName" value="${user.teacherName }">

<c:forEach items="${roleList}" var="r">
<input type="checkbox" name="roleIds" value="${r.id }"
>${r.role }
</c:forEach>
<input type="submit" value="提交">
</form>
</body>
</html>