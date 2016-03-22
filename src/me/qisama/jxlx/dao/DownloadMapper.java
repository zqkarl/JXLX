package me.qisama.jxlx.dao;

import java.util.List;
import me.qisama.jxlx.entity.Download;
import me.qisama.jxlx.entity.DownloadExample;
import org.apache.ibatis.annotations.Param;

public interface DownloadMapper {
    int countByExample(DownloadExample example);

    int deleteByExample(DownloadExample example);

    int deleteByPrimaryKey(String id);

    int insert(Download record);

    int insertSelective(Download record);

    List<Download> selectByExample(DownloadExample example);

    Download selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Download record, @Param("example") DownloadExample example);

    int updateByExample(@Param("record") Download record, @Param("example") DownloadExample example);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);
}