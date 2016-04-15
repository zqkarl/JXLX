<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>创建成绩</title>

   <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" media="screen">
    
    <!-- Bootstrap DateTimePicker CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">

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
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    
    <!-- Bootstrap DateTimePicker JavaScript-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    
    <!-- artTemplate -->
    <script src="${pageContext.request.contextPath}/static/js/template.js"></script>
	
	<script id="messege" type="text/html">
	{{each data as mail}}
	<li class="message-preview">
       <a href="${pageContext.request.contextPath}/mail/read/{{mail.id}}">
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
	
	<script type="text/javascript">
        $(document).ready(function(){
        	$.get("/JXLX/mail/top3",function(result){ 
            	template.helper("transname",function(nameid){
            		var aaa = "222";
                	$.ajax({
                		type : 'POST',
                		url : '/JXLX/mail/name',
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
        	
        	$.get("/JXLX/mail/count",function(result){
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
                    <li >
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
                    <shiro:hasPermission name="event:create">
                    <li>
                        <a href="${pageContext.request.contextPath}/event/add"><i class="fa fa-fw fa-upload"></i> 上传活动</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="event:view">
                    <li>
                        <a href="${pageContext.request.contextPath}/event"><i class="fa fa-fw fa-file"></i> 通知查看</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="score:create">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/exam"><i class="fa fa-fw fa-pencil"></i> 成绩录入</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="score:view">
                    <li>
                        <a href="${pageContext.request.contextPath}/score/teacher"><i class="fa fa-fw fa-info"></i> 排名分析</a>
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
                            成绩录入
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="${pageContext.request.contextPath}/exam">成绩</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 成绩录入
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <form id="addForm" action="${pageContext.request.contextPath}/exam/add" method="post">
				<div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb col-lg-12" style="height:100px">
                            <div class="exam-row col-lg-3"><label for="" class="exam-search">考试科目</label>
                    	<select class="form-control" name="subjectId" id="subjectIdU">
                            <option value="" >请选择任教科目</option>
                            <c:forEach items="${subjectList}" var="subject">
                                <option value="${subject.id}">${subject.subjectName}</option>
                            </c:forEach>
                        </select>
						</div>
                    	<div class="exam-row col-lg-3"><label for="" class="exam-search">考试年级</label>
                    	<select class="form-control" name="gradeId">
		                	<option selected="selected" value="">--请选择年级--</option>
		           	        <c:forEach items="${gradeList }" var="grade">
					       		<option value="${grade.id }">${grade.gradeName }</option>
			             	</c:forEach>
					    </select>
						</div>
                    	<div class="exam-row col-lg-3"><label for="" class="exam-search">考试时间</label><input size="16" name="examStartTime" id="fromDate" type="text" readonly class="form-control form_date"></div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <a href="${pageContext.request.contextPath}/exam/">
				<button type="button" class="btn btn-primary" id="returnBtn" style="float:right;width:7%;margin-right:3%;margin-top:15px;">返 回</button>
				</a>
				
				
					<button type="button" class="btn btn-primary" id="addButton" style="float:right;width:7%;margin-right:3%;margin-top:15px;">下一步</button>
				
				
				</form>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
	<script type="text/javascript">
	    $('.form_date').datetimepicker({
	        language:  'zh-CN',
	        format: 'yyyy-mm-dd',
	        weekStart: 1,
	        todayBtn:  1,
	        autoclose: 1,
	        todayHighlight: 1,
	        startView: 2,
	        minView: 2,
	        forceParse: 0
	    });
	    
	    $('#addButton').click(function(){
	    	$('#addForm').submit();
	    });
	    
	</script>
   
</body>

</html>
