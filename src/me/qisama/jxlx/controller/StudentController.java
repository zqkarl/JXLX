package me.qisama.jxlx.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.qisama.jxlx.bean.ResponseStatus;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClasseService classeService;
	
	private Log logger = LogFactory.getLog("System");
	
	@RequiresPermissions("student:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("studentList", studentService.findAll());
		model.addAttribute("classeList" , classeService.findAll());
		return "student/list";
	}
	
	@RequiresPermissions("student:action")
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(@RequestParam("studentId") Long id,
			@RequestParam("contactPhone") Integer contactPhone,
			HttpServletRequest request) {
		String studentName = request.getParameter("studentName");
		String classId = request.getParameter("classId");
		
		Student student = new Student();
		student.setId(id);
		student.setStudentName(studentName);
		student.setPassword("111111");// 默认初始密码为6个1
		student.setClassId(classId);
		student.setContactPhone(contactPhone);
		
		studentService.create(student);
		return "redirect:/student";
	}
	
	@RequiresPermissions("student:action")
	@RequestMapping(value="/update" , method = RequestMethod.POST)
	public String update(
			@RequestParam("studentId") Long id,
			@RequestParam("studentName") String studentName,
			@RequestParam("classId") String classId,
			@RequestParam("contactPhone") Integer contactPhone) {	
		
		Student student = studentService.selectById(id);
		student.setStudentName(studentName);
		student.setClassId(classId);
		student.setContactPhone(contactPhone);
		studentService.update(student);
		
		return "redirect:/student";
	}
	
	@ResponseBody
	@RequiresPermissions("student:view")
	@RequestMapping(value="/showUpdate", method = RequestMethod.POST)
	public Object showUpdate(
			@RequestParam("id") Long id) {
		Student student = studentService.selectById(id);
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(student);
		return responseStatus;
	}
	
}
