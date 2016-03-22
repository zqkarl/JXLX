<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
    var ids='${checkId}'; //el表达式后台取值为1，2，3....
    $.each( $("input[name='resourceIds']"), function(i, n){
    if(ids.indexOf($(this).val())>=0){
    $(this).attr("checked","checked");
    }
    });
});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/role/${op}" method="post">
ID：<input type="text" name="id" value="${role.id}">
角色：<input type="text" name="role" value="${role.role }">
角色描述：<input type="text" name="roleDesc" value="${role.roleDesc }">
<c:forEach items="${resourceList}" var="r">
<input type="checkbox" name="resourceIds" value="${r.id }"
>${r.resourceName }
</c:forEach>
<input type="submit" value="提交">
</form>
</body>
</html>