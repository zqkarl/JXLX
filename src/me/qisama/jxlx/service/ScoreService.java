package me.qisama.jxlx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.qisama.jxlx.daoImpl.ScoreDaoImpl;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.ScoreExample;
import me.qisama.jxlx.entity.ScoreExample.Criteria;

@Service
public class ScoreService {

	@Autowired
	private ScoreDaoImpl scoreDaoImpl;
	
	public int Create(Score score) {
		return scoreDaoImpl.create(score);
	}
	
	public List<Score> selectByExamId(Integer examId) {
		return scoreDaoImpl.selectByExamId(examId);
	}
}
