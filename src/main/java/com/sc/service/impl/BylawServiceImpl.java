package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.common.util.CommonUtils;
import com.sc.dao.BylawMapper;
import com.sc.domain.BylawDomain;
import com.sc.model.request.BylawModel;
import com.sc.model.response.BylawCountGroupByCategory;
import com.sc.service.IBylawService;

@Service
public class BylawServiceImpl implements IBylawService {

	private static final Logger logger = LoggerFactory.getLogger(BylawServiceImpl.class);

	@Value("${system.file.path}")
	private String filePath; // 上传的附件的存储路径
	@Autowired
	private BylawMapper bylawMapper;

	
	@Transactional
	@Override
	public void saveBylaw(BylawModel bylawModel) {
		logger.info("BylawServiceImpl.saveBylaw=="+JSON.toJSONString(bylawModel));
		BylawDomain bylawDomain = new BylawDomain();
		BeanUtils.copyProperties(bylawModel, bylawDomain);
		//TODO 还有其他默认值
		int flag = bylawMapper.insertSelective(bylawDomain);
		if (flag != 1) {
			throw new ScException("保存规章制度出错");
		}
	}

	@Override
	public Map<String, List<BylawDomain>> queryBylawList() {
		//查询所有有效的记录
		BylawDomain record = new BylawDomain();
		record.setDataState(1);
		List<BylawDomain> list = bylawMapper.select(record);
		//对list按照规则制度分类进行分组
		Map<String, List<BylawDomain>> dataMap = new HashMap<String, List<BylawDomain>>(); 
		CommonUtils.listGroup2Map(list, dataMap, BylawDomain.class, "getBylawsCategory");
		return dataMap;
	}
	

	@Transactional
	@Override
	public void updateBylaw(BylawModel bylawModel) {
		logger.info("BylawServiceImpl.updateBylaw=="+JSON.toJSONString(bylawModel));
		BylawDomain record = new BylawDomain();
		BeanUtils.copyProperties(bylawModel, record);
		//TODO 其他字段
		int flag = bylawMapper.updateByPrimaryKeySelective(record);
		if (flag != 1) {
			throw new ScException("修改规章制度出错");
		}
	}
	

	@Transactional
	@Override
	public void deleteBylaw(Integer id) {
		logger.info("BylawServiceImpl.deleteBylaw=="+JSON.toJSONString(id));
		BylawDomain record = new BylawDomain();
		record.setId(id);
		record.setDataState(0);
		//TODO 其他更新字段
		int flag = bylawMapper.updateByPrimaryKeySelective(record); //删除逻辑，将状态由1改为0
		if (flag != 1) {
			throw new ScException("删除规章制度出错");
		}
	}

	
	@Override
	public BylawDomain queryById(Integer id) {
		logger.info("BylawServiceImpl.queryById=="+JSON.toJSONString(id));
		return bylawMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public Map<String, Object> queryCountGroupBylawCategory() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//TODO 此处需要修改，不应该设置死，以后新增了规则制度分类，还得修改代码
		dataMap.put(CommonConstant.XZGL, 0);
		dataMap.put(CommonConstant.TJBZ, 0);
		dataMap.put(CommonConstant.CWGL, 0);
		//分组查询各数量
		List<BylawCountGroupByCategory> list = bylawMapper.selectCountByCategory();
		if (!CollectionUtils.isEmpty(list)) {
			for (BylawCountGroupByCategory groupResult : list) {
				switch (groupResult.getBylawsCategory()) {
				case CommonConstant.XZGL:
					dataMap.put(CommonConstant.XZGL, groupResult.getCount());
					break;
				case CommonConstant.TJBZ:
					dataMap.put(CommonConstant.TJBZ, groupResult.getCount());
					break;
				case CommonConstant.CWGL:
					dataMap.put(CommonConstant.CWGL, groupResult.getCount());
					break;
				}
			}
		}
		return dataMap;
	}

	
}
