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
import me.qisama.jxlx.entity.Role;
import me.qisama.jxlx.service.ResourceService;
import me.qisama.jxlx.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
    private ResourceService resourceService;
	
	@RequiresPermissions("role:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("resourceList", resourceService.findAll());
        return "role/list";
    }
	
//	//@RequiresPermissions("role:action")
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String showEdit(Model model) {
//		model.addAttribute("resourceList", resourceService.findAll());
//		model.addAttribute("op", "add");
//		return "role/edit";
//	}
	
	@RequiresPermissions("role:action")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("states") Boolean states ,HttpServletRequest request) {
		String roleName = request.getParameter("role");
		String roleDesc = request.getParameter("roleDesc");
		//String resourceIds = request.getParameter("resourceIds");
		String[] resourceIds = request.getParameterValues("resourceIds");
		
		Role role = new Role();
		role.setRole(roleName);
		role.setRoleDesc(roleDesc);
		role.setStates(states);
		
		roleService.create(role, resourceIds);
		return "redirect:/role";
	}
	
	@RequiresPermissions("role:view")
	@ResponseBody
	@RequestMapping(value = "/showUpdate", method = RequestMethod.POST)
	public Object showUpdate(@RequestParam("id") Long id, Model model) {
		Role role = roleService.selectById(id);
		//model.addAttribute("checkId",resourceService.getResourceIdsByRoleId(id));
		ResponseStatus responseStatus = new ResponseStatus();
		StringBuffer a = new StringBuffer("[");
		List<Long> resourceIds = resourceService.getResourceIdsByRoleId(id);
		for (Long long1 : resourceIds) {
			a.append(long1).append(",");
		}
		a.append("]");
		responseStatus.setData2(a);
		responseStatus.setData(role);
		return responseStatus;
	}
	
	@RequiresPermissions("role:action")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("id") Long id, @RequestParam("states") Boolean states, Model model,HttpServletRequest request) {
		String[] resourceIds = request.getParameterValues("resourceIds");
		String roleName = request.getParameter("role");
		String roleDesc = request.getParameter("roleDesc");
		
		Role role = new Role();
		role.setId(id);
		role.setRole(roleName);
		role.setRoleDesc(roleDesc);
		role.setStates(states);
		
		roleService.update(role, resourceIds);
		
		return "redirect:/role";
	}
	
	@RequiresPermissions("role:action")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		roleService.delete(id);
		return "redirect:/role";
	}
}
