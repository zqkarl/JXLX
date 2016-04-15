package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.TeacherClassMapper;
import me.qisama.jxlx.entity.TeacherClass;
import me.qisama.jxlx.entity.TeacherClassExample;
import me.qisama.jxlx.entity.TeacherClassExample.Criteria;

@Repository
public class TeacherClassDaoImpl {

	@Autowired
	private TeacherClassMapper teacherClassMapper;
	
	public int create(TeacherClass teacherClass) {
		return teacherClassMapper.insert(teacherClass);
	}
	
	public int update(TeacherClass teacherClass) {
		return teacherClassMapper.updateByPrimaryKey(teacherClass);
	}
	
	public int delete(Integer id) {
		return teacherClassMapper.deleteByPrimaryKey(id);
	}
	
	public TeacherClass selectById(Integer id) {
		return teacherClassMapper.selectByPrimaryKey(id);
	}
	
	public List<TeacherClass> findAll() {
		TeacherClassExample teacherClassExample = new TeacherClassExample();
		return teacherClassMapper.selectByExample(teacherClassExample);
	}
	
	public List<TeacherClass> selectByClassId(Integer classId) {
		TeacherClassExample teacherClassExample = new TeacherClassExample();
		Criteria criteria = teacherClassExample.createCriteria();
		criteria.andClassIdEqualTo(classId);
		return teacherClassMapper.selectByExample(teacherClassExample);
	}
	
	public List<TeacherClass> selectByTeacherId(Long teacherId) {
		TeacherClassExample teacherClassExample = new TeacherClassExample();
		Criteria criteria = teacherClassExample.createCriteria();
		criteria.andTeacherIdEqualTo(teacherId);
		return teacherClassMapper.selectByExample(teacherClassExample);
	}
}
