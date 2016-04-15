<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="/WEB-INF/tld/functions.tld" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>学生管理</title>

   <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    
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

    <script type="text/javascript">
        $(document).ready(function(){
            $("#addButton").click(function(){
                $("#sutdentAddForm").modal();
            });
        });
    </script>
    <script type="text/javascript">
        function add(){
            var studentId = $("#studentId").val();
            var studentName = $("#studentName").val();
            var studentClass = $("#studentClass").val();
            var phone = $("#phone").val();
            if (studentId == "") {
                $("#id-info").show();
                $("#name-info").hide();
                $("#class-info").hide();
                $("#phone-info").hide();
            } else if(studentName == ""){
                $("#id-info").hide();
                $("#name-info").show();
                $("#class-info").hide();
                $("#phone-info").hide();
            }else if(studentClass == ""){
                $("#id-info").hide();
                $("#name-info").hide();
                $("#class-info").show();
                $("#phone-info").hide();
            }else if(phone == ""){
                $("#id-info").hide();
                $("#name-info").hide();
                $("#class-info").hide();
                $("#phone-info").show();
            }else {
                $("#addForm").submit();
            };
        }

        function update(){
            var studentId = $("#studentIdU").val();
            var studentName = $("#studentNameU").val();
            var studentClass = $("#studentClassU").val();
            var phone = $("#phone").val();
            if (studentId == "") {
                $("#id-info").show();
                $("#name-info").hide();
                $("#class-info").hide();
                $("#phone-info").hide();
            } else if(studentName == ""){
                $("#id-info").hide();
                $("#name-info").show();
                $("#class-info").hide();
                $("#phone-info").hide();
            }else if(studentClass == ""){
                $("#id-info").hide();
                $("#name-info").hide();
                $("#class-info").show();
                $("#phone-info").hide();
            }else if(phone == ""){
                $("#id-info").hide();
                $("#name-info").hide();
                $("#class-info").hide();
                $("#phone-info").show();
            }else{
                $("#resourceEditForm").submit();
            };
        }

        function showUpdate (id) {
            // body...
            $.ajax({
                    type: 'post',
                    data : {id : id},
                    dataType : 'json',
                    url: '${pageContext.request.contextPath}/student/showUpdate',
                    success : function(d){
                        if(1 == d.status){
                            $('#studentIdU').val(id);
                            $('#studentNameU').val(d.data.studentName);
                            $('#classIdU').val(d.data.classId);
                            $('#phoneU').val(d.data.contactPhone);
                            $("#editForm").modal();
                        }else{
                            alert('错误'+d.message)
                        }
                    }

                });
                
        }
		
        function restoreDefault (id) {
        	$.post("student/restoreDefaultPwd",{studentId:id},
        			function(d){
        		if(d.status==1){
        			alert("恢复默认密码成功");
        		}
        		
        	});
        }
        
        function del (id) {
            // body...
            if (confirm('真的要删除么？')) {
                window.location.href = "${pageContext.request.contextPath}/student/"+id+"/delete";
                return true;
            } else{
                return false;
            };
        }

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
                            学生管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="#">权限管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 学生管理
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    
                    <div class="col-lg-12">
                        <h2>学生详细列表</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
										
										<th>学号</th>
										<th>姓名</th>
										<th>班级</th>
										<th>家长联系电话</th>
										<th>操作</th>
									</tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${studentList}" var="student">
										<tr>
											
											<td><c:out value="${student.id}"/></td>
											<td><c:out value="${student.studentName}"/></td>
											<td>${fn:className(student.classId)}</td>
											<td><c:out value="${student.contactPhone}"/></td>
											<td>
												<shiro:hasRole name="管理员">
												<button type="button" class="btn btn-primary btn-xs" title="恢复默认密码" onclick="restoreDefault('${student.id}')"><i class="fa fa-history"></i></button>
												</shiro:hasRole>
                                                <button type="button" id="updateButton" class="btn btn-primary btn-xs" title="修改" onclick="showUpdate('${student.id}')"><i class="fa fa-pencil"></i></button>
                                                <shiro:hasPermission name="student:action">
                                                <button type="button" class="btn btn-primary btn-xs" title="删除" onclick="del('${student.id}')"><i class="fa fa-trash"></i></button>
                                                </shiro:hasPermission>
                                            </td>
										</tr>
									</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <shiro:hasPermission name="student:action">
                <button type="button" class="btn btn-primary" id="addButton" style="float:right;width:10%">新增学生</button>
                </shiro:hasPermission>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="sutdentAddForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal" aria-hidden="true">
                      &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   资源
                </h4>
             </div>
             <div class="modal-body">
                <form id="addForm" action="${pageContext.request.contextPath}/student/add" method="post">
                <input type="hidden" name="id">
                <div class="modal-row">
                    <div class="modal-row-left">学号：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="studentId" name="studentId" >
                    </div>
                    <div class="modal-row-right" id="id-info"><i class="fa fa-warning"></i>学号不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">姓名：</div>
                    <div class="modal-row-middle">
                         <input type="text" class="form-control" name="studentName" id="studentName">
                    </div>
                    <div class="modal-row-right" id="name-info"><i class="fa fa-warning"></i>姓名不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">班级：</div>
                        <div class="modal-row-middle">
                            <select class="form-control" name="classId" id="classId">
                            <option selected="selected" value="">请选择班级</option>
                            <c:forEach items="${classeList}" var="classe">
                                <option value="${classe.id}">${classe.className}</option>
                            </c:forEach>
                            </select>
                        </div>
                    <div class="modal-row-right" id="class-info"><i class="fa fa-warning"></i>请选择一个班级</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">家长电话：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" name="contactPhone" id="contactPhone">
                    </div>
                    <div class="modal-row-right" id="phone-info"><i class="fa fa-warning"></i>家长电话不能为空</div>
                </div>
                </form>
             </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-default" 
                   data-dismiss="modal">关闭
                </button>
                <button type="button" id="opButton" class="btn btn-primary" onclick="add();">
                   新增
                </button>
             </div>
          </div><!-- /.modal-content -->
      </div>
    </div><!-- /.modal -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="editForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal" aria-hidden="true">
                      &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   资源
                </h4>
             </div>
             <div class="modal-body">
                <form id="resourceEditForm" action="${pageContext.request.contextPath}/student/update" method="post">
                <input type="hidden" name="id" id="idU">
                <div class="modal-row">
                    <div class="modal-row-left">学号：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="studentIdU" name="studentId" readonly>
                    </div>
                    <div class="modal-row-right" id="idU-info"><i class="fa fa-warning"></i>学号不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">姓名：</div>
                    <div class="modal-row-middle">
                         <input type="text" class="form-control" name="studentName" id="studentNameU">
                    </div>
                    <div class="modal-row-right" id="nameU-info"><i class="fa fa-warning"></i>姓名不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">班级：</div>
                    <div class="modal-row-middle">
                        <select class="form-control" name="classId" id="classIdU">
                        <c:forEach items="${classeList}" var="classe">
                            <option value="${classe.id}">${classe.className}</option>
                        </c:forEach>
                        </select>
                    </div>
                    <div class="modal-row-right" id="classU-info"><i class="fa fa-warning"></i>请选择一个班级</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">家长电话：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" name="contactPhone" id="phoneU">
                    </div>
                    <div class="modal-row-right" id="phoneU-info"><i class="fa fa-warning"></i>家长电话不能为空</div>
                </div>
                </form>
             </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-default" 
                   data-dismiss="modal">关闭
                </button>
                <shiro:hasPermission name="student:action">
                <button type="button" id="opButton" class="btn btn-primary" onclick="update();">
                   更新
                </button>
                </shiro:hasPermission>
             </div>
          </div><!-- /.modal-content -->
      </div>
    </div><!-- /.modal -->
</body>

</html>
