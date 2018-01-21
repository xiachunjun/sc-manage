package com.sc.dao;

import com.sc.domain.User;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from sc_users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_users (user_code, ",
        	"user_login_name, user_login_pwd, ",
        	"user_id_card, user_name, user_nickname, ref_dept, ref_posi,",
        	"data_state, data_version, create_user, ",
        	"update_user, create_time, update_time)",
        "values (#{userCode,jdbcType=VARCHAR}, ",
        	"#{userLoginName,jdbcType=VARCHAR}, #{userLoginPwd,jdbcType=VARCHAR}, ",
        	"#{userIdCard,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        	"#{userNickname,jdbcType=VARCHAR}, #{refDept,jdbcType=VARCHAR}, #{refPosi,jdbcType=VARCHAR},",
        	"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        	"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(User record);

    @Select({
        "select",
        "id, user_code, user_login_name, user_login_pwd, user_id_card, user_name, user_nickname, ",
        "data_state, data_version, create_user, update_user, create_time, update_time",
        "from sc_users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_pwd", property="userLoginPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id_card", property="userIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_code, user_login_name, user_login_pwd, user_id_card, user_name, user_nickname, ",
        "data_state, data_version, create_user, update_user, create_time, update_time ",
        "from sc_users"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_pwd", property="userLoginPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id_card", property="userIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

    @Update({
        "update sc_users",
        "set user_code = #{userCode,jdbcType=VARCHAR},",
          "user_login_name = #{userLoginName,jdbcType=VARCHAR},",
          "user_login_pwd = #{userLoginPwd,jdbcType=VARCHAR},",
          "user_id_card = #{userIdCard,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    
    @Select({
    	"select data_state from sc_users where user_login_name = #{userLoginName,jdbcType=VARCHAR}"
    })
    @Results({
    	@Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
    User selectUserLoginNameIsExist(@Param("userLoginName")String userLoginName);
    
    
    @Select({
        "select",
        	"id, user_code, user_login_name, user_login_pwd, user_id_card, user_name, user_nickname,ref_dept,ref_posi ",
        "from sc_users ",
        "where data_state=1 and user_login_name = #{userLoginName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_pwd", property="userLoginPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id_card", property="userIdCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_dept", property="refDept", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_posi", property="refPosi", jdbcType=JdbcType.VARCHAR)
    })
	User selectUserByLoginName(@Param("userLoginName")String userLoginName);

	
    
    @Select({
        "select",
        	"id, user_code, user_login_name, user_name, user_nickname, data_state ",
        "from sc_users ",
        "where data_state=1"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectUserList();

    
    @Select({
    	"select max(user_code) from sc_users"
    })
    Integer getMaxCode();

    
    @Update({
    	"update sc_users set ",
    		"user_login_pwd=#{userLoginPwd,jdbcType=VARCHAR}, ",
    		"update_time = now() ",
    	"where id=#{id,jdbcType=INTEGER}"
    })
	int updatePwdById(@Param("id")Integer id, @Param("userLoginPwd")String encryptPwd);
    
	
}