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
import me.qisama.jxlx.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	ResourceService resourceService;
	
	@RequiresPermissions("resource:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		 model.addAttribute("resourceList", resourceService.findAll());
		return "resource/list";
	}
	
//	@RequiresPermissions("resource:view")
//	@RequestMapping(value = "/showedit", method = RequestMethod.GET)
//	public String showEdit(){
//		return "resource/edit";
//	}
	
	@RequiresPermissions("resource:action")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(HttpServletRequest request) {
		String resourceName = request.getParameter("resourceName");
		String resourceDesc = request.getParameter("resourceDesc");
		String url = request.getParameter("url");
		String permission = request.getParameter("permission");
		
		Resource resource = new Resource();
		resource.setResourceName(resourceName);
		resource.setResourceDesc(resourceDesc);
		resource.setUrl(url);
		resource.setPermission(permission);
		
		resourceService.create(resource);
		
		return "redirect:/resource";
	}
	
	//@RequiresPermissions("resource:action")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String batchDelete(HttpServletRequest request) {
		String id = request.getParameter("ids");
		String[] ids = id.split(",");
		for(String a: ids){
			resourceService.delete(a);
		}
		
		return "redirect:/resource";
	}
	
	@RequiresPermissions("resource:action")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, HttpServletRequest request) {
		resourceService.delete(id);
		return "redirect:/resource";
	}
	
	@ResponseBody
	@RequiresPermissions("resource:view")
	@RequestMapping(value = "/showUpdate", method = RequestMethod.POST)
	public Object showUpdate(@RequestParam("id") Long id) {
		Resource resource = null;
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			resource = resourceService.selectById(id);
		} catch (Exception e) {
			// TODO: handle exception
			responseStatus.setStatus(-99);
			responseStatus.setMessage(e.getMessage());
			e.printStackTrace();
		}
		responseStatus.setData(resource);
		return responseStatus;
	}
	
	@RequiresPermissions("resource:action")
	@RequestMapping(value="/update" ,method = RequestMethod.POST)
	public String update(@RequestParam("id") Long id, HttpServletRequest request) {
		String resourceName = request.getParameter("resourceName");
		String resourceDesc = request.getParameter("resourceDesc");
		String url = request.getParameter("url");
		String permission = request.getParameter("permission");
		
		Resource resource = new Resource();
		resource.setId(id);
		resource.setResourceName(resourceName);
		resource.setResourceDesc(resourceDesc);
		resource.setUrl(url);
		resource.setPermission(permission);
		
		resourceService.update(resource);
		return "redirect:/resource";
	}
}
