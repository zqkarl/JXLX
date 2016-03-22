package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.ClassHomework;
import me.qisama.jxlx.entity.ClassHomeworkExample;
import org.apache.ibatis.annotations.Param;

public interface ClassHomeworkMapper {
    int countByExample(ClassHomeworkExample example);

    int deleteByExample(ClassHomeworkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassHomework record);

    int insertSelective(ClassHomework record);

    List<ClassHomework> selectByExample(ClassHomeworkExample example);

    ClassHomework selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassHomework record, @Param("example") ClassHomeworkExample example);

    int updateByExample(@Param("record") ClassHomework record, @Param("example") ClassHomeworkExample example);

    int updateByPrimaryKeySelective(ClassHomework record);

    int updateByPrimaryKey(ClassHomework record);
}