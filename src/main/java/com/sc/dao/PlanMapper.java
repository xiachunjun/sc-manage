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
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sc.dao.provider.PlanSqlProvider;
import com.sc.domain.Plan;

public interface PlanMapper {

	@Insert({
		"insert into sc_plans(",
				"ref_dept, ref_user, ref_position, plan_name, plan_type, plan_date, "
        		+ "plan_main_person, plan_content, plan_begin_time, plan_end_time,"
        		+ "rate_of_progress, progress_info, check_user, check_time,"
        		+ "data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{refDept,jdbcType=VARCHAR}, #{refUser,jdbcType=VARCHAR}, #{refPosition,jdbcType=VARCHAR}, ",
			"#{planName,jdbcType=VARCHAR}, #{planType,jdbcType=INTEGER}, #{planDate,jdbcType=TIMESTAMP}, ",
			"#{planMainPerson,jdbcType=VARCHAR}, #{planContent,jdbcType=VARCHAR}, #{planBeginTime,jdbcType=TIMESTAMP}, ",
			"#{planEndTime,jdbcType=TIMESTAMP}, #{rateOfProgress,jdbcType=VARCHAR}, #{progressInfo,jdbcType=VARCHAR}, ",
			"#{checkUser,jdbcType=VARCHAR}, #{checkTime,jdbcType=TIMESTAMP}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int savePlan(Plan record);

	
	@InsertProvider(type = PlanSqlProvider.class, method = "insertAll")  
	int batchInsert(@Param("list")List<Plan> list);

	
	@Select({
		"select p.id, p.ref_dept, p.ref_user, p.ref_position, p.plan_name, p.plan_type, p.plan_date, ",
			"p.plan_main_person, p.plan_content, p.plan_begin_time, p.plan_end_time, ",
			"p.rate_of_progress, p.progress_info, p.check_user, p.check_time ",
		"from sc_plans p ",	
		"where ${condition}"	
	})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept", property="refDept", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_user", property="refUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_position", property="refPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_name", property="planName", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_type", property="planType", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_date", property="planDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_main_person", property="planMainPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_content", property="planContent", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="plan_begin_time", property="planBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_end_time", property="planEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rate_of_progress", property="rateOfProgress", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="progressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_user", property="checkUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
	List<Plan> selectListByCondition(@Param("condition")String condition);
	
	
	@Select({
		"select p.id, p.ref_dept, p.ref_user, p.ref_position, p.plan_name, p.plan_type, p.plan_date, ",
			"p.plan_main_person, p.plan_content, p.plan_begin_time, p.plan_end_time, ",
			"p.rate_of_progress, p.progress_info, p.check_user, p.check_time ",
		"from sc_plans p ",	
		"where p.id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept", property="refDept", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_user", property="refUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_position", property="refPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_name", property="planName", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_type", property="planType", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_date", property="planDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_main_person", property="planMainPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_content", property="planContent", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="plan_begin_time", property="planBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_end_time", property="planEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rate_of_progress", property="rateOfProgress", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="progressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_user", property="checkUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
	Plan selectById(Integer id);
	
	
	@Select("<script>"
            + "select id, ref_dept, ref_user, ref_position, plan_name, plan_type, plan_date,"
            + "plan_main_person, plan_content, plan_begin_time, plan_end_time,"
            + "rate_of_progress, progress_info, check_user, check_time "
            + " from sc_plans where id in "
            + "<foreach item='item' index='index' collection='list' open='(' separator=',' close=')'>"
                + "#{item}"
            + "</foreach>"
        + "</script>")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_dept", property="refDept", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_user", property="refUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_position", property="refPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_name", property="planName", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_type", property="planType", jdbcType=JdbcType.INTEGER),
        @Result(column="plan_date", property="planDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_main_person", property="planMainPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_content", property="planContent", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="plan_begin_time", property="planBeginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="plan_end_time", property="planEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rate_of_progress", property="rateOfProgress", jdbcType=JdbcType.VARCHAR),
        @Result(column="progress_info", property="progressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_user", property="checkUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
	public List<Plan> selectListByIdList(@Param("list") List<Integer> list);
	
	
	@UpdateProvider(type = PlanSqlProvider.class, method = "updateById")  
	int updatePlanById(Plan record);
	
	
	@Delete({
		"delete from sc_plans where id=#{id,jdbcType=INTEGER}"
	})
	int deleteById(Integer id);
	
	
}
