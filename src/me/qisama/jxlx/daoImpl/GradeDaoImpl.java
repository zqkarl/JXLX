package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.GradeMapper;
import me.qisama.jxlx.entity.Grade;
import me.qisama.jxlx.entity.GradeExample;

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
	
	public Grade selectById(Integer id) {
		return gradeMapper.selectByPrimaryKey(id);
	}
	
	public List<Grade> findAll() {
		GradeExample gradeExample = new GradeExample();
		return gradeMapper.selectByExample(gradeExample);
	}
}
