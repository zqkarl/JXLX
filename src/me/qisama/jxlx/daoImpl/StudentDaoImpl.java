package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.StudentMapper;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.StudentExample;
import me.qisama.jxlx.entity.StudentExample.Criteria;

@Repository
public class StudentDaoImpl {

	@Autowired
	StudentMapper studentMapper;
	
	public int create(Student student) {
		return studentMapper.insert(student);
	}
	
	public int delete(Long id) {
		return studentMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Student student) {
		return studentMapper.updateByPrimaryKey(student);
	}
	
	public List<Student> findAll() {
		StudentExample studentExample = new StudentExample();
//		Criteria criteria = studentExample.createCriteria();
		List<Student> students = studentMapper.selectByExample(studentExample);
		return students;
	}
	
	public Student selectById(Long id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	
	public List<Student> selectByClassId(Integer classId) {
		StudentExample studentExample = new StudentExample();
		Criteria criteria = studentExample.createCriteria();
		criteria.andClassIdEqualTo(classId.toString());
		return studentMapper.selectByExample(studentExample);
	}
}
