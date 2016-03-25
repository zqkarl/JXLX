package me.qisama.jxlx.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.qisama.jxlx.daoImpl.ClassEventDaoImpl;
import me.qisama.jxlx.daoImpl.ClasseDaoImpl;
import me.qisama.jxlx.daoImpl.DownloadDaoImpl;
import me.qisama.jxlx.daoImpl.EventDaoImpl;
import me.qisama.jxlx.entity.ClassEvent;
import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.entity.Download;
import me.qisama.jxlx.entity.Event;

@Service
public class EventService {

	@Autowired
	private EventDaoImpl eventDaoImpl;
	
	@Autowired
	private ClassEventDaoImpl classEventDaoImpl;
	
	@Autowired
	private ClasseDaoImpl classeDaoImpl;
	
	@Autowired
	private DownloadDaoImpl downloadDaoImpl;
	
	private Log logger = LogFactory.getLog("System");
	
	@Transactional
	public void create(Event event, String[] classes) throws Exception{
		eventDaoImpl.create(event);
		Integer eventId = event.getId();
		if (1 == eventId) {
			logger.error("【警告】Mapper有可能出错，请检查！");
		}
		
		// 插入活动与班级的关系
		for (String c : classes) {
			ClassEvent classEvent = new ClassEvent();
			Integer classId = Integer.valueOf(c);
			classEvent.setClassId(classId);
			classEvent.setEventId(eventId);
			classEventDaoImpl.create(classEvent);
		}
	}
	
	@Transactional
	public Event selectById(Integer id) {
		return eventDaoImpl.selectById(id);
	}
	
	@Transactional
	public void delete(int id) {
		List<ClassEvent> classEvents = classEventDaoImpl.selectByEventId(id);
		for (ClassEvent classEvent : classEvents) {
			classEventDaoImpl.delete(classEvent.getId());
		}
		String event = eventDaoImpl.selectById(id).getTitle();
		eventDaoImpl.delete(id);
		logger.info("删除活动: "+event);
	}
	
	public List<Event> findAll(){
		return eventDaoImpl.findAll();
	}
	
	public Set<Event> search(String fromDate, String toDate, String titleKey) {
		List<Event> events = eventDaoImpl.selectByTitleKey(titleKey);
		Set<Event> eventsSet = new HashSet<Event>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date fromDateD = sdf.parse(fromDate);
			Date toDateD = sdf.parse(toDate);
			for (Event event : events) {
				Date date = sdf.parse(event.getEntryTime());
				if (date.after(fromDateD) && date.before(toDateD)) {
					eventsSet.add(event);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventsSet;
	}
	
	public Download download(String token){
		Download download = downloadDaoImpl.getPath(token);
		return download;
	}
	
	public List<Event> getEventsByClassId(String classId) {
		Integer id = 0;
		if (classId!=null && !classId.isEmpty()) {
			id = Integer.valueOf(classId);
		}
		List<ClassEvent> classEvents = classEventDaoImpl.selectByClassId(id);
		List<Event> events = new ArrayList<Event>();
		for (ClassEvent classEvent : classEvents) {
			Event event = selectById(classEvent.getEventId());
			events.add(event);
		}
		return events;
	}
}
