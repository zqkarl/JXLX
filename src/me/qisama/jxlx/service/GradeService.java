package me.qisama.jxlx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.GradeDaoImpl;
import me.qisama.jxlx.entity.Grade;

@Service
public class GradeService {

	@Autowired
	private GradeDaoImpl gradeDaoImpl;
	
	public Grade selectById(Integer gradeId) {
		return gradeDaoImpl.selectById(gradeId);
	}
	
	public List<Grade> findAll() {
		return gradeDaoImpl.findAll();
	}
}
