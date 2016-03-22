package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.TeacherRoleMapper;
import me.qisama.jxlx.entity.TeacherRole;
import me.qisama.jxlx.entity.TeacherRoleExample;
import me.qisama.jxlx.entity.TeacherRoleExample.Criteria;

@Repository
public class TeacherRoleDaoImpl {
	
	@Autowired
	TeacherRoleMapper teacherRoleMapper;
	
	public void create(TeacherRole teacherRole) {
		teacherRoleMapper.insert(teacherRole);
	}
	
	public void delete(Long id) {
		teacherRoleMapper.deleteByPrimaryKey(id);
	}
	
	public List<TeacherRole> selectByUserId(Long userId) {
		TeacherRoleExample teacherRoleExample = new TeacherRoleExample();
		Criteria criteria = teacherRoleExample.createCriteria();
		criteria.andTeacherIdEqualTo(userId);
		List<TeacherRole> teacherRoles = teacherRoleMapper.selectByExample(teacherRoleExample);
		return teacherRoles;
	}
	
}
