package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Position;
import com.sc.model.request.PositionModel;

public interface PositionMapper {

	@Insert({
		""
	})
	int savePosition(Position record);

	
	@Select({
		""
	})
	List<Position> queryPosition(PositionModel positionModel);


	@Update({
		""
	})
	int updatePosition(Position record);


	@Select({
		"select id, ref_department_code, position_code, position_name,",
			"ref_user_code, position_introduce, data_memo, data_state ",
		"from sc_positions ",
		"where data_state=1 "
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="ref_department_code", property="refDepartmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="position_code", property="positionCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="position_name", property="positionName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_user_code", property="refUserCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="position_introduce", property="positionIntroduce", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.TIMESTAMP),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Position> queryPositionList();

	
	
}
