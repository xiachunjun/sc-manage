package com.sc.dao.provider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.sc.domain.DataRecord;

public class DataRecordSqlProvider {

	@SuppressWarnings("all")
	public String insertAll(Map map) {  
        List<DataRecord> list = (List<DataRecord>) map.get("list");  
        StringBuilder sb = new StringBuilder();  
        sb.append("insert into sc_data_records ");  
        sb.append("(ref_dept_code, record_type, record_time, record_name, record_unit,record_value, "
        		+ "target_value, rate_of_progress, progress_info, record_memo,"
        		+ "data_state, data_version, create_user, update_user, create_time, update_time) ");  
        sb.append("values ");  
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].refDeptCode}, #'{'list[{0}].recordType}, "
        		+ "#'{'list[{0}].recordTime}, #'{'list[{0}].recordName}, #'{'list[{0}].recordUnit}, "
        		+ "#'{'list[{0}].recordValue}, #'{'list[{0}].targetValue}, #'{'list[{0}].rateOfProgress}, "
        		+ "#'{'list[{0}].progressInfo}, #'{'list[{0}].recordMemo}, #'{'list[{0}].dataState}, "
        		+ "#'{'list[{0}].dataVersion}, #'{'list[{0}].createUser}, #'{'list[{0}].updateUser}, "
        		+ "#'{'list[{0}].createTime}, #'{'list[{0}].updateTime} )");  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(mf.format(new Object[]{i}));  
            if (i < list.size() - 1) {  
                sb.append(",");  
            }  
        }  
        return sb.toString();  
    }  
	
	
//	@SuppressWarnings("all")
//	public String updateAll(Map map) {
//        List<DataRecord> list = (List<DataRecord>) map.get("list");
//        StringBuilder sb = new StringBuilder();
//        sb.append("update sc_data_records ");
//        sb.append("set record_value=case id ");
//        MessageFormat mf = new MessageFormat("#'{'list[{0}].record_value'}'");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append("when ");
//            sb.append(list.get(i).getId());
//            sb.append("then ");
//            sb.append(mf.format(new Object[]{i}));
//        }
//        sb.append("end ");
//        sb.append("where id in");
//        sb.append("(");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i).getId());
//            if (i < list.size() - 1) {
//                sb.append(",");
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//	}
	
	
	
}
