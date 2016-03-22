package me.qisama.jxlx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.GradeService;

/**
 * 对班级的操作（增删改查）
 * @author QISAMA
 * 2016年2月23日
 */
@Controller
@RequestMapping("/classe")
public class ClasseController {

	@Autowired
	ClasseService classeService;
	
	@Autowired
	GradeService gradeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("classeList" , classeService.findAll());
		return "classe/list";
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public String create(HttpServletRequest request) {
		String className = request.getParameter("className");
		String classDesc = request.getParameter("classDesc");
		String gradeId = request.getParameter("gradeId");
		Integer gradeIdint = Integer.valueOf(gradeId);
		
		Classe classe = new Classe();
		classe.setClassName(className);
		classe.setClassDesc(classDesc);
		classe.setGradeId(gradeIdint);
		
		classeService.create(classe);
		
		return "redirect:/classe";
	}
	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(@PathVariable("id") Integer id,HttpServletRequest request) {
		String className = request.getParameter("className");
		String classDesc = request.getParameter("classDesc");
		String gradeId = request.getParameter("gradeId");
		Integer gradeIdint = Integer.valueOf(gradeId);
		
		Classe classe = classeService.selectById(id);
		classe.setClassName(className);
		classe.setClassDesc(classDesc);
		classe.setGradeId(gradeIdint);
		
		classeService.update(classe);
		
		return "redirect:/classe";
	}
}
