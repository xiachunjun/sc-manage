package com.sc.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sc.common.constant.MyException;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 上传文件
	 * @param file
	 * @param filePath
	 * @param fileName
	 */
	public static void uploadFile(byte[] file, String filePath, String fileName){ 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }    
        FileOutputStream out = null;
        try {
			out = new FileOutputStream(filePath+fileName);
			out.write(file);
			out.flush();
		} catch (Exception e) {
			logger.error("上传文件异常", e);
			throw new MyException("上传文件异常");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
    }
	
	
	/**
	 * 下载文件
	 * @param response
	 * @param file
	 * @param fileName
	 */
	public static void downloadFile(HttpServletResponse response, File file, String fileName) {
		response.reset();
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			fileName = new String(fileName.getBytes("gbk"),"iso-8859-1");
		} catch (UnsupportedEncodingException e1) {
			logger.error("处理文件名乱码问题异常", e1);
			throw new MyException("处理文件名乱码问题异常");
		}
		response.addHeader("Content-Disposition", "attachment;fileName="+fileName);// 设置文件名
		response.addHeader("Content-Length", ""+file.length()); 
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			OutputStream os = response.getOutputStream();
			int len = 0;
			while ( (len = bis.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			logger.error("下载文件异常", e);
			throw new MyException("下载文件异常");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
}
