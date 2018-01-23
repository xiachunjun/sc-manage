package com.sc.dao;

import com.sc.domain.DepartmentDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DepartmentMapper {
    @Delete({
        "delete from sc_departments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_departments (id, ref_cpn_code, ",
        "dept_name, dept_type, ",
        "dept_level, parent_id, ",
        "data_memo, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{refCpnCode,jdbcType=VARCHAR}, ",
        "#{deptName,jdbcType=VARCHAR}, #{deptType,jdbcType=INTEGER}, ",
        "#{deptLevel,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{dataMemo,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(DepartmentDomain record);

    @Select({
        "select",
        "id, ref_cpn_code, dept_name, dept_type, dept_level, parent_id, data_memo, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_departments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_cpn_code", property="refCpnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_type", property="deptType", jdbcType=JdbcType.INTEGER),
        @Result(column="dept_level", property="deptLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    DepartmentDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, ref_cpn_code, dept_name, dept_type, dept_level, parent_id, data_memo, data_state, ",
        "data_version, create_user, update_user, create_time, update_time",
        "from sc_departments "
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_cpn_code", property="refCpnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_type", property="deptType", jdbcType=JdbcType.INTEGER),
        @Result(column="dept_level", property="deptLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DepartmentDomain> selectAll();

    @Select({
        "select",
        "id, ref_cpn_code, dept_name, dept_type, dept_level, parent_id, data_memo, data_state ",
        "from sc_departments where data_state= #{dataState,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ref_cpn_code", property="refCpnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_type", property="deptType", jdbcType=JdbcType.INTEGER),
        @Result(column="dept_level", property="deptLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
    List<DepartmentDomain> queryByDataState(@Param("dataState") Integer dataState);
    
    @Update({
        "update sc_departments",
        "set ref_cpn_code = #{refCpnCode,jdbcType=VARCHAR},",
          "dept_name = #{deptName,jdbcType=VARCHAR},",
          "dept_type = #{deptType,jdbcType=INTEGER},",
          "dept_level = #{deptLevel,jdbcType=INTEGER},",
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
    int updateByPrimaryKey(DepartmentDomain record);
}