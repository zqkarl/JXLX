package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.TeacherClass;
import me.qisama.jxlx.entity.TeacherClassExample;
import org.apache.ibatis.annotations.Param;

public interface TeacherClassMapper {
    int countByExample(TeacherClassExample example);

    int deleteByExample(TeacherClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherClass record);

    int insertSelective(TeacherClass record);

    List<TeacherClass> selectByExample(TeacherClassExample example);

    TeacherClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherClass record, @Param("example") TeacherClassExample example);

    int updateByExample(@Param("record") TeacherClass record, @Param("example") TeacherClassExample example);

    int updateByPrimaryKeySelective(TeacherClass record);

    int updateByPrimaryKey(TeacherClass record);
}