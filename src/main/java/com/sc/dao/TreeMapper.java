package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Tree;

public interface TreeMapper {

	@Select({
		"select ",
			"tid, pid, name, url, is_parent, data_state ",
		"from sc_tree ",
		"where data_state=1"
	})
	@Results({
	    @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
	    @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	    @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
	    @Result(column="is_parent", property="isParent", jdbcType=JdbcType.BOOLEAN),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Tree> queryAllTree();

	
	@Select({
		"select ",
			"tid, pid, name, url, is_parent, data_state ",
		"from sc_tree ",
		"where data_state=1 and pid=#{pid, jdbcType=INTEGER}"
	})
	@Results({
	    @Result(column="tid", property="tid", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
	    @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	    @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
	    @Result(column="is_parent", property="isParent", jdbcType=JdbcType.BOOLEAN),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Tree> queryShowTreeNodeByPid(@Param("pid")Integer pid);
	
	
}
