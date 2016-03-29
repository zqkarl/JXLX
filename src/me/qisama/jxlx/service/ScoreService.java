package me.qisama.jxlx.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.ScoreDaoImpl;
import me.qisama.jxlx.daoImpl.StudentDaoImpl;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.StudentExample;
import me.qisama.jxlx.entity.StudentExample.Criteria;

@Service
public class ScoreService {

	@Autowired
	private ScoreDaoImpl scoreDaoImpl;
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	public int Create(Score score) {
		return scoreDaoImpl.create(score);
	}
	
	public int updateSelective(Score score) {
		return scoreDaoImpl.updateSelective(score);
	}
	
	public List<Score> selectByExamId(Integer examId) {
		return scoreDaoImpl.selectByExamId(examId);
	}
	
	/**
	 * 计算班级平均成绩
	 * @param examId
	 * @param classId
	 * @return
	 */
	public BigDecimal calcClassAvg(Integer examId , Integer classId) {
		List<Student> classStudents = studentDaoImpl.selectByClassId(classId);// 得到班级所有学生
		List<Score> sList = new ArrayList<Score>();// 保存所有参加考试学生的成绩
		for (Student student : classStudents) {
			Long id = student.getId();
			Score score = scoreDaoImpl.selectByExamIdAndStudentId(examId, id);
			if (score != null) { // 什么狗屎null = =
				sList.add(score);
			}
		}
		if (!sList.isEmpty()) {
			Integer n = sList.size();
			Integer a = 0;
			for(int i=0; i<sList.size();i++) {
				Integer score = sList.get(i).getScore();
				a = a + score;
				
			}
			
			double avg = a/n;
			BigDecimal bigDecimal = new BigDecimal(avg);
			bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			return bigDecimal;
		} else {
			return new BigDecimal(0);
		}
	}
	
	/**
	 * 计算年级平均分
	 * @param examId
	 * @return
	 */
	public BigDecimal calcGradeAvg(Integer examId) {
		List<Score> sList = scoreDaoImpl.selectByExamId(examId);
		
		if (!sList.isEmpty()) {
			Integer n = sList.size();
			Integer a = 0;
			for(int i=0; i<sList.size();i++) {
				Integer score = sList.get(i).getScore();
				a = a + score;
				
			}
			
			double avg = a/n;
			BigDecimal bigDecimal = new BigDecimal(avg);
			bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			return bigDecimal;
		} else {
			return new BigDecimal(0);
		}
	}
	
	public Integer countExcellentNum(Integer examId) {
		return scoreDaoImpl.countExcellentNum(examId);
	}
	
	public Integer countGoodNum(Integer examId) {
		return scoreDaoImpl.countGoodNum(examId);
	}
	
	public Integer countFairNum(Integer examId) {
		return scoreDaoImpl.countFairNum(examId);
	}
	
	public Integer countPassNum(Integer examId) {
		return scoreDaoImpl.countPassNum(examId);
	}
	
	public Integer countFailNum(Integer examId) {
		return scoreDaoImpl.countFailNum(examId);
	}
	
	/**
	 * 计算学生年级排名
	 * @param examId
	 * @param studentId
	 * @return
	 */
	public Integer calcGradeRank(Integer examId, Long studentId) {
		List<Score> scores = scoreDaoImpl.selectByExamId(examId);
		RankComparator comparator = new RankComparator();
		Collections.sort(scores,comparator); // 按照成绩进行排序
		Integer rank = null;
		for (int i = 0; i < scores.size(); i++) {
			Score score = scores.get(i);
			if (score.getStudentId().equals(studentId)) {
				rank = i+1;
			}
		}
		return rank;
	}
	
	/**
	 * 计算学生班级排名
	 * @param examId
	 * @param studentId
	 * @return
	 */
	public Integer calcClassRank(Integer examId, Long studentId) {
		Student s = studentDaoImpl.selectById(studentId);
		Integer classId = Integer.valueOf(s.getClassId());
		List<Student> classStudents = studentDaoImpl.selectByClassId(classId);// 得到班级所有学生
		List<Score> sList = new ArrayList<Score>();// 保存所有参加考试学生的成绩
		for (Student student : classStudents) {
			Long id = student.getId();
			Score score = scoreDaoImpl.selectByExamIdAndStudentId(examId, id);
			if (score != null) { 
				sList.add(score);
			}
		}
		RankComparator comparator = new RankComparator();
		Collections.sort(sList, comparator);
		
		Integer rank = null;
		for (int i = 0; i < sList.size(); i++) {
			Score score = sList.get(i);
			if (score.getStudentId().equals(studentId)) {
				rank = i+1;
			}
		}
		return rank;
	}
	
	/**
	 * 根据考试Id和学号查找成绩
	 * @param examId
	 * @param studentId
	 * @return
	 */
	public Score selectByExamIdAndStudentId(Integer examId, Long studentId) {
		return scoreDaoImpl.selectByExamIdAndStudentId(examId, studentId);
	}
}
