package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.Classe;
import me.qisama.jxlx.entity.ClasseExample;
import org.apache.ibatis.annotations.Param;

public interface ClasseMapper {
    int countByExample(ClasseExample example);

    int deleteByExample(ClasseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classe record);

    int insertSelective(Classe record);

    List<Classe> selectByExample(ClasseExample example);

    Classe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classe record, @Param("example") ClasseExample example);

    int updateByExample(@Param("record") Classe record, @Param("example") ClasseExample example);

    int updateByPrimaryKeySelective(Classe record);

    int updateByPrimaryKey(Classe record);
}