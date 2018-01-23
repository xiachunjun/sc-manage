//package com.sc.dao.provider;
//
//import org.apache.ibatis.jdbc.SQL;
//
//import com.sc.domain.Position;
//
//public class PositionSqlProvider {
//
//	public String updatePosition(final Position position){  
//		return new SQL() {{  
//			UPDATE("sc_positions");
//				if(position.getRefDeptCode() != null) {  
//					SET("ref_department = #{refDeptCode,jdbcType=VARCHAR}");  
//				}  
//				if(position.getUpdateUser() != null) {  
//					SET("update_user=#{updateUser,jdbcType=VARCHAR}");  
//				}
//				SET("update_time=now()");
//			WHERE("id=#{id,jdbcType=INTEGER}");  
//		}}.toString();  
//	} 
//	
//}
