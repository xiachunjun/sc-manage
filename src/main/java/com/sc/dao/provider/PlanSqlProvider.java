//package com.sc.dao.provider;
//
//import java.text.MessageFormat;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.jdbc.SQL;
//
//import com.sc.domain.Plan;
//
//public class PlanSqlProvider {
//
//	@SuppressWarnings("all")
//	public String insertAll(Map map) {  
//        List<Plan> list = (List<Plan>) map.get("list");  
//        StringBuilder sb = new StringBuilder();  
//        sb.append("insert into sc_plans ");  
//        sb.append("(ref_dept, ref_user, ref_position, plan_name, plan_type, plan_date, "
//        		+ "plan_main_person,"
//        		+ "rate_of_progress, progress_info, check_user, check_time,"
//        		+ "data_state, data_version, create_user, update_user, create_time, update_time) ");  
//        sb.append("values ");  
//        MessageFormat mf = new MessageFormat("(#'{'list[{0}].refDept}, #'{'list[{0}].refUser}, "
//        		+ "#'{'list[{0}].refPosition}, #'{'list[{0}].planName}, #'{'list[{0}].planType}, "
//        		+ "#'{'list[{0}].planDate}, #'{'list[{0}].planMainPerson}, "
//        		+ "#'{'list[{0}].rateOfProgress}, #'{'list[{0}].progressInfo}, #'{'list[{0}].checkUser}, "
//        		+ "#'{'list[{0}].checkTime}, #'{'list[{0}].dataState}, "
//        		+ "#'{'list[{0}].dataVersion}, #'{'list[{0}].createUser}, #'{'list[{0}].updateUser}, "
//        		+ "#'{'list[{0}].createTime}, #'{'list[{0}].updateTime} )");  
//        for (int i = 0; i < list.size(); i++) {  
//            sb.append(mf.format(new Object[]{i}));  
//            if (i < list.size() - 1) {  
//                sb.append(",");  
//            }  
//        }  
//        return sb.toString();  
//    }  
//	
//	
//	public String updateById(final Plan record){  
//		return new SQL() {{  
//			UPDATE("sc_plans");
//				if(record.getPlanType() != null) {  
//					SET("plan_type = #{planType,jdbcType=INTEGER}");  
//				}  
//				if(record.getUpdateUser() != null) {  
//					SET("update_user=#{updateUser,jdbcType=VARCHAR}");  
//				}
//				SET("update_time=now()");
//			WHERE("id=#{id,jdbcType=INTEGER}");  
//		}}.toString();  
//	} 
//	
//	
//	
//}
