package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	
	
}
