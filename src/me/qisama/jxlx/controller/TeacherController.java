package me.qisama.jxlx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.qisama.jxlx.bean.ResponseStatus;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.service.RoleService;
import me.qisama.jxlx.service.SubjectService;
import me.qisama.jxlx.service.TeacherService;

@Controller
@RequestMapping("/user")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequiresPermissions("teacher:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("userList", teacherService.findAll());
		model.addAttribute("roleList", roleService.findAll());
		model.addAttribute("subjectList", subjectService.findAll());
		return "user/list";
	}
	
//	@RequestMapping(value = "/add" , method = RequestMethod.GET)
//	public String showAddList(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
//		model.addAttribute("op", "add");
//		return "user/edit";
//	}
	
	@RequiresPermissions("teacher:action")
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String create(@RequestParam(value="subjectId", required=false) Integer subjectId ,Model model,HttpServletRequest request) {
		String id = request.getParameter("id"); // 工号长度必须大于6且为数字，不能超过12位
		Long idLong = Long.valueOf(id);
		String teacherName = request.getParameter("teacherName");
		String[] roleIds = request.getParameterValues("roleIds");
		
		int length = id.length();
		String password = id.substring(length-6, length); // 教师默认密码取工号后六位
		
		Teacher teacher = new Teacher();
		teacher.setId(idLong);
		teacher.setTeacherName(teacherName);
		teacher.setSubjectId(subjectId);
		teacher.setPassword(password);
		
		teacherService.create(teacher, roleIds);
		
		return "redirect:/user";
	}
	
	@RequiresPermissions("teacher:view")
	@RequestMapping(value = "/{id}/update" , method = RequestMethod.GET)
	public String showUpdateList(@PathVariable("id") Long id ,Model model, HttpServletRequest request) {
		model.addAttribute("user",teacherService.selectTeacherById(id));
		model.addAttribute("roleList", roleService.findAll());
		model.addAttribute("checkId",teacherService.getRoleIdByUserId(id));
		model.addAttribute("op", id+"/update");
		return "user/edit";
	}
	
	@ResponseBody
	@RequiresPermissions("teacher:view")
	@RequestMapping(value="/showUpdate" , method = RequestMethod.POST)
	public Object showUpdate(@RequestParam(value="id", defaultValue="0") Long id) {
		Teacher teacher = teacherService.selectTeacherById(id);
		List<Long> checkIds = teacherService.getRoleIdByUserId(id);
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setData(teacher);
		responseStatus.setData2(checkIds);
		return responseStatus;
	}
	
	@RequiresPermissions("teacher:action")
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String update(@RequestParam("id") Long id ,Model model, HttpServletRequest request) {
		String[] roleIds = request.getParameterValues("roleIds");
		String teacherName = request.getParameter("teacherName");
		String password = request.getParameter("password");
		String subjectId = request.getParameter("subjectId");
		
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setTeacherName(teacherName);
		teacher.setSubjectId(Integer.valueOf(subjectId));
		
		if (!"".equals("password") && null!=password) {
			teacher.setPassword(password);
			teacherService.changePwd(teacher);
		}
		
		teacherService.update(teacher, roleIds);
		
		return "redirect:/user";
	}
	
	@RequiresPermissions("teacher:action")
	@RequestMapping(value = "/{id}/delete" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long teacherId,Model model ) {
		teacherService.delete(teacherId);
		return "redirect:/user";
	}
	
}
