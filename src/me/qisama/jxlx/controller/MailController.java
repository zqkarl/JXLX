package me.qisama.jxlx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.qisama.jxlx.bean.ResponseStatus;
import me.qisama.jxlx.constant.CommonConstants;
import me.qisama.jxlx.entity.Mail;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.entity.TeacherClass;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.MailService;
import me.qisama.jxlx.service.StudentService;
import me.qisama.jxlx.service.TeacherService;
import me.qisama.jxlx.util.Utils;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@Autowired
	private ClasseService classeService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long toId = Long.valueOf(username); // 获取当前发送用户
		
		List<Mail> mails = mailService.selectByToId(toId);
		model.addAttribute("mailList", mails);
		
		return "mail/list";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam(value="time", required = false) String time ,
			@RequestParam(value="title", required = false) String title,
			Model model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long id = Long.valueOf(username); // 获取当前发送用户
		
		List<Mail> mails = mailService.search(id, time, title);
		model.addAttribute("mailList", mails);
		
		return "mail/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/top3")
	public Object listTop3() {
		
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long id = Long.valueOf(username); // 获取当前用户
		
		int unreadNum = mailService.countUnread(id);
		List<Mail> unreads = mailService.selectByToId(id);
		if (unreads.size()>3) {
			unreads = unreads.subList(0, 3);
		}
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(unreads);
		responseStatus.setData2(unreadNum);
		
		return responseStatus;
	}
	
	@ResponseBody
	@RequestMapping(value="/count")
	public Object countUnread() {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long id = Long.valueOf(username); // 获取当前用户
		
		Integer num = mailService.countUnread(id);
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(num);
		return responseStatus;
	}
	
	@RequestMapping(value="/read/{id}", method=RequestMethod.GET)
	public String read(@PathVariable("id") Integer id,Model model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long user = Long.valueOf(username); // 获取当前用户
		
		Mail mail = mailService.read(id);
		model.addAttribute("mail", mail);
		
		if (user.equals(mail.getFromId()) || user.equals(mail.getToId())) {
			mail.setIsread(true);
			mailService.updateSelective(mail);
			return "mail/detail";
		} else {
			return "unauthorized";
		}
	}
	
	@RequestMapping(value="/send", method=RequestMethod.GET)
	public String showSend(Model model) {
		model.addAttribute("classList", classeService.findAll());
		return "mail/send";
	}
	
	@RequestMapping(value="/sendstd", method=RequestMethod.GET)
	public String showSendStd(Model model) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long id = Long.valueOf(username); // 获取当前用户
		Student student = studentService.selectById(id);
		Integer classId = Integer.valueOf(student.getClassId());
		List<Teacher> teachers = teacherService.selectByClassId(classId);
		model.addAttribute("teacherList", teachers);
		return "mail/sendS";
	}
	
	/**
	 * 发信
	 * @param toId
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String send(@RequestParam("toId") Long[] toId,
			@RequestParam("title") String title,
			@RequestParam("content") String content) {
		
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		Long fromId = Long.valueOf(username); // 获取当前发送用户
		
		for (Long id : toId) {
			Mail mail = new Mail();
			
			// 设置邮件类型
			Integer source = 0; 
			if (SecurityUtils.getSubject().hasRole("家长")) {
				source = CommonConstants.MAIL_PARENT_TO_TEACHER;
			} else {
				source = CommonConstants.MAIL_TEACHER_TO_PARENT;
			}
			mail.setSource(source);
			
			mail.setFromId(fromId);
			
			mail.setToId(id);
			
			mail.setTitle(Utils.escape(title));
			
			mail.setContent(Utils.escape(content));
			
			// 设置发送时间
			String time = sdf.format(new Date());
			mail.setTime(time);
			
			mail.setIsread(false);// 未读
			
			mailService.create(mail);
			
			
		}
		return "mail/success";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/selectStd")
	public Object selectStd(@RequestParam("classId") Integer classId) {
		List<Student> students = studentService.selectByClassId(classId);
		ResponseStatus status = new ResponseStatus();
		status.setData(students);
		return status;
	}
	
	@ResponseBody
	@RequestMapping(value="/name")
	public Object transName(@RequestParam("id") Long id) {
		String name = mailService.transName(id);
		ResponseStatus status = new ResponseStatus();
		status.setData(name);
		return status;
	}
}
