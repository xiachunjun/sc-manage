package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.MyException;
import com.sc.common.util.DateUtil;
import com.sc.common.util.FileUtil;
import com.sc.common.util.UuidUtil;
import com.sc.dao.BylawMapper;
import com.sc.domain.Bylaw;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;

@Service
public class BylawServiceImpl implements IBylawService{

	private static final Logger logger = LoggerFactory.getLogger(BylawServiceImpl.class);
	
	@Value("${system.file.path}")
	private String filePath;   //上传的附件的存储路径
	
	@Autowired
	private BylawMapper bylawMapper;
	
	
	@Transactional
	@Override
	public void saveBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request) {
		Bylaw record = setProperties(bylawModel, file);
		int flag = bylawMapper.saveBylaw(record);
		if(flag != 1){
			throw new MyException("保存规章制度出错");
		}
	}


	@Override
	public Map<String, Object> queryBylawList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Bylaw> list = bylawMapper.queryBylaw();
		//后端对数据进行处理
		List<Bylaw> xzglList = new ArrayList<Bylaw>();
		List<Bylaw> tjbzList = new ArrayList<Bylaw>();
		List<Bylaw> cwglList = new ArrayList<Bylaw>();
		if(!CollectionUtils.isEmpty(list)){
			for (Bylaw bylaw : list) {
				switch(bylaw.getBylawsCategory().trim()){
					case CommonConstant.XZGL : xzglList.add(bylaw);  break;
					case CommonConstant.TJBZ : tjbzList.add(bylaw);  break;
					case CommonConstant.CWGL : cwglList.add(bylaw);  break;
				}
			}
		}
		dataMap.put("XZGL", xzglList);
		dataMap.put("TJBZ", tjbzList);
		dataMap.put("CWGL", cwglList);
		return dataMap;
	}

	
	@Transactional
	@Override
	public void updateBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request) {
		Bylaw record = new Bylaw();
		BeanUtils.copyProperties(bylawModel, record);
		if(null != file){
			uploadAndSetFileUrl(file, record);
		}
		int flag = bylawMapper.updateBylaw(record);
		if(flag != 1){
			throw new MyException("修改规章制度出错");
		}
	}
	
	
	@Transactional
	@Override
	public void deleteBylaw(Integer bylawsId) {
		String userName = "SYS";
		int flag = bylawMapper.updateStatus(bylawsId, userName);
		if(flag != 1){
			throw new MyException("删除规章制度出错");
		}
	}


	@Override
	public String queryFileUrlById(Integer bylawsId) {
		return bylawMapper.queryFileUrlById(bylawsId);
	}
	
	
	/**********************以下为私有方法**********************/
	
	private Bylaw setProperties(BylawModel bylawModel, MultipartFile file) {
		Bylaw record = new Bylaw();
		BeanUtils.copyProperties(bylawModel, record);
		record.setArticleTime(DateUtil.str2Date(bylawModel.getArtTime()));
		record.setId(null);
		//record.setBylawsCode("000001"); //业务主键是否需要,如何设置
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateUser("SYS");
		record.setUpdateUser("SYS");
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		//处理File文件
		if(null != file){
			uploadAndSetFileUrl(file, record);
		}
		return record;
	}


	private void uploadAndSetFileUrl(MultipartFile file, Bylaw record) {
		//String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		String realFilePath = filePath+UuidUtil.getUUID()+"/";
		try {
			FileUtil.uploadFile(file.getBytes(), realFilePath, fileName);
		} catch (Exception e) {
			logger.error("上传附件置服务器异常", e);
			throw new MyException("保存上传附件出错");
		}
		record.setFileUrl(realFilePath+fileName);
		//record.setBylawsContent("规章制度内容");
	}
	
	
}
