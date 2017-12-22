package com.sc.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sc.common.constant.MyException;
import com.sc.common.util.FileUtil;
import com.sc.dao.BylawMapper;
import com.sc.domain.Bylaw;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;

@Service
public class BylawServiceImpl implements IBylawService{

	@Autowired
	private BylawMapper bylawMapper;
	
	
	@Transactional
	@Override
	public void saveBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request) {
		Bylaw record = new Bylaw();
		BeanUtils.copyProperties(bylawModel, record);
		record.setId(null);
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateUser("SYS");
		record.setUpdateUser("SYS");
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		
		//TODO 处理File文件
		String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgUpload/");
        try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			throw new MyException("保存上传附件出错");
		}
        FileUtil.readFileByLines(filePath+fileName);
		
		record.setBylawsCode("100001"); //业务主键是否需要
		record.setBylawsContent("规则制度内容");
		record.setFileUrl("规则制度url连接地址");
		
		//TODO 
		int flag = bylawMapper.saveBylaw(record);
		if(flag != 1){
			throw new MyException("保存规则制度出错");
		}
	}

	
	@Override
	public Map<String, Object> queryBylaw() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Bylaw> list = bylawMapper.queryBylaw();
		//是否需要后端进行数据排序等处理
		dataMap.put("bylawList", list);
		return dataMap;
	}

	
	@Transactional
	@Override
	public void updateBylaw(BylawModel bylawModel) {
		Bylaw record = new Bylaw();
		BeanUtils.copyProperties(bylawModel, record);
		//TODO 
		int flag = bylawMapper.updateBylaw(record);
		if(flag != 1){
			throw new MyException("修改规则制度出错");
		}
	}
	
	
	@Transactional
	@Override
	public void deleteBylaw(String bylawsCode) {
		//TODO 物理删除还是逻辑删除
		String userName = "";
		int flag = bylawMapper.deleteBylaw2(bylawsCode, userName);
		if(flag != 1){
			throw new MyException("删除规则制度出错");
		}
	}
	
	
}
