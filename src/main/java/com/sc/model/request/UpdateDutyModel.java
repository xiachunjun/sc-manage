package com.sc.model.request;

public class UpdateDutyModel {

	private Integer id;
	
	//职责内容
	private String dutyIntroduce;

	public Integer getId() {
		return id;
	}

	public String getDutyIntroduce() {
		return dutyIntroduce;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDutyIntroduce(String dutyIntroduce) {
		this.dutyIntroduce = dutyIntroduce;
	}
	
	
}
