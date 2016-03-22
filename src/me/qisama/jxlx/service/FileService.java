package me.qisama.jxlx.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.qisama.jxlx.daoImpl.DownloadDaoImpl;
import me.qisama.jxlx.entity.Download;

/**
 * 文件上传与下载
 * @author QISAMA
 * 2016年2月25日
 */
@Service
public class FileService {

	@Value("${upload.address}")
	private String uploadAdress;
	
	@Autowired
	private DownloadDaoImpl downloadDaoImpl;
	
	private Log logger = LogFactory.getLog("System");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 上传文件
	 * @param request 上传的文件名对应的应是“file”
	 * @param limitSuffix 允许上传的文件类型，以逗号隔开(eg: .jpg,.ppt,.pptx)
	 * @return 提取码
	 */
	public String upload(HttpServletRequest request, MultipartFile file, String limitSuffix) {
		
		String filePath = "";
		String uuid = "";
		String date = sdf.format(new Date());
		
		// 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {
            	String fileName = file.getOriginalFilename();
            	// 文件保存路径  
                filePath = request.getSession().getServletContext().getRealPath("/") + uploadAdress+ date;
                /**根据真实路径创建目录**/
    	        File logoSaveFile = new File(filePath);
    	        if(!logoSaveFile.exists()){
    	            if(!logoSaveFile.mkdirs()){
    	            	logger.info("文件夹创建失败");
    	            	throw new  Exception("file create error!");
    	            }
    	        }
            	/**获取文件的后缀**/
    	        String suffix = fileName.substring(fileName.lastIndexOf("."));
    	        // 判断该文件类型是否允许上传
    	        if (!"".equals(limitSuffix) && null != limitSuffix) {
    	        	String[] limitSuffixs = limitSuffix.split(",");
    	        	boolean flag = false;
    	        	for (String s : limitSuffixs) {
						if (s.equals(suffix)) {
							uuid = UUID.randomUUID().toString();
							filePath = filePath + "/" + uuid +suffix;
							// 转存文件 
							//FileCopyUtils.copy(file.getBytes(), new File(filePath));
							file.transferTo(new File(filePath));
							
							Download download = new Download();
							download.setFileName(fileName);
							download.setId(uuid);
							download.setDownloadPath(filePath);
							downloadDaoImpl.create(download);
							
							flag = true;
							logger.info("上传文件成功，保存的路径为:"+filePath);
						}
					}
    	        	
    	        	if (!flag) {
						logger.info("上传文件失败，后缀不符合要求。");
					}
				}
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
		return uuid;
	}
}
