package com.sc.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.sc.domain.Position;

public class PositionSqlProvider {

	public String updatePosition(final Position position){  
		return new SQL() {{  
			UPDATE("sc_positions");
				if(position.getPositionCode() != null) {  
					SET("position_code = #{positionCode,jdbcType=VARCHAR}");  
				}
				if(position.getRefDepartmentCode() != null) {  
					SET("ref_department_code = #{refDepartmentCode,jdbcType=VARCHAR}");  
				}  
				if(position.getRefUserCode() != null) {  
					SET("ref_user_code=#{refUserCode,jdbcType=VARCHAR}");  
				}
				if(position.getUpdateUser() != null) {  
					SET("update_user=#{updateUser,jdbcType=VARCHAR}");  
				}
				SET("update_time=now()");
			WHERE("id=#{id,jdbcType=INTEGER}");  
		}}.toString();  
	} 
	
}
