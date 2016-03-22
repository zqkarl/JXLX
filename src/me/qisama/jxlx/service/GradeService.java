package me.qisama.jxlx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.GradeDaoImpl;

@Service
public class GradeService {

	@Autowired
	GradeDaoImpl gradeDaoImpl;
	
	
}
