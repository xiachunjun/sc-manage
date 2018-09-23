package com.sc.model.response;

import java.util.List;
import java.util.Map;

import com.sc.domain.DepartmentDomain;
import com.sc.domain.PositionDomain;
import com.sc.domain.UserDomain;

public class DutyResult {

	DepartmentDomain dept;
	List<PositionDomain> posis;
	// user中的key是posi的id
	Map<String, UserDomain> userMap;

	public DepartmentDomain getDept() {
		return dept;
	}

	public void setDept(DepartmentDomain dept) {
		this.dept = dept;
	}

	public List<PositionDomain> getPosis() {
		return posis;
	}

	public void setPosis(List<PositionDomain> posis) {
		this.posis = posis;
	}

	public Map<String, UserDomain> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, UserDomain> userMap) {
		this.userMap = userMap;
	}

}
