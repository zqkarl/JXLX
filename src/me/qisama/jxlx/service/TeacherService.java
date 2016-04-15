package me.qisama.jxlx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.TeacherClassDaoImpl;
import me.qisama.jxlx.daoImpl.TeacherDaoImpl;
import me.qisama.jxlx.daoImpl.TeacherRoleDaoImpl;
import me.qisama.jxlx.entity.Role;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.entity.TeacherClass;
import me.qisama.jxlx.entity.TeacherRole;

@Service
public class TeacherService {

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	
	@Autowired
	private TeacherRoleDaoImpl teacherRoleDaoImpl;
	
	@Autowired
	private TeacherClassDaoImpl teacherClassDaoImpl;
	
	@Transactional
	public void create(Teacher teacher,String[] roleIds, Integer[] classes){
		//加密密码
        PasswordHelper.encryptPassword(teacher);
        teacherDaoImpl.create(teacher);
        Long teacherId = teacher.getId();
        
        // 添加老师角色信息
        if (null != roleIds && !"".equals(roleIds)) {
			for(String roleId : roleIds) {
				Long id = Long.valueOf(roleId);
				
				TeacherRole teacherRole = new TeacherRole();
				teacherRole.setTeacherId(teacherId);
				teacherRole.setRoleId(id);
				
				teacherRoleDaoImpl.create(teacherRole);
			}
		}
        
        // 添加教师班级信息
        if (null != classes && classes.length != 0) {
			for (Integer classId : classes) {
				TeacherClass teacherClass = new TeacherClass();
				teacherClass.setTeacherId(teacherId);
				teacherClass.setClassId(classId);
				
				teacherClassDaoImpl.create(teacherClass);
			}
		}
	}
	
	public void changePwd(Teacher teacher) {
		PasswordHelper.encryptPassword(teacher);
		teacherDaoImpl.updateSelective(teacher);
	}
	
	@Transactional
	public void update(Teacher teacher , String[] roleIds, Integer[] classes) {
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
		
		List<TeacherClass> teacherClasses = teacherClassDaoImpl.selectByTeacherId(teacherId);
		for (TeacherClass teacherClass : teacherClasses) {
			teacherClassDaoImpl.delete(teacherClass.getId());
		}
		
		if (null != classes && classes.length!=0) {
			for (Integer classId : classes) {
				TeacherClass teacherClass = new TeacherClass();
				teacherClass.setTeacherId(teacherId);
				teacherClass.setClassId(classId);
				
				teacherClassDaoImpl.create(teacherClass);
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
		
		// 删除所有班级教师关系
		List<TeacherClass> teacherClasses = teacherClassDaoImpl.selectByTeacherId(teacherId);
		for (TeacherClass teacherClass : teacherClasses) {
			teacherClassDaoImpl.delete(teacherClass.getId());
		}
	}
	
	public List<Teacher> selectByClassId(Integer classId) {
		List<TeacherClass> teacherClasses = teacherClassDaoImpl.selectByClassId(classId);
		List<Teacher> teachers = new ArrayList<>();
		for (TeacherClass teacherClasse : teacherClasses) {
			teachers.add(teacherDaoImpl.selectTeacherById(teacherClasse.getTeacherId()));
		}
		return teachers;
	}
	
	public List<Integer> selectClassIdsByTeacher(Long teacherId) {
		List<TeacherClass> teacherClasses = teacherClassDaoImpl.selectByTeacherId(teacherId);
		List<Integer> classIds = new ArrayList<>();
		for (TeacherClass teacherClasse : teacherClasses) {
			classIds.add(teacherClasse.getClassId());
		}
		return classIds;
	}
	
	public List<Teacher> findAll(){
		return teacherDaoImpl.findAll();
	}
	
}
