package me.qisama.jxlx.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired  
    private HttpServletRequest request; 

	@RequestMapping(value = "/upload" ,  method = RequestMethod.POST)  
    public String fileUpload(@RequestParam("222") MultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {
            	String oldFileName = file.getOriginalFilename();
            	/**获取文件的后缀**/
    	        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
    	        /**使用UUID生成文件名称**/
    	        String newName = UUID.randomUUID().toString() + suffix;//构建文件名称  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload/"  
                        + newName;  
                // 转存文件  
                //FileCopyUtils.copy(file.getBytes(), new File(filePath));
                file.transferTo(new File(filePath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        // 重定向  
        return "user/list";  
    }  
  
	@RequestMapping("/download")   
    public ModelAndView download(@RequestParam("fileName")   
    String fileName, HttpServletRequest request, HttpServletResponse response)   
            throws Exception {   
  
        response.setContentType("text/html;charset=utf-8");   
        request.setCharacterEncoding("UTF-8");   
        java.io.BufferedInputStream bis = null;   
        java.io.BufferedOutputStream bos = null;   
  
        String ctxPath = request.getSession().getServletContext().getRealPath(   
                "/")   
                + "fileUpload/";   
        String downLoadPath = ctxPath + fileName;   
        System.out.println(downLoadPath);   
        try {   
            long fileLength = new File(downLoadPath).length();   
            response.setContentType("application/x-msdownload;");   
            response.setHeader("Content-disposition", "attachment; filename="  
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));   
            response.setHeader("Content-Length", String.valueOf(fileLength));   
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));   
            bos = new BufferedOutputStream(response.getOutputStream());   
            byte[] buff = new byte[2048];   
            int bytesRead;   
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {   
                bos.write(buff, 0, bytesRead);   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            if (bis != null)   
                bis.close();   
            if (bos != null)   
                bos.close();   
        }   
        return null;   
    }
}
