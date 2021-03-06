package me.qisama.jxlx.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.ExamDaoImpl;
import me.qisama.jxlx.daoImpl.ScoreDaoImpl;
import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.Student;

@Service
public class ExamService {
	
	@Autowired
	private ExamDaoImpl examDaoImpl;
	
	@Autowired
	private ScoreDaoImpl scoreDaoImpl;
	
	private Log logger = LogFactory.getLog("System");
	
	public void create(Exam exam){
		examDaoImpl.create(exam);
		logger.info("【新增】新增考试"+exam.getId());
	}
	
	public Exam selectById(Integer id) {
		return examDaoImpl.selectById(id);
	}
	
	public List<Exam> findAll() {
		return examDaoImpl.findAll();
	}
	
	public List<Exam> selectBySubjectId(Integer subjectId) {
		return examDaoImpl.selectBySubjectId(subjectId);
	}
	
	public List<Exam> selectByGradeId(Integer gradeId) {
		return examDaoImpl.selectByGradeId(gradeId);
	}
	
	public Set<Exam> getAllByStudentId(Long studentId) {
		List<Score> scores = scoreDaoImpl.selectByStudentId(studentId);
		Set<Exam> exams = new HashSet<Exam>();
		for (Score score : scores) {
			Exam exam = examDaoImpl.selectById(score.getExamId());
			if (exam != null) {
				exams.add(exam);
			}	
		}
		return exams;
	}
}
