package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.ScException;
import com.sc.common.util.DateUtil;
import com.sc.dao.DataRecordMapper;
import com.sc.domain.DataRecordDomain;
import com.sc.model.request.DataRecordModel;
import com.sc.service.IDataRecordService;
import com.sc.support.UserContext;

@Service
public class DataRecordServiceImpl implements IDataRecordService {

	@Autowired
	private DataRecordMapper dataRecordMapper;
	
	@Transactional
	@Override
	public void saveDataRecord(List<DataRecordModel> dataRecordModels) {
		if(CollectionUtils.isEmpty(dataRecordModels)){
			throw new ScException("请填写部门数据");
		}
		List<DataRecordDomain> list = new ArrayList<DataRecordDomain>();
		for (DataRecordModel dataRecordModel : dataRecordModels) {
			DataRecordDomain record = new DataRecordDomain();
			BeanUtils.copyProperties(dataRecordModel, record);
			//TODO 具体数据还需要进行转换
			record.setRecordTime(DateUtil.str2Date(dataRecordModel.getRedTime()));
			record.setRecordType(1);
			record.setId(null);
			record.setDataState(1);
			record.setDataVersion(1);
			record.setCreateUser(UserContext.getLoginName());  
			record.setUpdateUser(record.getCreateUser());
			record.setCreateTime(new Date());
			record.setUpdateTime(record.getCreateTime());
			list.add(record);
		}
		int flag = dataRecordMapper.insertList(list);
		//int flag = dataRecordMapper.batchInsert(list);
		if(flag <= 0){
			throw new ScException("填报各部门数据出错");
		}
	}
	
	
}
