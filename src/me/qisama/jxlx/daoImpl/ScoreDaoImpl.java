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
	
	public int updateSelective(Score score) {
		return scoreMapper.updateByPrimaryKeySelective(score);
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
	
	public Score selectByExamIdAndStudentId(Integer examId, Long studentId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andStudentIdEqualTo(studentId);
		List<Score> sList = scoreMapper.selectByExample(scoreExample);
		if (sList.isEmpty()) {
			return null;
		} else {
			return sList.get(0);
		} 
	}
	
	/**
	 * 计算一场考试优秀（90分以上）的人数
	 * @param examId
	 * @return
	 */
	public Integer countExcellentNum(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andScoreGreaterThanOrEqualTo(90);
		return scoreMapper.countByExample(scoreExample);
	}
	
	/**
	 * 计算一场考试良好（80分以上）的人数
	 * @param examId
	 * @return
	 */
	public Integer countGoodNum(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andScoreLessThan(90);
		criteria.andScoreGreaterThanOrEqualTo(80);
		return scoreMapper.countByExample(scoreExample);
	}
	
	/**
	 * 计算一场考试中等（70分以上）的人数
	 * @param examId
	 * @return
	 */
	public Integer countFairNum(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andScoreLessThan(80);
		criteria.andScoreGreaterThanOrEqualTo(70);
		return scoreMapper.countByExample(scoreExample);
	}
	
	/**
	 * 计算一场考试及格（60分以上）的人数
	 * @param examId
	 * @return
	 */
	public Integer countPassNum(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andScoreLessThan(70);
		criteria.andScoreGreaterThanOrEqualTo(60);
		return scoreMapper.countByExample(scoreExample);
	}
	
	/**
	 * 计算一场考试不及格的人数
	 * @param examId
	 * @return
	 */
	public Integer countFailNum(Integer examId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andExamIdEqualTo(examId);
		criteria.andScoreLessThan(60);
		return scoreMapper.countByExample(scoreExample);
	}
	
	public List<Score> selectByStudentId(Long studentId) {
		ScoreExample scoreExample = new ScoreExample();
		Criteria criteria = scoreExample.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return scoreMapper.selectByExample(scoreExample);
	}
}
