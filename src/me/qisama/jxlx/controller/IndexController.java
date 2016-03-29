package me.qisama.jxlx.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/")
	public String index(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.hasRole("家长")) {
			return "redirect:/score/student";
		} else {
			return "redirect:/score/teacher";
		}
	}
}
