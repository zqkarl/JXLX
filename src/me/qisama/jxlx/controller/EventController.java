package me.qisama.jxlx.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice.Info;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import me.qisama.jxlx.constant.CommonConstants;
import me.qisama.jxlx.entity.Download;
import me.qisama.jxlx.entity.Event;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.EventService;
import me.qisama.jxlx.service.FileService;
import me.qisama.jxlx.service.StudentService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	ClasseService classeService;
	
	@Autowired
	private StudentService studentService;
	
	private Log logger = LogFactory.getLog("System");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequiresPermissions("event:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("eventList", eventService.findAll());
		return "event/list";
	}

	@RequiresPermissions("event:view")
	@RequestMapping(value="/{id}/info" ,method = RequestMethod.GET)
	public String Info(@PathVariable("id") int id , Model model){
		Event event = eventService.selectById(id);
		model.addAttribute("event", event);
		return "event/info";
	}
	
	@RequiresPermissions("event:create")
	@RequestMapping(value="/add" ,method = RequestMethod.GET)
	public String createList(Model model) {
		model.addAttribute("classes", classeService.findAll());
		return "event/edit";
	}
	
	@RequiresPermissions("event:create")
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	public String create(@RequestParam("file") MultipartFile file ,HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String[] classes = request.getParameterValues("classes");
		
		// 获取当前操作用户
		Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
		String entryTeacherId = (String) session.getAttribute(CommonConstants.SESSION_USERID);
		Long entryTeacherIdInt = Long.valueOf(entryTeacherId);
		
		//上传文件
		String limitSuffix = ".zip,.rar,.7z";
		String attachmentId = fileService.upload(request, file ,limitSuffix);
		
		//当前时间
		String time = sdf.format(new Date());
		
		Event event = new Event();
		event.setTitle(title);
		event.setContent(content);
		event.setAttachmentId(attachmentId);
		event.setEntryTeacherId(entryTeacherIdInt);
		event.setEntryTime(time);
		
		try {
			eventService.create(event, classes);
			logger.info("新增活动:"+title+"成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("新增活动失败，失败原因"+e.getMessage());
		}
		return "redirect:/event";
	}
	
	@ResponseBody
	@RequiresPermissions("event:view")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String token = request.getParameter("token");
		
		response.setContentType("text/html;charset=utf-8");   
        request.setCharacterEncoding("UTF-8");   
        java.io.BufferedInputStream bis = null;   
        java.io.BufferedOutputStream bos = null;   
  
        Download download = eventService.download(token);
        String path = download.getDownloadPath();
        String fileName = download.getFileName();
        try {   
            long fileLength = new File(path).length();   
            response.setContentType("application/x-msdownload;");   
            response.setHeader("Content-disposition", "attachment; filename="  
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));   
            response.setHeader("Content-Length", String.valueOf(fileLength));   
            bis = new BufferedInputStream(new FileInputStream(path));   
            bos = new BufferedOutputStream(response.getOutputStream());   
            byte[] buff = new byte[2048];   
            int bytesRead;   
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {   
                bos.write(buff, 0, bytesRead);   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            if (bis != null)   
                bis.close();   
            if (bos != null)   
                bos.close();   
        }
		return "ok";
	}
	
	@RequiresPermissions("event:delete")
	@RequestMapping(value = "/{id}/delete" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		eventService.delete(id);
		return "redirect:/event";
	}
	
	@RequiresPermissions("event:view")
	@RequestMapping(value = "/search" , method = RequestMethod.POST)
	public String search(@RequestParam(value="fromDate",defaultValue="1971-1-1") String fromDate,
			@RequestParam(value="toDate", defaultValue="2100-1-1") String toDate,
			@RequestParam(value="titleKey", required = false) String titleKey,
			Model model
			) {
		fromDate = fromDate + " 00:00:00";
		toDate = toDate + " 23:59:59";
		Set<Event> events = eventService.search(fromDate, toDate, titleKey);
		model.addAttribute("eventList", events);
		return "event/list";
	}
	
	@RequestMapping(value="/student",method = RequestMethod.GET)
	public String studentList(Model model) {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		List<Event> events = new ArrayList<Event>();
		try {
			Student student = studentService.selectById(Long.valueOf(username));
			String classId = student.getClassId();
			events = eventService.getEventsByClassId(classId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("eventList", events);
		return "event/listS";
	}
}
