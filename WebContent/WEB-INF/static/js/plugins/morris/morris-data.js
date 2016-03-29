// Morris.js Charts sample data for SB Admin template

function changeExam (examId) {
	$('#morris-donut-chart').empty();
	$('#morris-area-chart').empty();
    // body...
    $.get("showDistribution",{examId : examId},
    	function(d){
        var app = d.data;
        
        Morris.Donut({
            element: 'morris-donut-chart',
            data: app,
            resize: true
        });
      });
    
    $.get("avg",
    	function(d){
    	var app = d.data;
        
     // Area Chart
        Morris.Line({
        element: 'morris-area-chart',
        data: app,
        xkey: 'period',
        ykeys: ['grade', 'classOne', 'classTwo'],
        labels: ['年级平均分', '一班平均分', '两班平均分'],
        smooth: false,
        resize: true
    });
    });
}

function changeExamStudent (examId,subjectId) {
	$('#morris-area-chart').empty();
    
    $.get("gradeRankChart",{subjectId : subjectId},
    	function(d){
    	var app = d.data;
        
     // Area Chart
        Morris.Line({
        element: 'morris-area-chart',
        data: app,
        xkey: 'period',
        ykeys: ['grade'],
        labels: ['年级排名'],
        smooth: false,
        resize: true
    });
    });
    
    $.get("student/score",{examId:examId},
    	function(d){
    	$('#score').empty();
    	$('#score').text(d.data);
    });
    
    $.get("classRank",{examId:examId},
    		function(d){
    	$('#classRank').empty();
    	$('#classRank').text(d.data);
    });
    
    $.get("gradeRank",{examId:examId},
    		function(d){
    	$('#gradeRank').empty();
    	$('#gradeRank').text(d.data);
    });
    
    $.get("comment",{examId:examId},
    		function(d){
    	$('#teacherComment').empty();
    	$('#parentComment').empty();
    	$('#teacherComment').text(d.data.teacherComment);
    	$('#parentComment').text(d.data.parentComment);
    });
    
}


