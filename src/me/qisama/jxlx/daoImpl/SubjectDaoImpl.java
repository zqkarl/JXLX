package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.SubjectMapper;
import me.qisama.jxlx.entity.Subject;
import me.qisama.jxlx.entity.SubjectExample;

@Repository
public class SubjectDaoImpl {

	@Autowired
	SubjectMapper subjectMapper;
	
	public int create(Subject subject) {
		return subjectMapper.insert(subject);
	}
	
	public int delete(int id) {
		return subjectMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Subject subject) {
		return subjectMapper.updateByPrimaryKey(subject);
	}
	
	public Subject selectById(int id) {
		return subjectMapper.selectByPrimaryKey(id);
	}
	
	public List<Subject> findAll() {
		SubjectExample subjectExample = new SubjectExample();
		List<Subject> subjects = subjectMapper.selectByExample(subjectExample);
		return subjects;
	}

}
