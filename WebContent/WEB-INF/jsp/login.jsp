<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>
<div id="container_demo" >
	<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
	<a class="hiddenanchor" id="toregister"></a>
	<a class="hiddenanchor" id="tologin"></a>
	<div id="wrapper">
		<div id="login" class="animate form" style="margin-top:10%">
			<form  action="" autocomplete="on" method="post"> 
				<h1>家校联系系统登录</h1> 
				<p> 
					<label for="username" class="uname" data-icon="u" > 教师工号或用户名： </label>
					<input id="username" name="username" required="required" type="text" value="<shiro:principal/>" placeholder="username"/>
				</p>
				<p> 
					<label for="password" class="youpasswd" data-icon="p"> 你的密码： </label>
					<input id="password" name="password" required="required" type="password" placeholder="password" /> 
				</p>
				<p class="keeplogin"> 
					<input type="checkbox" name="rememberMe" id="loginkeeping" value="true" /> 
					<label for="loginkeeping">记住我</label>
				</p>
				<p class="login button"> 
					<input type="submit" value="登录" /> 
				</p>
				<p class="change_link">
					<a href="">忘记你的密码了 ?</a>
				</p>
			</form>
		</div>
		
	</div>
</div>  
</body>
</html>