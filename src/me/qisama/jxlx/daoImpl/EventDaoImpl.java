package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.EventMapper;
import me.qisama.jxlx.entity.Event;
import me.qisama.jxlx.entity.EventExample;
import me.qisama.jxlx.entity.EventExample.Criteria;

@Repository
public class EventDaoImpl {

	@Autowired
	EventMapper eventMapper;

	
	public int create(Event event) {
		return eventMapper.insert(event);
	}
	
	public int delete(Integer id) {
		return eventMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Event event) {
		return eventMapper.updateByPrimaryKey(event);
	}
	
	public Event selectById(Integer id) {
		return eventMapper.selectByPrimaryKey(id);
	}
	
	public List<Event> selectByTitleKey(String titleKey) {
		EventExample eventExample = new EventExample();
		Criteria criteria = eventExample.createCriteria();
		criteria.andTitleLike("%"+titleKey+"%");
		List<Event> events = eventMapper.selectByExample(eventExample);
		return events;
	}
	
	public List<Event> findAll() {
		EventExample eventExample = new EventExample();
		List<Event> events = eventMapper.selectByExample(eventExample);
		return events;
	}

}
