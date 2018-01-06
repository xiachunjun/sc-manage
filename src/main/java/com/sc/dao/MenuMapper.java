package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Menu;

public interface MenuMapper {

	@Select({
		"select ",
			"id, menu_code, parent_menu_code, menu_name, menu_url, menu_sort_order, is_parent, data_state ",
		"from sc_menus ",
		"where data_state=1 and is_parent=1"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_menu_code", property="parentMenuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_url", property="menuUrl", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_sort_order", property="menuSortOrder", jdbcType=JdbcType.INTEGER),
	    @Result(column="is_parent", property="isParent", jdbcType=JdbcType.TINYINT),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Menu> queryParentMenutList();

	
	@Select({
		"select ",
			"id, menu_code, parent_menu_code, menu_name, menu_url, menu_sort_order, is_parent, data_state ",
		"from sc_menus ",
		"where data_state=1 and parent_menu_code=#{parentMenuCode, jdbcType=VARCHAR}"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_menu_code", property="parentMenuCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_url", property="menuUrl", jdbcType=JdbcType.VARCHAR),
	    @Result(column="menu_sort_order", property="menuSortOrder", jdbcType=JdbcType.INTEGER),
	    @Result(column="is_parent", property="isParent", jdbcType=JdbcType.TINYINT),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Menu> queryMenutListByParentMenuCode(@Param("parentMenuCode")String parentMenuCode);

	
	
}
