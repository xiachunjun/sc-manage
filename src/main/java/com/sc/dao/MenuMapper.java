package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Menu;

public interface MenuMapper {

	@Insert({
		"insert into sc_menus(",
			"menu_code, menu_name, menu_level, partent_code, rel_resouce_code,",
			"data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{menuCode,jdbcType=VARCHAR}, #{menuName,jdbcType=VARCHAR}, #{menuLevel,jdbcType=VARCHAR},",
			"#{parentCode,jdbcType=VARCHAR}, #{relResouceCode,jdbcType=VARCHAR}, #{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveMenu(Menu record);
	
	
	@Select({
		"select id, menu_code, menu_name, menu_level, partent_code, rel_resouce_code, data_memo, data_state ",
		"from sc_menus ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_level", property="menuLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="partent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_resouce_code", property="relResouceCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Menu> queryMenuList();
	
	
	@Select({
		"select id, menu_code, menu_name, menu_level, partent_code, rel_resouce_code, data_memo, data_state ",
		"from sc_menus ",
		"where data_state=1 and id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_level", property="menuLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="partent_code", property="parentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_resouce_code", property="relResouceCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	Menu queryMenuById(Integer id);
	
	
	@Delete({
		"delete from sc_menus where id=#{id,jdbcType=INTEGER}"
	})
	int deleteMenuById(Integer id);
	
	
}
