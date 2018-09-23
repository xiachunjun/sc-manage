//package com.sc.dao.provider;
//
//import org.apache.ibatis.jdbc.SQL;
//
//import com.sc.domain.Bylaw;
//
//public class BylawSqlProvider {
//
//	public String updateBylaw(final Bylaw bylaw){  
//		return new SQL() {{  
//			UPDATE("sc_bylaws");
//				if(bylaw.getBylawsCategory() != null) {  
//					SET("bylaws_category = #{bylawsCategory,jdbcType=VARCHAR}");  
//				}
//				if(bylaw.getBylawsName() != null) {  
//					SET("bylaws_name = #{bylawsName,jdbcType=VARCHAR}");  
//				}  
//				if(bylaw.getBylawsNo() != null) {  
//					SET("bylaws_no=#{bylawsNo,jdbcType=VARCHAR}");  
//				}
//				if(bylaw.getArticleNo() != null) {  
//					SET("article_no=#{articleNo,jdbcType=VARCHAR}");  
//				}
//				if(bylaw.getArticleTime() != null) {  
//					SET("article_time=#{articleTime,jdbcType=TIMESTAMP}");  
//				}
//				if(bylaw.getBylawsContent() != null) {  
//					SET("bylaws_content=#{bylawsContent,jdbcType=VARCHAR}");  
//				}
//				if(bylaw.getFileUrl() != null) {  
//					SET("file_url=#{fileUrl,jdbcType=VARCHAR}");  
//				}
//				if(bylaw.getUpdateUser() != null) {  
//					SET("update_user=#{updateUser,jdbcType=VARCHAR}");  
//				}
//				SET("update_time=now()");
//			WHERE("id=#{id,jdbcType=INTEGER}");  
//		}}.toString();  
//	} 
//	
//}
