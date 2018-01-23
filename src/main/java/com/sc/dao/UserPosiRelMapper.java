package com.sc.dao;

import com.sc.domain.UserPosiRelDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserPosiRelMapper {
    @Delete({
        "delete from sc_user_posi_rel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_user_posi_rel (id, ref_user_id, ",
        "ref_posi_id, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refUserId,jdbcType=INTEGER}, ",
        "#{refPosiId,jdbcType=INTEGER}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserPosiRelDomain record);

    @Select({
        "select",
        "id, ref_user_id, ref_posi_id, data_state, data_version, create_user, update_user, ",
        "create_time, update_time",
        "from sc_user_posi_rel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_user_id", property="refUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserPosiRelDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_user_id, ref_posi_id, data_state, data_version, create_user, update_user, ",
        "create_time, update_time",
        "from sc_user_posi_rel"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_user_id", property="refUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserPosiRelDomain> selectAll();

    @Update({
        "update sc_user_posi_rel",
        "set ref_user_id = #{refUserId,jdbcType=INTEGER},",
          "ref_posi_id = #{refPosiId,jdbcType=INTEGER},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserPosiRelDomain record);
}