package me.qisama.jxlx.daoImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.ResourceMapper;
import me.qisama.jxlx.entity.Resource;
import me.qisama.jxlx.entity.ResourceExample;
import me.qisama.jxlx.entity.ResourceExample.Criteria;

@Repository
public class ResourceDaoImpl {

	@Autowired
	ResourceMapper resourceMapper;
	
	public void create(Resource resource) {
		resourceMapper.insert(resource);
	}
	
	public void delete(Long id) {
		resourceMapper.deleteByPrimaryKey(id);
	}
	
	public void update(Resource resource) {
		resourceMapper.updateByPrimaryKey(resource);
	}
	
	public Resource selectById(Long id) {
		Resource resource = resourceMapper.selectByPrimaryKey(id);
		return resource;
	}
	
	public List<Resource> findAll() {
		ResourceExample resourceExample = new ResourceExample();
		List<Resource> resources = resourceMapper.selectByExample(resourceExample);
		return resources;
	}
	
	public Set<String> findPermissionsByRoleName(String roleName) {
		return resourceMapper.findPermissionsByRoleName(roleName);
	}
}
