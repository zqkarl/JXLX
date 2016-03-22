package me.qisama.jxlx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.ClasseDaoImpl;
import me.qisama.jxlx.entity.Classe;

@Service
public class ClasseService {

	@Autowired
	ClasseDaoImpl classeDaoImpl;
	
	public List<Classe> findAll(){
		return classeDaoImpl.findAll();
	}
	
	public void create(Classe classe) {
		classeDaoImpl.create(classe);
	}
	
	public void delete(int id) {
		classeDaoImpl.delete(id);
	}
	
	public void update(Classe classe) {
		classeDaoImpl.update(classe);
	}
	
	public Classe selectById(Integer id) {
		return classeDaoImpl.selectById(id);
	}
}
