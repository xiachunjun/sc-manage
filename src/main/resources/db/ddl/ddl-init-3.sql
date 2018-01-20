
DROP TABLE IF EXISTS `sc_data_records`;
CREATE TABLE `sc_data_records` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_dept_code` varchar(50) DEFAULT NULL COMMENT '所属部门code',
	`record_type` int(11) DEFAULT NULL COMMENT '数据类型（1-默认）',
	`record_time` datetime DEFAULT NULL COMMENT '数据时间',
	`record_name` varchar(255) DEFAULT NULL COMMENT '指标名称',
	`record_unit` int(11) DEFAULT NULL COMMENT '计量单位（1-百分比，2-亿元，3-美元，4-元）',
	`record_value` float DEFAULT NULL COMMENT '指标值',
	`target_value` float DEFAULT NULL,
	`rate_of_progress` varchar(255) DEFAULT NULL COMMENT '完成度',
	`progress_info` varchar(500) DEFAULT NULL COMMENT '完成情况',
	`record_memo` varchar(255) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;



DROP TABLE IF EXISTS `sc_plans`;
CREATE TABLE `sc_plans` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_dept_code` varchar(50) DEFAULT NULL COMMENT '所属部门',
	`plan_name` varchar(255) DEFAULT NULL COMMENT '计划名称',
	`plan_type` int(11) DEFAULT NULL COMMENT '计划类型',
	`plan_date` datetime DEFAULT NULL COMMENT '计划创建日期',
	`plan_main_person` varchar(255) DEFAULT NULL COMMENT '责任人',
	`plan_content` longtext DEFAULT NULL COMMENT '计划内容',
	`plan_begin_time` datetime DEFAULT NULL COMMENT '计划开始时间',
	`plan_end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
	`rate_of_progress` varchar(255) DEFAULT NULL COMMENT '计划完成度',
	`progress_info` varchar(500) DEFAULT NULL COMMENT '完成情况',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;