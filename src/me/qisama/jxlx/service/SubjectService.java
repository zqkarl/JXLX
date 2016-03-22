package me.qisama.jxlx.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.SubjectDaoImpl;
import me.qisama.jxlx.entity.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDaoImpl subjectDaoImpl;
	
	private Log logger = LogFactory.getLog("System");
	
	public void create(Subject subject) {
		subjectDaoImpl.create(subject);
		logger.info(" 创建科目"+subject.getSubjectName());
	}
	
	@Transactional
	public void delete(int id){
		Subject subject = subjectDaoImpl.selectById(id);
		subjectDaoImpl.delete(id);
		logger.info(" 删除科目"+subject.getSubjectName());
	}
	
	public void update(Subject subject) {
		subjectDaoImpl.update(subject);
		logger.info(" 更新科目"+subject.getSubjectName());
	}
	
	public Subject selectById(Integer id) {
		return subjectDaoImpl.selectById(id);
	}
	
	public List<Subject> findAll() {
		return subjectDaoImpl.findAll();
	}
}
