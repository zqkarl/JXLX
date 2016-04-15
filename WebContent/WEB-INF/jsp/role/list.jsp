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

    <title>角色管理</title>

   <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <style type="text/css">
    .modal-body{
        overflow: auto;
    }
    </style>

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
                $("#addForm").modal();
            });
        });
    </script>
    <script type="text/javascript">
        function add(){
            var role = $("#role").val();
            if (role == "") {
                $("#role-info").show();
            } else{
                $("#resourceAddForm").submit();
            };
        }

        function update(){
            var role = $("#roleU").val();
            if (role == "") {
                $("#roleU-info").show();
            } else{
                $("#resourceEditForm").submit();
            };
        }

        function showUpdate (id) {
        	$("input[id='resourceIdsU']").prop('checked',false);
            // body...
            $.ajax({
                    type: 'post',
                    data : {id : id},
                    dataType : 'json',
                    url: '${pageContext.request.contextPath}/role/showUpdate',
                    success : function(d){
                        if(1 == d.status){
                        	var checkids = d.data2;
                        	var states = d.data.states;
                            $('#idU').val(id);
                            $('#roleU').val(d.data.role);
                            $('#roleDescU').val(d.data.roleDesc);
                            if (states) {
                            	$('#statesU').val("true");
                            } else{
                            	$('#statesU').val("false");
                            };
                            

                            $.each( $("input[id='resourceIdsU']"), function(i, n){
							    if(checkids.indexOf($(this).val())>=0){
							    $(this).prop("checked","checked");
							    }
						    });

                            $("#editForm").modal();
                        }
                    }

                });
                
        }

        function del (id) {
            // body...
            if (confirm('真的要删除么？')) {
                window.location.href = "${pageContext.request.contextPath}/role/"+id+"/delete";
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
                            角色管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-wrench"></i>  <a href="#">权限管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 角色管理
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    
                    <div class="col-lg-12">
                        <h2>角色详细列表</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
										
										<th>角色名称</th>
										<th>角色描述</th>
										<th>角色状态</th>
										<th>操作</th>
									</tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${roleList}" var="role">
										<tr>
											<td><c:out value="${role.role}"/></td>
											<td><c:out value="${role.roleDesc}"/></td>
											<td>
												<c:if test="${role.states}">
													<c:out value="正常" />
												</c:if>
												<c:if test="${role.states == false}">
													<c:out value="冻结" />
												</c:if>
											</td>
											<td>
                                                <button type="button" id="updateButton" class="btn btn-primary btn-xs" title="修改" ><i class="fa fa-pencil" onclick="showUpdate('${role.id}')"></i></button>
                                                <shiro:hasPermission name="role:action">
                                                <button type="button" class="btn btn-primary btn-xs" title="删除" onclick="del('${role.id}')"><i class="fa fa-trash"></i></button>
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
                <shiro:hasPermission name="role:action">
                <button type="button" class="btn btn-primary" id="addButton" style="float:right;width:10%">新增角色</button>
                </shiro:hasPermission>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="addForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal" aria-hidden="true">
                      &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   角色
                </h4>
             </div>
             <div class="modal-body">
                <form id="resourceAddForm" action="${pageContext.request.contextPath}/role/add" method="post">
                <input type="hidden" name="id">
                <div class="modal-row">
                    <div class="modal-row-left">角色名称：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="role" name="role">
                    </div>
                    <div class="modal-row-right" id="role-info"><i class="fa fa-warning"></i>角色名称不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色描述：</div>
                    <div class="modal-row-middle">
						<input type="text" class="form-control" id="roleDesc" name="roleDesc">
                    </div>
                    <div class="modal-row-right"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色状态：</div>
                    <div class="modal-row-middle">
                        <select class="form-control" name="states" id="states">
                         	<option value="true">正常</option>
                         	<option value="false">冻结</option>
                         </select> 
                    </div>
                    <div class="modal-row-right"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">权限：</div>
                    <div class="modal-row-middle" style="width:73%">
                        <c:forEach items="${resourceList}" var="r">
							<input type="checkbox" name="resourceIds" value="${r.id }"
							>${r.resourceName }
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
                   资源
                </h4>
             </div>
             <div class="modal-body">
                <form id="resourceEditForm" action="${pageContext.request.contextPath}/role/update" method="post">
                <input type="hidden" name="id" id="idU">
                <div class="modal-row">
                    <div class="modal-row-left">角色名称：</div>
                    <div class="modal-row-middle">
                        <input type="text" class="form-control" id="roleU" name="role">
                    </div>
                    <div class="modal-row-right" id="role-info"><i class="fa fa-warning"></i>角色名称不能为空</div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色描述：</div>
                    <div class="modal-row-middle">
						<input type="text" class="form-control" id="roleDescU" name="roleDesc">
                    </div>
                    <div class="modal-row-right"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">角色状态：</div>
                    <div class="modal-row-middle">
                        <select class="form-control" name="states" id="statesU">
                         	<option selected="selected" value="true">正常</option>
                         	<option value="false">冻结</option>
                         </select> 
                    </div>
                    <div class="modal-row-right"></div>
                </div>
                <div class="modal-row">
                    <div class="modal-row-left">权限：</div>
                    <div class="modal-row-middle" style="width:73%">
                        <c:forEach items="${resourceList}" var="r">
							<input type="checkbox" name="resourceIds" id="resourceIdsU" value="${r.id }"
							>${r.resourceName }
						</c:forEach>
                    </div>
                </div>
                </form>
             </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-default" 
                   data-dismiss="modal">关闭
                </button>
                <shiro:hasPermission name="role:action">
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
