package me.qisama.jxlx.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import me.qisama.jxlx.bean.AreaChartData;
import me.qisama.jxlx.bean.DonutData;
import me.qisama.jxlx.bean.ResponseStatus;
import me.qisama.jxlx.bean.ScoreDistribution;
import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.ExamService;
import me.qisama.jxlx.service.ScoreService;
import me.qisama.jxlx.service.StudentService;
import me.qisama.jxlx.service.SubjectService;
import me.qisama.jxlx.service.TeacherService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ClasseService classeService;
	
	@Autowired
	private SubjectService subjectService;

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
			@RequestParam("score") Integer score,
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
			@RequestParam("score") Integer score,
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
	
	/**
	 * 显示教师分析页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/teacher", method = RequestMethod.GET)
	public String showTeacherData(Model model) {
		List<Exam> eList = new ArrayList<Exam>();
		if (SecurityUtils.getSubject().hasRole("班主任")) {
//			String username = (String) SecurityUtils.getSubject().getPrincipal();
//			Teacher teacher = teacherService.selectTeacherById(Long.valueOf(username));
			eList = examService.findAll();
		} else {
			String username = (String) SecurityUtils.getSubject().getPrincipal();
			Teacher teacher = teacherService.selectTeacherById(Long.valueOf(username));
			eList = examService.selectBySubjectId(teacher.getSubjectId());
		}
		
		model.addAttribute("examList", eList);
		model.addAttribute("examSelected", eList.get(0).getId());
		return "score/data";
	}
	
	/**
	 * 显示家长分析页面
	 * @return
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showStudentData(Model model) {
		try {
			String username = (String) SecurityUtils.getSubject().getPrincipal();
			Long studentId = Long.valueOf(username);
			Set<Exam> exams = examService.getAllByStudentId(studentId);
			model.addAttribute("examList", exams);
			model.addAttribute("subjectList", subjectService.findAll());
			model.addAttribute("examSelected", exams.iterator().next().getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "score/dataS";
	}
	
	/**
	 * 计算成绩分布
	 * @param examId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showDistribution")
	public Object showScoreDistrubution(@RequestParam("examId") Integer examId) {
		ScoreDistribution scoreDistribution = new ScoreDistribution();
		scoreDistribution.setExcellent(scoreService.countExcellentNum(examId));
		scoreDistribution.setGood(scoreService.countGoodNum(examId));
		scoreDistribution.setFair(scoreService.countFairNum(examId));
		scoreDistribution.setPass(scoreService.countPassNum(examId));
		scoreDistribution.setFail(scoreService.countFailNum(examId));
		
		List<DonutData> donutDatas = new ArrayList<DonutData>();
		DonutData excellent = new DonutData();
		excellent.setLabel("优秀人数");
		excellent.setValue(scoreService.countExcellentNum(examId));
		
		DonutData good = new DonutData();
		good.setLabel("良好人数");
		good.setValue(scoreService.countGoodNum(examId));
		
		DonutData fair = new DonutData();
		fair.setLabel("中等人数");
		fair.setValue(scoreService.countFairNum(examId));
		
		DonutData pass = new DonutData();
		pass.setLabel("及格人数");
		pass.setValue(scoreService.countPassNum(examId));
		
		DonutData fail = new DonutData();
		fail.setLabel("不及格人数");
		fail.setValue(scoreService.countFailNum(examId));
		
		donutDatas.add(excellent);
		donutDatas.add(good);
		donutDatas.add(fair);
		donutDatas.add(pass);
		donutDatas.add(fail);
		
		String json = JSON.toJSONString(donutDatas);
		
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(donutDatas);
		return responseStatus;
	}
	
	/**
	 * 单科近10场考试平均分图表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/avg")
	public Object showAvg() {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		Teacher teacher = teacherService.selectTeacherById(Long.valueOf(username));
		List<Exam> exams = examService.selectBySubjectId(teacher.getSubjectId());
		int n = exams.size();
		exams = n>=10 ? exams.subList(1, 10):exams.subList(0, n);// 得到最近10场考试
		
		List<AreaChartData> areaChartDatas = new ArrayList<AreaChartData>();
		for (Exam exam : exams) {
			Integer examId = exam.getId();
			double gradeAvg = scoreService.calcGradeAvg(examId).doubleValue();
			Integer gradeId = exam.getGradeId();
			List<Classe> classes = classeService.selectByGradeId(gradeId);
			AreaChartData areaChartData = new AreaChartData();
			double classOneAvg = scoreService.calcClassAvg(examId, classes.get(0).getId()).doubleValue();
			double classTwoAvg = scoreService.calcClassAvg(examId, classes.get(1).getId()).doubleValue();
			areaChartData.setPeriod(exam.getExamStartTime());
			areaChartData.setGrade(gradeAvg);
			areaChartData.setClassOne(classOneAvg);
			areaChartData.setClassTwo(classTwoAvg);
			areaChartDatas.add(areaChartData);
		}
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(areaChartDatas);
		return responseStatus;
		
	}
	
	/**
	 * 显示最近10场考试排名图表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/gradeRankChart")
	public Object showRankChart(@RequestParam(value = "subjectId", required = false) Integer subjectId) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		Set<Exam> exams = examService.getAllByStudentId(studentId);
		
		// 筛选出单科近10场考试
		if (null != subjectId && subjectId != 0) {
			Iterator<Exam> iterator = exams.iterator();
			while (iterator.hasNext()) {
				Exam exam = (Exam) iterator.next();
				if (exam.getSubjectId() != subjectId) {
					iterator.remove();
				}
			}
		}
		
		List<Exam> eList = new ArrayList<>(exams);
		int n = eList.size();
		eList = n>=10 ? eList.subList(1, 10):eList.subList(0, n);// 得到最近10场考试
		
		List<AreaChartData> areaChartDatas = new ArrayList<AreaChartData>();
		for (Exam exam : exams) {
			Integer examId = exam.getId();
			Integer gradeRank = scoreService.calcGradeRank(examId, studentId);
			AreaChartData areaChartData = new AreaChartData();
			areaChartData.setPeriod(exam.getExamStartTime());
			areaChartData.setGrade(gradeRank);
			areaChartDatas.add(areaChartData);
		}
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(areaChartDatas);
		return responseStatus;
	}
	
	/**
	 * 获取学生考试成绩
	 * @param examId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/student/score")
	public Object getStudentScore(@RequestParam("examId") Integer examId) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		Score score = scoreService.selectByExamIdAndStudentId(examId, studentId);
		
		Integer s = null;
		if (score!=null) {
			s = score.getScore();
		}
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(s);
		return responseStatus;
	}
	
	/**
	 * 获取班级排名
	 * @param examId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/classRank")
	public Object getClassRank(@RequestParam("examId") Integer examId) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		
		Integer rank = scoreService.calcClassRank(examId, studentId);
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(rank);
		return responseStatus;
	}
	
	/**
	 * 获取年级排名
	 * @param examId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/gradeRank")
	public Object getGradeRank(@RequestParam("examId") Integer examId) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		
		Integer rank = scoreService.calcGradeRank(examId, studentId);
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(rank);
		return responseStatus;
	}
	
	/**
	 * 查看评论
	 * @param examId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/comment", method = RequestMethod.GET)
	public Object comment(@RequestParam("examId") Integer examId) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		
		Score score = scoreService.selectByExamIdAndStudentId(examId, studentId);
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(score);
		return responseStatus;
	}
	
	/**
	 * 添加或修改家长评论
	 * @param examId
	 * @param comment
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/comment", method = RequestMethod.POST)
	public Object comment(@RequestParam("examId") Integer examId, @RequestParam("comment") String comment) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long studentId = Long.valueOf(username);
		
		Score score = scoreService.selectByExamIdAndStudentId(examId, studentId);
		score.setParentComment(comment);
		scoreService.updateSelective(score);
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(score);
		return responseStatus;
	}
}
