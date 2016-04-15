package me.qisama.jxlx.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.MailDaoImpl;
import me.qisama.jxlx.daoImpl.StudentDaoImpl;
import me.qisama.jxlx.daoImpl.TeacherDaoImpl;
import me.qisama.jxlx.entity.Mail;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;

@Service
public class MailService {

	@Autowired
	private MailDaoImpl mailDaoImpl;
	
	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public int create(Mail mail) {
		return mailDaoImpl.create(mail);
	}
	
	public int del(Integer id) {
		return mailDaoImpl.delete(id);
	}
	
	public int update(Mail mail) {
		return mailDaoImpl.update(mail);
	}
	
	public int updateSelective(Mail mail) {
		return mailDaoImpl.updateSelective(mail);
	}
	
	public List<Mail> selectByToId(Long toId) {
		return mailDaoImpl.selectByToId(toId);
	}
	
	public int countUnread(Long id) {
		return mailDaoImpl.countUnread(id);
	}
	
	public Mail read(Integer id){
		Mail mail = mailDaoImpl.selectById(id);
		mail.setIsread(true);
		updateSelective(mail);
		return mail;
	}
	
	/**
	 * 查询
	 * @param time
	 * @param title
	 * @return
	 */
	public List<Mail> search(Long id, String time, String title){
		String fromTime = null;
		String toTime = null;
		if (!"".equals(time)&& time != null) {
			fromTime = time + " 00:00:00";
			toTime = time + " 23:59:59";
			
		}
		List<Mail> mails = mailDaoImpl.selectBytimeAndtitle(id, fromTime, toTime, title);
		return mails;
	}
	
	public String transName(Long id) {
		String name = "";
		Teacher teacher = teacherDaoImpl.selectTeacherById(id);
		if (teacher != null) {
			name = teacher.getTeacherName();
		} else {
			Student student = studentDaoImpl.selectById(id);
			name = student.getStudentName()+"的家长";
		}
		return name;
	}
}
