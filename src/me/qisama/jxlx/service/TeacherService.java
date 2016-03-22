package me.qisama.jxlx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.TeacherDaoImpl;
import me.qisama.jxlx.daoImpl.TeacherRoleDaoImpl;
import me.qisama.jxlx.entity.Role;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.entity.TeacherRole;

@Service
public class TeacherService {

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	
	@Autowired
	private TeacherRoleDaoImpl teacherRoleDaoImpl;
	
	@Transactional
	public void create(Teacher teacher,String[] roleIds){
		//加密密码
        PasswordHelper.encryptPassword(teacher);
        teacherDaoImpl.create(teacher);
        Long teacherId = teacher.getId();
        
        if (null != roleIds && !"".equals(roleIds)) {
			for(String roleId : roleIds) {
				Long id = Long.valueOf(roleId);
				
				TeacherRole teacherRole = new TeacherRole();
				teacherRole.setTeacherId(teacherId);
				teacherRole.setRoleId(id);
				
				teacherRoleDaoImpl.create(teacherRole);
			}
		}
	}
	
	public void changePwd(Teacher teacher) {
		PasswordHelper.encryptPassword(teacher);
		teacherDaoImpl.updateSelective(teacher);
	}
	
	@Transactional
	public void update(Teacher teacher , String[] roleIds) {
		Long teacherId = teacher.getId();
		
		teacherDaoImpl.updateSelective(teacher);
		
		// 删除所有角色
		List<TeacherRole> teacherRoles = teacherRoleDaoImpl.selectByUserId(teacherId);
		for(TeacherRole teacherRole :teacherRoles) {
			teacherRoleDaoImpl.delete(teacherRole.getId());
		}
		
		// 创建角色
		if (null != roleIds || !"".equals(roleIds)) {
			for(String roleId : roleIds) {
				Long id = Long.valueOf(roleId);
				
				TeacherRole teacherRole = new TeacherRole();
				teacherRole.setTeacherId(teacherId);
				teacherRole.setRoleId(id);
				
				teacherRoleDaoImpl.create(teacherRole);
			}
		}
	}
	
	public Teacher selectTeacherById(Long id) {
		Teacher teacher = teacherDaoImpl.selectTeacherById(id);
		return teacher;
	}
	
	public List<Long> getRoleIdByUserId(Long id) {
		List<TeacherRole> roles = teacherRoleDaoImpl.selectByUserId(id);
		List<Long> roleIds = new ArrayList<Long>();
		for(TeacherRole role : roles) {
			roleIds.add(role.getRoleId());
		}
		
		return roleIds;
	}
	
	@Transactional
	public void delete(Long teacherId) {
		teacherDaoImpl.delete(teacherId);
		
		// 删除所有角色信息
		List<TeacherRole> teacherRoles = teacherRoleDaoImpl.selectByUserId(teacherId);
		for(TeacherRole teacherRole :teacherRoles) {
			teacherRoleDaoImpl.delete(teacherRole.getId());
		}
	}
	
	public List<Teacher> findAll(){
		return teacherDaoImpl.findAll();
	}
	
}
