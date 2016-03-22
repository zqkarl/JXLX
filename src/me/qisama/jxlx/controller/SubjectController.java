package me.qisama.jxlx.controller;

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
import me.qisama.jxlx.entity.Resource;
import me.qisama.jxlx.entity.Subject;
import me.qisama.jxlx.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequiresPermissions("subject:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("subjectList", subjectService.findAll());
		return "subject/list";
	}
	
	@RequiresPermissions("subject:action")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) {
		String subjectName = request.getParameter("subjectName");
		String subjectDesc = request.getParameter("subjectDesc");
		
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject.setSubjectDesc(subjectDesc);
		
		subjectService.create(subject);
		
		return "redirect:/subject";
	}
	
	@RequiresPermissions("subject:action")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, HttpServletRequest request) {
		subjectService.delete(id);
		return "redirect:/subject";
	}
	
	@ResponseBody
	@RequiresPermissions("subject:view")
	@RequestMapping(value = "/showUpdate", method = RequestMethod.POST)
	public Object showUpdate(@RequestParam("id") Integer id) {
		Subject subject = null;
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			subject = subjectService.selectById(id);
		} catch (Exception e) {
			// TODO: handle exception
			responseStatus.setStatus(-99);
			responseStatus.setMessage(e.getMessage());
			e.printStackTrace();
		}
		responseStatus.setData(subject);
		return responseStatus;
	}
	
	@RequiresPermissions("subject:action")
	@RequestMapping(value="/update" ,method = RequestMethod.POST)
	public String update(@RequestParam("id") Integer id, HttpServletRequest request) {
		String subjectName = request.getParameter("subjectName");
		String subjectDesc = request.getParameter("subjectDesc");
		
		Subject subject = new Subject();
		subject.setId(id);
		subject.setSubjectName(subjectName);
		subject.setSubjectDesc(subjectDesc);
		
		subjectService.update(subject);
		
		return "redirect:/subject";
	}
}
