package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.ClasseMapper;
import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.entity.ClasseExample;
import me.qisama.jxlx.entity.ClasseExample.Criteria;

@Repository
public class ClasseDaoImpl {

	@Autowired
	ClasseMapper classeMapper;
	
	public void create(Classe classe) {
		classeMapper.insert(classe);
	}
	
	public void update(Classe classe) {
		classeMapper.updateByPrimaryKey(classe);
	}
	
	public void delete(Integer id) {
		classeMapper.deleteByPrimaryKey(id);
	}
	
	public Classe selectById(int id) {
		return classeMapper.selectByPrimaryKey(id);
	}
	
	public List<Classe> findAll(){
		ClasseExample classeExample = new ClasseExample();
		List<Classe> classes = classeMapper.selectByExample(classeExample);
		return classes;
	}
	
	public List<Classe> selectByGradeId(Integer gradeId) {
		ClasseExample classeExample = new ClasseExample();
		Criteria criteria = classeExample.createCriteria();
		criteria.andGradeIdEqualTo(gradeId);
		List<Classe> classes = classeMapper.selectByExample(classeExample);
		return classes;
	}
}
