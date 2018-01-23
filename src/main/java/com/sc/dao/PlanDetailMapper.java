package com.sc.dao;

import com.sc.domain.PlanDetailDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PlanDetailMapper {
    @Delete({
        "delete from sc_plan_details",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_plan_details (id, ref_plan_id, ",
        "detail_type, detail_content, ",
        "begin_time, end_time, ",
        "data_state, data_version, ",
        "create_user, update_user, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refPlanId,jdbcType=INTEGER}, ",
        "#{detailType,jdbcType=INTEGER}, #{detailContent,jdbcType=VARCHAR}, ",
        "#{beginTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PlanDetailDomain record);

    @Select({
        "select",
        "id, ref_plan_id, detail_type, detail_content, begin_time, end_time, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_plan_details",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_plan_id", property="refPlanId", jdbcType=JdbcType.INTEGER),
        @Result(column="detail_type", property="detailType", jdbcType=JdbcType.INTEGER),
        @Result(column="detail_content", property="detailContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PlanDetailDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_plan_id, detail_type, detail_content, begin_time, end_time, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_plan_details"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_plan_id", property="refPlanId", jdbcType=JdbcType.INTEGER),
        @Result(column="detail_type", property="detailType", jdbcType=JdbcType.INTEGER),
        @Result(column="detail_content", property="detailContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PlanDetailDomain> selectAll();

    @Update({
        "update sc_plan_details",
        "set ref_plan_id = #{refPlanId,jdbcType=INTEGER},",
          "detail_type = #{detailType,jdbcType=INTEGER},",
          "detail_content = #{detailContent,jdbcType=VARCHAR},",
          "begin_time = #{beginTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PlanDetailDomain record);
}