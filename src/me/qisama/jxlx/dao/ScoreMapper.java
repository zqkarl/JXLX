package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.Score;
import me.qisama.jxlx.entity.ScoreExample;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}