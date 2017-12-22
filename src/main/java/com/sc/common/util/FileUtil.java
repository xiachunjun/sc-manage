package com.sc.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	
	
	public static void readFileByLines(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			byte[] b = new byte[1024];
			int len = 0 ;
			while((len=fis.read(b)) != -1){
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			fis.close();
		} catch (Exception e) {
			logger.error("读取上传文件中内容异常", e);
		}
		
//        File file = new File(filePath);
//        BufferedReader reader = null;
//        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            //reader = new BufferedReader(new FileReader(file));
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));  
//            
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            reader.close();
//        } catch (IOException e) {
//        	logger.error("读取上传文件中内容异常", e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                	logger.error("关闭流异常", e1);
//                }
//            }
//        }
    
	}

	
	
}
