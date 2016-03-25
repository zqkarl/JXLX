package me.qisama.jxlx.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.ScoreMapper;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.ScoreExample;
import me.qisama.jxlx.entity.ScoreExample.Criteria;

@Repository
public class ScoreDaoImpl {

	@Autowired
	private ScoreMapper scoreMapper;
	
	public int create(Score score) {
		return scoreMapper.insert(score);
	}
	
	public int delete(Long id){
		return scoreMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Score score) {
		return scoreMapper.updateByPrimaryKey(score);
	}
	
	public List<Score> findAll() {
		ScoreExample scoreExample = new ScoreExample();
		return scoreMapper.selectByExample(scoreExample);
	}
	
	public List<Score> selectByExamId(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		return scoreMapper.selectByExample(scoreExample);
	}
}
