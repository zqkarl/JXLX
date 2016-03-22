<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" media="screen">
    
    <!-- Bootstrap DateTimePicker CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">


    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    
    <!-- Bootstrap DateTimePicker JavaScript-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    
    
</head>
<body>
<div class="form-group col-md-12">
                <label for="dtp_input2" class="control-label">Date Picking1</label>
                <input size="16" type="text" readonly class="form-control form_date" > 
            </div>
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
	</script>
</body>
</html>