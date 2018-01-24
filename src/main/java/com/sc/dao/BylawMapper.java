package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.BylawDomain;
import com.sc.model.response.BylawCountGroupByCategory;

public interface BylawMapper extends MyMapper<BylawDomain>{

	@Select({
		"select bylaws_category as bylawsCategory, count(1) as count ",
		"from sc_bylaws where data_state=1 group by bylaws_category"
	})
	List<BylawCountGroupByCategory> selectCountByCategory();
    
	
}