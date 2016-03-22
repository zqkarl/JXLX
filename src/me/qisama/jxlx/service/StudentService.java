package me.qisama.jxlx.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.StudentDaoImpl;
import me.qisama.jxlx.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	private Log logger = LogFactory.getLog("System");
	
	public void create(Student student) {
		//加密密码
        PasswordHelper.encryptPasswordS(student);
        studentDaoImpl.create(student);
        logger.info("成功创建学生"+student.getStudentName());
	}
	
	public List<Student> findAll() {
		return studentDaoImpl.findAll();
	}
	
	public int update(Student student) {
		return studentDaoImpl.update(student);
	}
	
	public Student selectById(Long id){
		return studentDaoImpl.selectById(id);
	}
}
