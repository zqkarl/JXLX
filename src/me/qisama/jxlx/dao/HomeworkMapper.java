package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.Homework;
import me.qisama.jxlx.entity.HomeworkExample;
import org.apache.ibatis.annotations.Param;

public interface HomeworkMapper {
    int countByExample(HomeworkExample example);

    int deleteByExample(HomeworkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Homework record);

    int insertSelective(Homework record);

    List<Homework> selectByExampleWithBLOBs(HomeworkExample example);

    List<Homework> selectByExample(HomeworkExample example);

    Homework selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Homework record, @Param("example") HomeworkExample example);

    int updateByExampleWithBLOBs(@Param("record") Homework record, @Param("example") HomeworkExample example);

    int updateByExample(@Param("record") Homework record, @Param("example") HomeworkExample example);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);
}