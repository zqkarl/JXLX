package me.qisama.jxlx.dao;

import java.util.List;
import java.util.Set;

import me.qisama.jxlx.entity.Resource;
import me.qisama.jxlx.entity.ResourceExample;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    int countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    Set<String> findPermissionsByRoleName(String roleName);
}