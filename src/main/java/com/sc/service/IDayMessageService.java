package com.sc.service;

import java.util.Map;

import com.sc.model.request.DayMessageModel;

public interface IDayMessageService {

	/**
	 * 保存每日信息
	 * @param dayMessageModel
	 */
	void saveDayMessage(DayMessageModel dayMessageModel);

	/**
	 * 查询所有每日信息列表
	 * @param day
	 * @return
	 */
	Map<String, Object> queryAllDayMessage(String day);

	
}
