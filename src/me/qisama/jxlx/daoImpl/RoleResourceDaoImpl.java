package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.RoleResourceMapper;
import me.qisama.jxlx.entity.RoleResource;
import me.qisama.jxlx.entity.RoleResourceExample;
import me.qisama.jxlx.entity.RoleResourceExample.Criteria;

@Repository
public class RoleResourceDaoImpl {

	@Autowired
	RoleResourceMapper roleResourceMapper;
	
	public void create(RoleResource roleResource){
		roleResourceMapper.insert(roleResource);
	}
	
	public void delete(Long id) {
		roleResourceMapper.deleteByPrimaryKey(id);
	}
	
	public List<RoleResource> findByRoleId(Long roleId) {
		RoleResourceExample roleResourceExample = new RoleResourceExample();
		Criteria criteria = roleResourceExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<RoleResource> roleResources = roleResourceMapper.selectByExample(roleResourceExample);
		return roleResources;
	}
	
}
