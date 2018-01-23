package com.sc.dao;

import com.sc.domain.DutyDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DutyMapper {
    @Delete({
        "delete from sc_duty",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_duty (id, ref_dept_id, ",
        "ref_posi_id, duty_type, ",
        "duty_level, duty_name, ",
        "duty_introduce, parent_id, ",
        "data_memo, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refDeptId,jdbcType=INTEGER}, ",
        "#{refPosiId,jdbcType=INTEGER}, #{dutyType,jdbcType=VARCHAR}, ",
        "#{dutyLevel,jdbcType=VARCHAR}, #{dutyName,jdbcType=VARCHAR}, ",
        "#{dutyIntroduce,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
        "#{dataMemo,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(DutyDomain record);

    @Select({
        "select",
        "id, ref_dept_id, ref_posi_id, duty_type, duty_level, duty_name, duty_introduce, ",
        "parent_id, data_memo, data_state, data_version, create_user, update_user, create_time, ",
        "update_time",
        "from sc_duty",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    DutyDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_dept_id, ref_posi_id, duty_type, duty_level, duty_name, duty_introduce, ",
        "parent_id, data_memo, data_state, data_version, create_user, update_user, create_time, ",
        "update_time",
        "from sc_duty"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DutyDomain> selectAll();

    @Update({
        "update sc_duty",
        "set ref_dept_id = #{refDeptId,jdbcType=INTEGER},",
          "ref_posi_id = #{refPosiId,jdbcType=INTEGER},",
          "duty_type = #{dutyType,jdbcType=VARCHAR},",
          "duty_level = #{dutyLevel,jdbcType=VARCHAR},",
          "duty_name = #{dutyName,jdbcType=VARCHAR},",
          "duty_introduce = #{dutyIntroduce,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "data_memo = #{dataMemo,jdbcType=VARCHAR},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DutyDomain record);
   
    
    @Select({
        "select",
        "id, ref_dept_id, ref_posi_id, duty_type, duty_level, duty_name, duty_introduce,parent_id ",
        "from sc_duty where 1=1 and ${condition}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="duty_type", property="dutyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_level", property="dutyLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_name", property="dutyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="duty_introduce", property="dutyIntroduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
    List<DutyDomain> queryByDeptOrPosi(@Param("condition")String condition);
    
    
    
}