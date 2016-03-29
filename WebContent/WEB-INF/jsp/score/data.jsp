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

    <title>创建成绩</title>

   <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" media="screen">
    
    <!-- Bootstrap DateTimePicker CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">
    
    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/static/css/plugins/morris.css" rel="stylesheet">

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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i>&nbsp;&nbsp;<span class="badge" style="background-color:red">3</span><b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>小明的家长</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> 2016-3-12 12:29:10</p>
                                        <p>关于小明的请假</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                   <div class="media-body">
                                        <h5 class="media-heading"><strong>小明的家长</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> 2016-3-12 12:29:10</p>
                                        <p>关于小明的请假</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>小明的家长</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> 2016-3-12 12:29:10</p>
                                        <p>关于小明的请假</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#"> 查看更多未读消息</a>
                        </li>
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
                    <li>
                        <a href="${pageContext.request.contextPath}/exam"><i class="fa fa-fw fa-pencil"></i> 成绩录入</a>
                    </li>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="score:view">
                    <li class="active">
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
                            排名分析
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="${pageContext.request.contextPath}/exam">成绩</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 排名分析
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
               
				<!-- Morris Charts -->
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="page-header">考试数据分析</h2>
                        <p class="lead col-lg-3">请选择您要查看的考试: </p>
                        <div class="col-lg-5">
                        <select id="examSelector" class="form-control" onchange="changeExam(this.options[this.options.selectedIndex].value)">
                        <c:forEach items="${examList }" var="exam">
                        	<option value="${exam.id }">${exam.id}-${fn:subjectName(exam.subjectId) }-${fn:gradeName(exam.gradeId) }-${exam.examStartTime }</option>
                        </c:forEach>
                        </select>
                        </div>
                        
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	<div class="col-lg-4">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> 各成绩段人数分布</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <div class="text-right">
                                    <a href="#">查看更多 <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> 班级平均分排名分析</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    
                    
                </div>
                <!-- /.row -->
                
                
                
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
	    
	    $(document).ready(function(){
            var a = '<%=request.getAttribute("examSelected")%>';
            changeExam(a);
        });
	</script>
   	
   	<!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/morris/morris-data.js"></script>

</body>

</html>
