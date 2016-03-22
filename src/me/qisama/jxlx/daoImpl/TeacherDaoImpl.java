package me.qisama.jxlx.daoImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.TeacherMapper;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.entity.TeacherExample;
import me.qisama.jxlx.entity.TeacherExample.Criteria;

@Repository
public class TeacherDaoImpl {

	@Autowired
	TeacherMapper teacherMapper;
	
	public Teacher selectTeacherById(String id){
		Long idLong = 0l;
		Teacher teacher = null;
		if (!("".equals(id) || null == id)) {
			idLong = Long.valueOf(id);
			teacher = teacherMapper.selectByPrimaryKey(idLong);
		}
		return teacher;
	}
	
	public Teacher selectTeacherById(Long id) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
		return teacher;
	}
	
	public Set<String> findPermissions(String id){
		Long idLong = 0l;
		if (!("".equals(id) || null == id)) {
			idLong = Long.valueOf(id);
		}
		return teacherMapper.findPermissions(idLong);
	}
	
	public Set<String> findRoles(String id){
		Long idLong = 0l;
		if (!id.isEmpty()) {
			idLong = Long.valueOf(id);
		}
		//System.out.println(idLong+"MAPPER:"+teacherMapper.findRoles(idLong));
		return teacherMapper.findRoles(idLong);
	}
	
	public void create(Teacher teacher) {
		teacherMapper.insert(teacher);
	}
	
	public void delete(Long id){
		teacherMapper.deleteByPrimaryKey(id);
	}
	
	public void update(Teacher teacher) {
		teacherMapper.updateByPrimaryKey(teacher);
	}
	
	public void updateSelective(Teacher teacher){
		teacherMapper.updateByPrimaryKeySelective(teacher);
	}
	
	public List<Teacher> findAll(){
		TeacherExample teacherExample = new TeacherExample();
		Criteria criteria = teacherExample.createCriteria();
		criteria.andIdIsNotNull();
		List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
		return teachers;
	}
	
}
