package me.qisama.jxlx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.ResourceDaoImpl;
import me.qisama.jxlx.daoImpl.RoleResourceDaoImpl;
import me.qisama.jxlx.entity.Resource;
import me.qisama.jxlx.entity.RoleResource;

@Service
public class ResourceService {

	@Autowired
	ResourceDaoImpl resourceDaoImpl;
	
	@Autowired
	RoleResourceDaoImpl roleResourceDaoImpl;
	
	public void create(Resource resource) {
		resourceDaoImpl.create(resource);
	}
	
	public void delete(String id) {
		Long idLong = Long.valueOf(id);
		resourceDaoImpl.delete(idLong);
	}
	
	public void update(Resource resource) {
		resourceDaoImpl.update(resource);
	}
	
	public List<Resource> findAll() {
		return resourceDaoImpl.findAll();
	}
	
	public Resource selectById(Long id) {
		return resourceDaoImpl.selectById(id);
	}
	
	public List<Long> getResourceIdsByRoleId(Long roleId) {
		List<RoleResource> roleResources = roleResourceDaoImpl.findByRoleId(roleId);
		List<Long> resources = new ArrayList<Long>();
		for(RoleResource roleResource : roleResources) {
			resources.add(roleResource.getResourceId());
		}
		return resources;
	}
	
}
