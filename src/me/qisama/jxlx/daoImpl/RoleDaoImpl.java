package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.RoleMapper;
import me.qisama.jxlx.entity.Role;
import me.qisama.jxlx.entity.RoleExample;
import me.qisama.jxlx.entity.RoleExample.Criteria;

@Repository
public class RoleDaoImpl {

	@Autowired
	RoleMapper roleMapper;
	
	public int create(Role role) {
		int id = roleMapper.insert(role);
		return id;
	}
	
	public void delete(Long id) {
		roleMapper.deleteByPrimaryKey(id);
	}
	
	public void update(Role role){
		roleMapper.updateByPrimaryKey(role);
	}
	
	public Role selectById(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}
	
	public List<Role> findAll(){
		RoleExample roleExample = new RoleExample();
		Criteria criteria = roleExample.createCriteria();
		criteria.andIdIsNotNull();
		List<Role> roles = roleMapper.selectByExample(roleExample);
		return roles;
	}
}
