package me.qisama.jxlx.taglib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.entity.Download;
import me.qisama.jxlx.entity.Grade;
import me.qisama.jxlx.entity.Student;
import me.qisama.jxlx.entity.Subject;
import me.qisama.jxlx.entity.Teacher;
import me.qisama.jxlx.service.ClasseService;
import me.qisama.jxlx.service.EventService;
import me.qisama.jxlx.service.GradeService;
import me.qisama.jxlx.service.StudentService;
import me.qisama.jxlx.service.SubjectService;
import me.qisama.jxlx.service.TeacherService;
import me.qisama.jxlx.spring.SpringUtils;

@Repository
public class Functions {
	
	private static ClasseService classeService;
	
	private static EventService eventService;
	
	private static TeacherService teacherService;
	
	private static SubjectService subjectService;
	
	private static GradeService gradeService;
	
	private static StudentService studentService;
	
	public static StudentService getStudentService() {
		if (studentService == null) {
			studentService = SpringUtils.getBean(StudentService.class);
		}
		return studentService;
	}
	
	public static ClasseService getClasseService() {
		if (classeService == null) {
			classeService = SpringUtils.getBean(ClasseService.class);
		}
		return classeService;
	}
	
	public static EventService getEventService() {
		if (eventService == null) {
			eventService = SpringUtils.getBean(EventService.class);
		}
		return eventService;
	}
	
	public static TeacherService getTeacherService() {
		if (teacherService == null) {
			teacherService = SpringUtils.getBean(TeacherService.class);
		}
		return teacherService;
	}
	
	public static SubjectService getSubjectService() {
		if (subjectService == null) {
			subjectService = SpringUtils.getBean(SubjectService.class);
		}
		return subjectService;
	}
	
	public static GradeService getGradeService() {
		if (gradeService == null) {
			gradeService = SpringUtils.getBean(GradeService.class);
		}
		return gradeService;
	}

	/**
	 * 将班级Id转换为班级名称
	 * @param id
	 * @return
	 */
	public static String className(Integer id) {
		String className = "";
		try {
			Classe classe = getClasseService().selectById(id);
			className = classe.getClassName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return className;
	}
	
	/**
	 * 根据下载token转换为附件名称
	 * @param token
	 * @return
	 */
	public static String downloadName(String token) {
		String downloadName = "";
		try {
			Download download = getEventService().download(token);
			downloadName = download.getFileName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return downloadName;
	}
	
	/**
	 * 根据老师工号显示老师名字
	 * @param teacherId
	 * @return
	 */
	public static String teacherName(Long teacherId) {
		String teacherName = "";
		try {
			Teacher teacher = getTeacherService().selectTeacherById(teacherId);
			teacherName = teacher.getTeacherName();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return teacherName;
	}
	
	public static String subjectName(Integer subjectId) {
		String subjectName = "";
		try {
			Subject subject = getSubjectService().selectById(subjectId);
			subjectName = subject.getSubjectName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return subjectName;
	}
	
	public static String gradeName(Integer gradeId) {
		String gradeName = "";
		try {
			Grade grade = getGradeService().selectById(gradeId);
			gradeName = grade.getGradeName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gradeName;
	}
	
	public static String studentName(Long studentId) {
		String studentName = "";
		try {
			Student student = getStudentService().selectById(studentId);
			studentName = student.getStudentName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentName;
	}
	
	public static String classNameByStudent(Long studentId) {
		String className = "";
		try {
			Student student = getStudentService().selectById(studentId);
			Integer classId = Integer.valueOf(student.getClassId());
			Classe classe = getClasseService().selectById(classId);
			className = classe.getClassName();
 		} catch (Exception e) {
			// TODO: handle exception
		}
		return className;
	}
}
