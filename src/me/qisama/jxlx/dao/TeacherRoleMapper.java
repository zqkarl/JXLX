package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.TeacherRole;
import me.qisama.jxlx.entity.TeacherRoleExample;
import org.apache.ibatis.annotations.Param;

public interface TeacherRoleMapper {
    int countByExample(TeacherRoleExample example);

    int deleteByExample(TeacherRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherRole record);

    int insertSelective(TeacherRole record);

    List<TeacherRole> selectByExample(TeacherRoleExample example);

    TeacherRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherRole record, @Param("example") TeacherRoleExample example);

    int updateByExample(@Param("record") TeacherRole record, @Param("example") TeacherRoleExample example);

    int updateByPrimaryKeySelective(TeacherRole record);

    int updateByPrimaryKey(TeacherRole record);
}