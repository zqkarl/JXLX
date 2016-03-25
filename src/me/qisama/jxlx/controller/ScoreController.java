package me.qisama.jxlx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.service.ExamService;
import me.qisama.jxlx.service.ScoreService;
import me.qisama.jxlx.service.StudentService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private ExamService examService;

	/**
	 * 新增单条学生成绩
	 * @param examId
	 * @param studentId
	 * @param teacherComment
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String addScore(
			@RequestParam("examId") Integer examId,
			@RequestParam("studentId") Long studentId,
			@RequestParam("score") String score,
			@RequestParam(value="teacherComment" ,required = false) String teacherComment,
			Model model,
			HttpSession session) {
		Exam exam = examService.selectById(examId);
		model.addAttribute("exam", exam);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		
		Score oneScore = new Score();
		oneScore.setExamId(examId);
		oneScore.setStudentId(studentId);
		oneScore.setScore(score);
		oneScore.setTeacherComment(teacherComment);
		oneScore.setEntryTime(sdf.format(new Date()));
		oneScore.setEntryTeacherId(Long.valueOf(username));
		oneScore.setModifyTeacherId(Long.valueOf(username));
		oneScore.setModifyTime(sdf.format(new Date()));
		
		scoreService.Create(oneScore);
		
		// 展示已录入成绩同学
		List<Score> scores = scoreService.selectByExamId(examId);
		model.addAttribute("scoreList", scores);
		
		// 在session中删除已添加学生
		// 显示未录入同学
		List<Student> students = studentService.selectByGradeId(exam.getGradeId());
		for (Score s : scores) {
			Iterator<Student> it = students.iterator();
			while (it.hasNext()) {
				Student student = (Student) it.next();
				if (student.getId().equals(s.getStudentId()) || student.getId().equals(studentId)) {
					it.remove();
				}
			}
		}
		session.setAttribute("studentList", students);
		
		
		
		
		return "exam/score";
	}
	
	/**
	 * 在detail界面中新增单条学生成绩
	 * @param examId
	 * @param studentId
	 * @param teacherComment
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/detail/add" , method = RequestMethod.POST)
	public String addDetailScore(
			@RequestParam("examId") Integer examId,
			@RequestParam("studentId") Long studentId,
			@RequestParam("score") String score,
			@RequestParam(value="teacherComment" ,required = false) String teacherComment,
			Model model,
			HttpSession session) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		
		Score oneScore = new Score();
		oneScore.setExamId(examId);
		oneScore.setStudentId(studentId);
		oneScore.setScore(score);
		oneScore.setTeacherComment(teacherComment);
		oneScore.setEntryTime(sdf.format(new Date()));
		oneScore.setEntryTeacherId(Long.valueOf(username));
		oneScore.setModifyTeacherId(Long.valueOf(username));
		oneScore.setModifyTime(sdf.format(new Date()));
		
		scoreService.Create(oneScore);
		
//		// 在session中删除已添加学生
//		@SuppressWarnings("unchecked")
//		List<Student> students = (List<Student>) session.getAttribute("studentList");
//		students.remove(studentService.selectById(studentId));
//		session.setAttribute("Students", students);
//		
//		// 展示已录入成绩同学
//		List<Score> scores = scoreService.selectByExamId(examId);
//		model.addAttribute("scoreList", scores);
		
		
		return "redirect:/exam/"+examId+"/detail";
	}
}
