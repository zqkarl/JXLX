package me.qisama.jxlx.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.GradeMapper;
import me.qisama.jxlx.entity.Grade;

@Repository
public class GradeDaoImpl {

	@Autowired
	GradeMapper gradeMapper;
	
	public int create(Grade grade) {
		return gradeMapper.insert(grade);
	}
	
	public int update(Grade grade) {
		return gradeMapper.updateByPrimaryKey(grade);
	}
	
	public int delete(int id) {
		return gradeMapper.deleteByPrimaryKey(id);
	}
}
