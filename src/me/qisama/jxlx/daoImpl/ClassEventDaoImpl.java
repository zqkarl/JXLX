package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.ClassEventMapper;
import me.qisama.jxlx.entity.ClassEvent;
import me.qisama.jxlx.entity.ClassEventExample;
import me.qisama.jxlx.entity.ClassEventExample.Criteria;

@Repository
public class ClassEventDaoImpl {

	@Autowired
	ClassEventMapper classEventMapper;
	
	public int create(ClassEvent classEvent) {
		return classEventMapper.insert(classEvent);
	}
	
	public int delete(int id) {
		return classEventMapper.deleteByPrimaryKey(id);
	}
	
	public int update(ClassEvent classEvent) {
		return classEventMapper.updateByPrimaryKey(classEvent);
	}
	
	public List<ClassEvent> selectByEventId(Integer eventId) {
		ClassEventExample classEventExample = new ClassEventExample();
		Criteria criteria = classEventExample.createCriteria();
		criteria.andEventIdEqualTo(eventId);
		List<ClassEvent> classEvents = classEventMapper.selectByExample(classEventExample);
		return classEvents;
	}
	
	public List<ClassEvent> selectByClassId(Integer classId) {
		ClassEventExample classEventExample = new ClassEventExample();
		Criteria criteria = classEventExample.createCriteria();
		criteria.andClassIdEqualTo(classId);
		List<ClassEvent> classEvents = classEventMapper.selectByExample(classEventExample);
		return classEvents;
	}
}
