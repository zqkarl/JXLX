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

    <title>教师管理</title>

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
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#addButton").click(function(){
                $("#userAddForm").modal();
            });
        });
    </script>
    <script type="text/javascript">
        function add(){
            var id = $("#id").val();
            var name = $("#teacherName").val();
           
            if (id == "") {
                $("#id-info").show();
                $("#name-info").hide();
             	
            } else if(name == ""){
                $("#id-info").hide();
                $("#name-info").show();
                
            }else {
                $("#addForm").submit();
            };
        }

        function update(){
        	var id = $("#idU").val();
            var name = $("#teacherNameU").val();

            if (id == "") {
                $("#idU-info").show();
                $("#nameU-info").hide();
             	
            } else if(name == ""){
                $("#idU-info").hide();
                $("#nameU-info").show();
                
            }else{
                $("#resourceEditForm").submit();
            };
        }

        function showUpdate (id) {
        	$("input[id='roleIdsU']").prop('checked',false);
            // body...
            $.ajax({
                    type: 'post',
                    data : {id : id},
                    dataType : 'json',
                    url: '${pageContext.request.contextPath}/user/showUpdate',
                    success : function(d){
                        if(1 == d.status){
                        	var checkids = d.data2;
                        	
                            $('#idU').val(id);
                            $('#teacherNameU').val(d.data.teacherName);
                            $('#subjectIdU').val(d.data.subjectId);
                            
                            $.each( $("input[id='roleIdsU']"), function(i, n){
							    if(checkids.toString().indexOf($(this).val())>=0){
							    $(this).prop("checked","checked");
							    }
						    });
                            
                            $("#editForm").modal();
                        }else{
                            alert('错误'+d.message)
                        }
                    }

                });
                
        }

        function del (id) {
            // body...
            if (confirm('真的要删除么？')) {
                window.location.href = "${pageContext.request.contextPath}/user/"+id+"/delete";
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${currentUser.teacherName } ${currentStudent.studentName }<b class="caret"></b></a>
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
                        	<shiro:lacksRole name="家长">
                            教师管理
                            </shiro:lacksRole>
                            <shiro:hasRole name="家长">
                            	教师信息
                            </shiro:hasRole>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="#">权限管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 教师管理
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    
                    <div class="col-lg-12">
                        <h2>教职工详细列表</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
										<th>工号</th>
										<th>姓名</th>
										<th>任教科目</th>
										<th>操作</th>
									</tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${userList}" var="user">
										<tr>
											
											<td><c:out value="${user.id}"/></td>
											<td><c:out value="${user.teacherName}"/></td>
											<td>${fn:subjectName(user.subjectId)}</td>
											<td>
                                                <button type="button" id="updateButton" class="btn btn-primary btn-xs" title="修改" ><i class="fa fa-pencil" onclick="showUpdate('${user.id}')"></i></button>
                                                <shiro:hasPermission name="teacher:action">
                                                <button type="button" class="btn btn-primary btn-xs" title="删除" onclick="del('${user.id}')"><i class="fa fa-trash"></i></button>
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
                <shiro:hasPermission name="teacher:action">
                <button type="button" class="btn btn-primary" id="addButton" style="float:right;width:10%">新增教师</button>
                </shiro:hasPermission>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="userAddForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal" aria-hidden="true">
                      &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   新增教师
                </h4>
             </div>
             <div class="modal-body">
                <form id="addForm" action="${pageContext.request.contextPath}/user/add" method="post">
                <div class="modal-row">
                    <div class="modal-row-left">工号：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="id" name="id" >
                    </div>
                    <div class="modal-row-right" id="id-info"><i class="fa fa-warning"></i>工号不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">姓名：</div>
                    <div class="modal-row-middle">
                         <input type="text" class="form-control" name="teacherName" id="teacherName">
                    </div>
                    <div class="modal-row-right" id="name-info"><i class="fa fa-warning"></i>姓名不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">任教科目：</div>
                        <div class="modal-row-middle">
                            <select class="form-control" name="subjectId" id="subjectId">
                            <option selected="selected" value="">请选择任教科目</option>
                            <c:forEach items="${subjectList}" var="subject">
                                <option value="${subject.id}">${subject.subjectName}</option>
                            </c:forEach>
                            </select>
                        </div>
                    <div class="modal-row-right" id="class-info"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色：</div>
                    <div class="modal-row-middle" style="width:73%">
                        <c:forEach items="${roleList}" var="r">
							<input type="checkbox" name="roleIds" id="roleIds" value="${r.id }"
							>${r.role }
						</c:forEach>
                    </div>
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
                   教师编辑框
                </h4>
             </div>
             <div class="modal-body">
                <form id="resourceEditForm" action="${pageContext.request.contextPath}/user/update" method="post">
                <div class="modal-row">
                    <div class="modal-row-left">工号：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="idU" name="id" readonly>
                    </div>
                    <div class="modal-row-right" id="idU-info"><i class="fa fa-warning"></i>工号不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">姓名：</div>
                    <div class="modal-row-middle">
                         <input type="text" class="form-control" name="teacherName" id="teacherNameU">
                    </div>
                    <div class="modal-row-right" id="nameU-info"><i class="fa fa-warning"></i>姓名不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">任教科目：</div>
                        <div class="modal-row-middle">
                            <select class="form-control" name="subjectId" id="subjectIdU">
                            <option value="">请选择任教科目</option>
                            <c:forEach items="${subjectList}" var="subject">
                                <option value="${subject.id}">${subject.subjectName}</option>
                            </c:forEach>
                            </select>
                        </div>
                    <div class="modal-row-right" id="class-info"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色：</div>
                    <div class="modal-row-middle" style="width:73%">
                        <c:forEach items="${roleList}" var="r">
							<input type="checkbox" name="roleIds" id="roleIdsU" value="${r.id }"
							>${r.role }
						</c:forEach>
                    </div>
                </div>
                </form>
             </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-default" 
                   data-dismiss="modal">关闭
                </button>
                <shiro:hasPermission name="teacher:action">
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
