package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Duty;

public interface DutyMapper {

	@Insert({
		"insert into sc_duty(",
			"duty_code, ref_department_code, ref_position_code, duty_type, duty_level, duty_name, ",
			"duty_introduce, parent_code, data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{dutyCode,jdbcType=VARCHAR}, #{refDepartmentCode,jdbcType=VARCHAR}, #{refPositionCode,jdbcType=VARCHAR}, ",
			"#{dutyType,jdbcType=VARCHAR}, #{dutyLevel,jdbcType=VARCHAR}, #{dutyName,jdbcType=TIMESTAMP}, ",
			"#{dutyIntroduce,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, #{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveDuty(Duty record);
	
	
	@Select({
		"select id, duty_code, ref_department_code, ref_position_code, duty_type, duty_level, duty_name, ",
			"duty_introduce, parent_code, data_memo, data_state ",
		"from sc_duty ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="duty_code", property="dutyCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_department_code", property="refDepartmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_position_code", property="refPositionCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Duty> queryDutyList();


	@Select({
		"select duty_code, duty_type, duty_level, duty_name, duty_introduce, parent_code, data_memo ",
		"from sc_duty ",
		"where data_state=1 and duty_type='DEPT' ",
		"and ref_department_code=#{refDepartmentCode, jdbcType=VARCHAR}"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="duty_code", property="dutyCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_department_code", property="refDepartmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_position_code", property="refPositionCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Duty> queryDutyByDeptCode(@Param("refDepartmentCode")String deptCode);


	@Select({
		"select duty_code, duty_type, duty_level, duty_name, duty_introduce, parent_code, data_memo ",
		"from sc_duty ",
		"where data_state=1 and duty_type='POSI' ",
		"and ref_position_code=#{refPositionCode, jdbcType=VARCHAR}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="duty_code", property="dutyCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_department_code", property="refDepartmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="ref_position_code", property="refPositionCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Duty> queryDutyByPostCode(@Param("refPositionCode")String postCode);

	
	
}
