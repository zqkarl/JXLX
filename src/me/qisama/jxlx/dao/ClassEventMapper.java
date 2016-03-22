package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.ClassEvent;
import me.qisama.jxlx.entity.ClassEventExample;
import org.apache.ibatis.annotations.Param;

public interface ClassEventMapper {
    int countByExample(ClassEventExample example);

    int deleteByExample(ClassEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassEvent record);

    int insertSelective(ClassEvent record);

    List<ClassEvent> selectByExample(ClassEventExample example);

    ClassEvent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassEvent record, @Param("example") ClassEventExample example);

    int updateByExample(@Param("record") ClassEvent record, @Param("example") ClassEventExample example);

    int updateByPrimaryKeySelective(ClassEvent record);

    int updateByPrimaryKey(ClassEvent record);
}