<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>家校联系系统家长版</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/static/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <a class="navbar-brand" href="${pageContext.request.contextPath}">家校联系系统家长版</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i>&nbsp;&nbsp;<span class="badge" style="background-color:red"></span><b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown" id="msg">
                        
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${currentStudent.studentName }家长<b class="caret"></b></a>
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
                	<li class="active">
                        <a href="${pageContext.request.contextPath}/event/student"><i class="fa fa-fw fa-file"></i> 活动通知</a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/event/student"><i class="fa fa-fw fa-file"></i> 活动通知</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/score/student"><i class="fa fa-fw fa-info"></i> 排名分析</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/mail"><i class="fa fa-fw fa-envelope"></i> 站内信</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper" >

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            欢迎${currentStudent.studentName }家长，祝生活愉快
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/morris/morris.min.js"></script>
    <script src="j${pageContext.request.contextPath}/static/s/plugins/morris/morris-data.js"></script>

</body>

</html>
