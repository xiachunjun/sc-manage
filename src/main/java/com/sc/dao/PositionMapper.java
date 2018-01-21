package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sc.dao.provider.PositionSqlProvider;
import com.sc.domain.Position;

public interface PositionMapper {

	@Insert({
        "insert into sc_positions (ref_department_code, position_code, position_name, ",
        	"ref_user_code, position_introduce, data_memo, ",
        	"data_state, data_version, create_user, update_user, create_time, update_time)",
        "values (#{refDepartmentCode,jdbcType=VARCHAR}, ",
        	"#{positionCode,jdbcType=VARCHAR}, #{positionName,jdbcType=VARCHAR}, ",
        	"#{refUserCode,jdbcType=VARCHAR}, #{positionIntroduce,jdbcType=VARCHAR}, ",
        	"#{dataMemo,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        	"#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        	"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        	"#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
	int savePosition(Position record);

	
	@Select({
		"select ",
		    "d.department_name as departmentName, p.ref_department_code as refDepartmentCode, ",
			"p.id, p.position_code as positionCode, p.position_name as positionName, ",
			"u.user_login_name as userLoginName",
		"from sc_positions p ",
		"left join sc_users u on p.ref_user_code=u.user_code ",
		"left join sc_departments d on p.ref_department_code=d.department_code ",
		"where ${condition} order by id "
	})
	List<Position> queryDutyByCondition(@Param("condition")String condition);


	@UpdateProvider(type=PositionSqlProvider.class, method="updatePosition")  
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
	
	
	@Select({
		"select id, ref_department_code, position_code, position_name,",
		"ref_user_code, position_introduce, data_memo, data_state ",
		"from sc_positions ",
		"where data_state=1  and position_code=#{positionCode,jdbcType=VARCHAR}"
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
	Position queryByCode(@Param("positionCode")String positionCode);


	@Select({
	    "select max(position_code) from sc_positions"
	})
	Integer getMaxCode();

	
	
}
