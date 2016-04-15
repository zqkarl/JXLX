<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="fn" uri="/WEB-INF/tld/functions.tld" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>编辑活动</title>

   <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- main CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    
    <!-- artTemplate -->
    <script src="${pageContext.request.contextPath}/static/js/template.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#submits").click(function(){
                $("#event-form").submit();
            });
            
            $.get("top3",function(result){ 
            	template.helper("transname",function(nameid){
            		var aaa = "222";
                	$.ajax({
                		type : 'POST',
                		url : 'name',
                		data: {id:nameid},
                		async: false,
                		success: function(result){  
                  			aaa = result.data;
                  			
                 		}
                	});
                	return aaa;
                	
                });
 				var html = template("messege",result);
  				$('#msg').html(html);
 			  });
            
            $.get("count",function(result){
            	var num = result.data;
            	
            	if(num != null && num>0) {
            		$('.badge').text(num);
            	}
            });
        });
    </script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
       <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}">家校联系系统教师版</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i>&nbsp;&nbsp;<span class="badge" style="background-color:red"></span><b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown" id="msg">
                        
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${currentUser.teacherName }<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> 密码重置</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-fw fa-power-off"></i> 注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
           <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                <shiro:lacksRole name="家长">
                    <li class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#authority"><i class="fa fa-fw fa-wrench"></i>
                        权限管理<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="authority" class="collapse">
                            <shiro:hasPermission name="teacher:view">
                            <li>
                                <a href="${pageContext.request.contextPath}/user"> 教师管理</a>
                            </li>
                            </shiro:hasPermission>

                            <shiro:hasPermission name="student:view">
                            <li>
                                <a href="${pageContext.request.contextPath}/student"> 学生管理</a>
                            </li>
                            </shiro:hasPermission>

                            <shiro:hasPermission name="subject:view">
                            <li>
                                <a href="${pageContext.request.contextPath}/subject"> 学科管理</a>
                            </li>
                            </shiro:hasPermission>

                            <shiro:hasPermission name="role:view">
                            <li>
                                <a href="${pageContext.request.contextPath}/role"> 角色管理</a>
                            </li>
                            </shiro:hasPermission>

                            <shiro:hasPermission name="resource:view">
                            <li>
                                <a href="${pageContext.request.contextPath}/resource"> 资源管理</a>
                            </li>
                            </shiro:hasPermission>
                        </ul> 
                    </li>
                </shiro:lacksRole>
                	<shiro:hasRole name="家长">
                	<li class="active">
                        <a href="${pageContext.request.contextPath}/user"><i class="fa fa-fw fa-archive"></i> 教师信息</a>
                    </li>
                	</shiro:hasRole>
                
                    <shiro:hasPermission name="event:create">
                    <li>
                        <a href="${pageContext.request.contextPath}/event/add"><i class="fa fa-fw fa-upload"></i> 上传活动</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="event:view">
                    <li>
                    	<shiro:lacksRole name="家长">
                        <a href="${pageContext.request.contextPath}/event"><i class="fa fa-fw fa-file"></i> 通知查看</a>
                        </shiro:lacksRole>
                        
                        <shiro:hasRole name="家长">
                        <a href="${pageContext.request.contextPath}/event/student"><i class="fa fa-fw fa-file"></i> 通知查看</a>
                        </shiro:hasRole>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="score:create">
                    <li>
                        <a href="${pageContext.request.contextPath}/exam"><i class="fa fa-fw fa-pencil"></i> 成绩录入</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="score:view">
                    <li>
                    	<shiro:lacksRole name="家长">
                        <a href="${pageContext.request.contextPath}/score/teacher"><i class="fa fa-fw fa-info"></i> 排名分析</a>
                        </shiro:lacksRole>
                        <shiro:hasRole name="家长">
                        <a href="${pageContext.request.contextPath}/score/student"><i class="fa fa-fw fa-info"></i> 排名分析</a>
                        </shiro:hasRole>
                    </li>
                    </shiro:hasPermission>
                    <li>
                        <a href="${pageContext.request.contextPath}/mail"><i class="fa fa-fw fa-envelope"></i> 站内信</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            发送站内信
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="${pageContext.request.contextPath}/mail">站内信</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 发送站内信
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                     <form action="${pageContext.request.contextPath}/mail/send" method="post">
                    <div class="col-lg-8 event-edit">
                       
                        	<div class="event-row col-md-12">
                        		<div class="col-md-2" style="text-size:18px;"><span style="color:red">*</span>主题：</div>
                        		<div class="event-input col-md-10"><input type="text" name="title" class="form-control "></div>
                        		
                        	</div>
							<div class="event-row col-md-12">
                        		<div class="col-md-2" style="text-size:18px;"><span style="color:red">*</span>内容：</div>
                        		<div class="event-input col-md-10">
									<textarea class="form-control" name="content" rows="10"></textarea>
                        		</div>
                        	</div>
                            <div class="col-md-8">
                            	<button class="btn btn-primary event-submit" id="submits">发送</button>
                            </div> 
                            
                       
                    </div>
                	<div class="col-lg-4">
                		<div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title">发件人选择</h3>
                            </div>
                            <div class="panel-body">
                            	<div class="form-group col-md-12">
					                <label for="titleKey" class="control-label">选择班级</label>
					                <select class="form-control" id="classeId" onchange="student()">
					                <option selected="selected" value="">--请选择班级--</option>
		                            <c:forEach items="${classList}" var="classe">
		                                <option value="${classe.id}">${classe.className}</option>
		                            </c:forEach>
		                            </select>
					            </div>
					            <div class="form-group col-md-12" id="std">
					            	
					            </div>
                            </div>
                        </div>
                	</div>
                 </form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
	<script id="studentlist" type="text/html">
	
	
 	   {{each data as student}}
			<li><input type="checkbox" name="toId" value={{student.id}}> {{student.studentName}}</li>
 	   {{/each}}
	
	</script>
	
	<script id="messege" type="text/html">
	{{each data as mail}}
	<li class="message-preview">
       <a href="${pageContext.request.contextPath}/mailread/{{mail.id}}">
          <div class="media">                         
             <div class="media-body">
            	<h5 class="media-heading"><strong>{{transname mail.fromId}}</strong>
                </h5>
             <p class="small text-muted"><i class="fa fa-clock-o"></i>{{mail.time}}</p>
  			<p>{{mail.title}}</p>
    		</div>
     	</div>
       </a>
    </li>
	{{/each}}
	<li class="message-footer">
         <a href="${pageContext.request.contextPath}/mail"> 查看更多未读消息</a>
    </li>
	</script>
   	<script>
   		function student(){
   			var classe = $('#classeId').val();
   			
   			$.get("selectStd", { classId: classe },
   				  function(result){
   				   
   					 var html = template("studentlist",result);
    				$('#std').html(html);
   				  });
   		}
   		
   		function top3(){
   			$.get("top3",function(result){
     				   
     				var html = template("messege",result);
      				$('#msg').html(html);
     				  });
   		}
   	</script>
   	
   	
</body>

</html>
