<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("button").click(function(){
		  window.location.href="${pageContext.request.contextPath}/event/download?token=${event.attachmentId}";
	  });
	});
</script>
</head>
<body>
<p>活动标题：${event.title}<br></p>
<p style="width:70%">活动内容：${event.content}<br></p>
<c:if test="${event.attachmentId != null && event.attachmentId != ''}">
<button id="download" >下载</button>
</c:if>
<a href="${pageContext.request.contextPath}/event/download?token=${event.attachmentId}">下载</a>

</body>
</html>