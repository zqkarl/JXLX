package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.Subject;
import me.qisama.jxlx.entity.SubjectExample;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper {
    int countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}