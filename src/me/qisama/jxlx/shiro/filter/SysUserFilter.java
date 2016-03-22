package me.qisama.jxlx.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import me.qisama.jxlx.constant.CommonConstants;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.service.StudentService;
import me.qisama.jxlx.service.TeacherService;

public class SysUserFilter extends PathMatchingFilter {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	private Log logger = LogFactory.getLog("System");
	
	@Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(CommonConstants.SESSION_USERID, username);
        Teacher teacher = new Teacher();
        teacher.setTeacherName("未知用户");
        try {
			Long idLong = Long.valueOf(username);
			teacher = teacherService.selectTeacherById(idLong);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("转换用户名出错，登录的用户ID为"+username);
		}
        request.setAttribute(CommonConstants.CURRENT_USER, teacher);
        
        Student student = new Student();
        try {
			student = studentService.selectById(Long.valueOf(username));
		} catch (Exception e) {
			// TODO: handle exception
		}
        request.setAttribute(CommonConstants.CURRENT_STUDENT, student);
        return true;
    }
}
