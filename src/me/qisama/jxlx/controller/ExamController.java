package me.qisama.jxlx.controller;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.service.ExamService;
import me.qisama.jxlx.service.GradeService;
import me.qisama.jxlx.service.ScoreService;
import me.qisama.jxlx.service.StudentService;
import me.qisama.jxlx.service.SubjectService;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("examList", examService.findAll());
		model.addAttribute("gradeList", gradeService.findAll());
		model.addAttribute("subjectList", subjectService.findAll());
		return "exam/list";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public String createList(Model model) {
		model.addAttribute("gradeList", gradeService.findAll());
		model.addAttribute("subjectList", subjectService.findAll());
		return "exam/add";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String create(
			@RequestParam("subjectId") Integer subjectId,
			@RequestParam("gradeId") Integer gradeId,
			@RequestParam("examStartTime") String examStartTime,
			Model model,
			HttpSession session) {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Exam exam = new Exam();
		exam.setSubjectId(subjectId);
		exam.setGradeId(gradeId);
		exam.setExamStartTime(examStartTime);
		
		examService.create(exam);
		model.addAttribute("exam", exam);
		List<Student> students = studentService.selectByGradeId(gradeId);
		session.setAttribute("studentList", students);
		return "exam/score";
	}
	
	@RequestMapping(value = "/{id}/detail" , method = RequestMethod.GET)
	public String showDetails(
			@PathVariable("id") Integer examId,
			Model model,
			HttpSession session) {
		Exam exam = examService.selectById(examId);
		model.addAttribute("exam", exam);
		
		// 展示已录入成绩同学
		List<Score> scores = scoreService.selectByExamId(examId);
		model.addAttribute("scoreList", scores);
		
		// 显示未录入同学
		List<Student> students = studentService.selectByGradeId(exam.getGradeId());
		for (Score score : scores) {
			Iterator<Student> it = students.iterator();
			while (it.hasNext()) {
				Student student = (Student) it.next();
				if (student.getId().equals(score.getStudentId())) {
					it.remove();
				}
			}
		}
		session.setAttribute("studentList", students);
//		model.addAttribute("studentList", students);
		
		return "exam/detail";
	}
}