package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.ExamMapper;
import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.ExamExample;

@Repository
public class ExamDaoImpl {

	@Autowired
	private ExamMapper examMapper;
	
	public int create(Exam exam) {
		return examMapper.insert(exam);
	}
	
	public int delete(Integer id) {
		return examMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Exam exam) {
		return examMapper.updateByPrimaryKey(exam);
	}
	
	public Exam selectById(Integer id) {
		return examMapper.selectByPrimaryKey(id);
	}
	
	public List<Exam> findAll() {
		ExamExample examExample = new ExamExample();
		List<Exam> exams = examMapper.selectByExample(examExample);
		return exams;
		
	}
}
