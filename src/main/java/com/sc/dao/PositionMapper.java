package com.sc.dao;

import com.sc.domain.PositionDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PositionMapper {
    @Delete({
        "delete from sc_positions",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_positions (id, ref_dept_id, ",
        "posi_name, posi_introduce, ",
        "data_memo, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refDeptId,jdbcType=INTEGER}, ",
        "#{posiName,jdbcType=VARCHAR}, #{posiIntroduce,jdbcType=VARCHAR}, ",
        "#{dataMemo,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PositionDomain record);

    @Select({
        "select",
        "id, ref_dept_id, posi_name, posi_introduce, data_memo, data_state, data_version, ",
        "create_user, update_user, create_time, update_time",
        "from sc_positions",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="posi_name", property="posiName", jdbcType=JdbcType.VARCHAR),
        @Result(column="posi_introduce", property="posiIntroduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PositionDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_dept_id, posi_name, posi_introduce, data_memo, data_state, data_version, ",
        "create_user, update_user, create_time, update_time",
        "from sc_positions"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="posi_name", property="posiName", jdbcType=JdbcType.VARCHAR),
        @Result(column="posi_introduce", property="posiIntroduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PositionDomain> selectAll();

    @Update({
        "update sc_positions",
        "set ref_dept_id = #{refDeptId,jdbcType=INTEGER},",
          "posi_name = #{posiName,jdbcType=VARCHAR},",
          "posi_introduce = #{posiIntroduce,jdbcType=VARCHAR},",
          "data_memo = #{dataMemo,jdbcType=VARCHAR},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PositionDomain record);
}