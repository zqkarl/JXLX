package me.qisama.jxlx.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.qisama.jxlx.dao.DownloadMapper;
import me.qisama.jxlx.entity.Download;

@Repository
public class DownloadDaoImpl {

	@Autowired
	DownloadMapper downloadMapper;
	
	public int create(Download download) {
		return downloadMapper.insert(download);
	}
	
	public int delete(String id) {
		return downloadMapper.deleteByPrimaryKey(id);
	}
	
	public Download getPath(String token) {
		Download download = downloadMapper.selectByPrimaryKey(token);
		return download;
	}
}
