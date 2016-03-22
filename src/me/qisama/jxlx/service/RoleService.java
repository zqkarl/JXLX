package me.qisama.jxlx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.qisama.jxlx.daoImpl.RoleDaoImpl;
import me.qisama.jxlx.daoImpl.RoleResourceDaoImpl;
import me.qisama.jxlx.entity.Resource;
import me.qisama.jxlx.entity.Role;
import me.qisama.jxlx.entity.RoleResource;
import me.qisama.jxlx.entity.TeacherRole;

@Service
public class RoleService {

	@Autowired
	private RoleDaoImpl roleDaoImpl;
	
	@Autowired
	private RoleResourceDaoImpl roleResourceDaoImpl;
	
	@Transactional
	public void create(Role role, String[] resourceIds){
		roleDaoImpl.create(role);
		Long roleId = role.getId();
		
		if (!"".equals(resourceIds)&&null!=resourceIds) {
			//String[] ids = resourceIds.split(",");
			for(String id : resourceIds){
				RoleResource roleResource = new RoleResource();
				roleResource.setRoleId(roleId);
				roleResource.setResourceId(Long.valueOf(id));
				
				roleResourceDaoImpl.create(roleResource);
			}
		}
	}
	
	@Transactional
	public void update(Role role, String[] resourceIds){
		roleDaoImpl.update(role);
		Long roleId = role.getId();
		
		//删除所有的记录
		List<RoleResource> roleResources = roleResourceDaoImpl.findByRoleId(roleId);
		for(RoleResource roleResource: roleResources) {
			roleResourceDaoImpl.delete(roleResource.getId());
		}
		
		//创建记录
		if (!"".equals(resourceIds)&&null!=resourceIds) {
			
			for(String id : resourceIds){
				RoleResource roleResource = new RoleResource();
				roleResource.setRoleId(roleId);
				roleResource.setResourceId(Long.valueOf(id));
				roleResourceDaoImpl.create(roleResource);
			}
		}
	}
	
	@Transactional
	public void delete(Long id){
		roleDaoImpl.delete(id);
		
		List<RoleResource> roleResources = roleResourceDaoImpl.findByRoleId(id);
		for(RoleResource roleResource: roleResources){
			Long roleResourceId = roleResource.getId();
			roleResourceDaoImpl.delete(roleResourceId);
		}
	}
	
	public Role selectById(Long id) {
		return roleDaoImpl.selectById(id);
	}
	
	public List<Role> findAll() {
		return roleDaoImpl.findAll();
	}
}
