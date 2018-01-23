package com.sc.service.impl;

import java.util.ArrayList;
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
		int flag = bylawMapper.insert(bylawDomain);
		if (flag != 1) {
			throw new ScException("保存规章制度出错");
		}
	}

	@Override
	public Map<String, Object> queryBylawList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BylawDomain> list = bylawMapper.selectAll();
		// 后端对数据进行处理
		List<BylawDomain> xzglList = new ArrayList<BylawDomain>();
		List<BylawDomain> tjbzList = new ArrayList<BylawDomain>();
		List<BylawDomain> cwglList = new ArrayList<BylawDomain>();
		if (!CollectionUtils.isEmpty(list)) {
			for (BylawDomain bylaw : list) {
				switch (bylaw.getBylawsCategory().trim()) {
				case CommonConstant.XZGL:
					xzglList.add(bylaw);
					break;
				case CommonConstant.TJBZ:
					tjbzList.add(bylaw);
					break;
				case CommonConstant.CWGL:
					cwglList.add(bylaw);
					break;
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
	public void updateBylaw(BylawModel bylawModel) {
		logger.info("BylawServiceImpl.updateBylaw=="+JSON.toJSONString(bylawModel));
		BylawDomain bylawDomain = new BylawDomain();
		BeanUtils.copyProperties(bylawModel, bylawDomain);
		int flag = bylawMapper.updateByPrimaryKey(bylawDomain);
		if (flag != 1) {
			throw new ScException("修改规章制度出错");
		}
	}

	@Transactional
	@Override
	public void deleteBylaw(Integer id) {
		logger.info("BylawServiceImpl.deleteBylaw=="+JSON.toJSONString(id));
		int flag = bylawMapper.updateState(id, 0);// 状态更新到0表示失效
		if (flag != 1) {
			throw new ScException("删除规章制度出错");
		}
	}

	@Override
	public BylawDomain queryById(Integer id) {
		logger.info("BylawServiceImpl.queryById=="+JSON.toJSONString(id));
		BylawDomain bylawDomain = bylawMapper.selectByPrimaryKey(id);
		return bylawDomain;
	}

	@Override
	public Map<String, Object> queryCountGroupBylawCategory() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(CommonConstant.XZGL, 0);
		dataMap.put(CommonConstant.TJBZ, 0);
		dataMap.put(CommonConstant.CWGL, 0);

		List<BylawCountGroupByCategory> list = bylawMapper.queryCountGroupBylawCategory();
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
