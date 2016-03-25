package me.qisama.jxlx.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.ExamDaoImpl;
import me.qisama.jxlx.entity.Exam;
import me.qisama.jxlx.entity.Student;

@Service
public class ExamService {
	
	@Autowired
	private ExamDaoImpl examDaoImpl;
	
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
}
