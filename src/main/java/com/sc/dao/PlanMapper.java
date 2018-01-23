package com.sc.dao;

import com.sc.domain.PlanDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PlanMapper {
    @Delete({
        "delete from sc_plans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_plans (id, ref_user_id, ",
        "ref_posi_id, ref_dept_id, ",
        "plan_name, plan_type, ",
        "plan_date, plan_main_user, ",
        "rate_of_progress, progress_info, ",
        "check_user, check_time, ",
        "data_state, data_version, ",
        "create_user, update_user, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refUserId,jdbcType=INTEGER}, ",
        "#{refPosiId,jdbcType=INTEGER}, #{refDeptId,jdbcType=INTEGER}, ",
        "#{planName,jdbcType=VARCHAR}, #{planType,jdbcType=INTEGER}, ",
        "#{planDate,jdbcType=TIMESTAMP}, #{planMainUser,jdbcType=INTEGER}, ",
        "#{rateOfProgress,jdbcType=VARCHAR}, #{progressInfo,jdbcType=VARCHAR}, ",
        "#{checkUser,jdbcType=INTEGER}, #{checkTime,jdbcType=TIMESTAMP}, ",
        "#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PlanDomain record);

    @Select({
        "select",
        "id, ref_user_id, ref_posi_id, ref_dept_id, plan_name, plan_type, plan_date, ",
        "plan_main_user, rate_of_progress, progress_info, check_user, check_time, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_plans",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_user_id", property="refUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_name", property="planName", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_type", property="planType", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_date", property="planDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_main_user", property="planMainUser", jdbcType=JdbcType.INTEGER),
        @Result(column="rate_of_progress", property="rateOfProgress", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="progressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_user", property="checkUser", jdbcType=JdbcType.INTEGER),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PlanDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_user_id, ref_posi_id, ref_dept_id, plan_name, plan_type, plan_date, ",
        "plan_main_user, rate_of_progress, progress_info, check_user, check_time, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_plans"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_user_id", property="refUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_posi_id", property="refPosiId", jdbcType=JdbcType.INTEGER),
        @Result(column="ref_dept_id", property="refDeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_name", property="planName", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_type", property="planType", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_date", property="planDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_main_user", property="planMainUser", jdbcType=JdbcType.INTEGER),
        @Result(column="rate_of_progress", property="rateOfProgress", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="progressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_user", property="checkUser", jdbcType=JdbcType.INTEGER),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PlanDomain> selectAll();

    @Update({
        "update sc_plans",
        "set ref_user_id = #{refUserId,jdbcType=INTEGER},",
          "ref_posi_id = #{refPosiId,jdbcType=INTEGER},",
          "ref_dept_id = #{refDeptId,jdbcType=INTEGER},",
          "plan_name = #{planName,jdbcType=VARCHAR},",
          "plan_type = #{planType,jdbcType=INTEGER},",
          "plan_date = #{planDate,jdbcType=TIMESTAMP},",
          "plan_main_user = #{planMainUser,jdbcType=INTEGER},",
          "rate_of_progress = #{rateOfProgress,jdbcType=VARCHAR},",
          "progress_info = #{progressInfo,jdbcType=VARCHAR},",
          "check_user = #{checkUser,jdbcType=INTEGER},",
          "check_time = #{checkTime,jdbcType=TIMESTAMP},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PlanDomain record);
}