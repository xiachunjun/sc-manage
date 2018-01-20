package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.dao.provider.DataRecordSqlProvider;
import com.sc.domain.DataRecord;

public interface DataRecordMapper {

	@Insert({
		"insert into sc_data_records(",
			"ref_dept_code, record_type, record_time, record_name, record_unit, ",
			"record_value, target_value, rate_of_progress, progress_info, record_memo, ",
			"data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{refDeptCode,jdbcType=VARCHAR}, #{recordType,jdbcType=INTEGER}, #{recordTime,jdbcType=TIMESTAMP}, ",
			"#{recordName,jdbcType=VARCHAR}, #{recordUnit,jdbcType=INTEGER}, #{recordValue,jdbcType=FLOAT}, ",
			"#{targetValue,jdbcType=FLOAT}, #{rateOfProgress,jdbcType=VARCHAR}, #{progressInfo,jdbcType=VARCHAR}, ",
			"#{recordMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveDataRecord(DataRecord record);

	
	@InsertProvider(type = DataRecordSqlProvider.class, method = "insertAll")  
	int batchInsert(@Param("list")List<DataRecord> list);
	
	
	@Select({
		"select id, ref_dept_code, record_type, record_time, record_name, record_unit,",
			"record_value, target_value, rate_of_progress, progress_info, record_memo ",
		"where id=#{id,jdbcType=INTEGER}"
	})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_type", property="userLoginName", jdbcType=JdbcType.INTEGER),
        @Result(column="record_time", property="userLoginPwd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="record_name", property="userIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_unit", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_value", property="userNickname", jdbcType=JdbcType.FLOAT),
        @Result(column="target_value", property="userNickname", jdbcType=JdbcType.FLOAT),
        @Result(column="rate_of_progress", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_memo", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
	DataRecord selectById(Integer id);
	
	
	@Select({
		"select id, ref_dept_code, record_type, record_time, record_name, record_unit,",
			"record_value, target_value, rate_of_progress, progress_info, record_memo ",
		"where ref_dept_code=#{refDeptCode,jdbcType=VARCHAR}"
	})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_type", property="userLoginName", jdbcType=JdbcType.INTEGER),
        @Result(column="record_time", property="userLoginPwd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="record_name", property="userIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_unit", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_value", property="userNickname", jdbcType=JdbcType.FLOAT),
        @Result(column="target_value", property="userNickname", jdbcType=JdbcType.FLOAT),
        @Result(column="rate_of_progress", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_memo", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
	List<DataRecord> selectListByDeptCode(@Param("refDeptCode")String deptCode);
	
	
	@Delete({
		"delete from sc_data_records where id=#{id,jdbcType=INTEGER}"
	})
	int deleteById(Integer id);
	
	
	
}
