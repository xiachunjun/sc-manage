DROP TABLE IF EXISTS `sc_bylaws`;
CREATE TABLE `sc_bylaws` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`bylaws_name` varchar(255) DEFAULT NULL COMMENT '名称',
	`bylaws_no` varchar(100) DEFAULT NULL COMMENT '编号',
	`article_no` varchar(100) DEFAULT NULL COMMENT '发文文号',
	`article_time` datetime DEFAULT NULL COMMENT '发文时间',
	`bylaws_content` longtext DEFAULT NULL COMMENT '规章制度内容',
	`file_url` varchar(255) DEFAULT NULL COMMENT '（如果不直接保存内容，则以文件或页面的形式保存）',
	`bylaws_category` varchar(50) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_companys`;
CREATE TABLE `sc_companys` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`company_code` varchar(50) DEFAULT NULL,
	`company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
	`company_type` varchar(100) DEFAULT NULL COMMENT '类型',
	`org_code` varchar(100) DEFAULT NULL COMMENT '组织结构代码',
	`credit_code` varchar(100) DEFAULT NULL COMMENT '社会统一征信码',
	`legal_person_name` varchar(100) DEFAULT NULL COMMENT '法人姓名',
	`legal_person_id_card` varchar(100) DEFAULT NULL COMMENT '法人身份证',
	`data_memo` varchar(1000) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_departments`;
CREATE TABLE `sc_departments` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_cpn_code` varchar(50) DEFAULT NULL COMMENT '所属公司',
	`dept_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
	`dept_type` int(11) DEFAULT NULL COMMENT '类型',
	`dept_level` int(11) DEFAULT NULL COMMENT '级别',
	`parent_id` int(11) DEFAULT NULL COMMENT '上级部门code',
	`data_memo` varchar(1000) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_duty`;
CREATE TABLE `sc_duty` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_dept_id` int(11) DEFAULT NULL,
	`ref_posi_id` int(11) DEFAULT NULL,
	`duty_type` varchar(50) DEFAULT NULL COMMENT '职责类型（DEPT-部门职责，POSI-岗位职责）',
	`duty_level` varchar(50) DEFAULT NULL COMMENT '级别（1-一级职责，2-二级职责）',
	`duty_name` varchar(100) DEFAULT NULL COMMENT '名称',
	`duty_introduce` varchar(500) DEFAULT NULL COMMENT '描述',
	`parent_id` int(11) DEFAULT NULL COMMENT '父code',
	`data_memo` varchar(255) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_plan_details`;
CREATE TABLE `sc_plan_details` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_plan_id` int(11) DEFAULT NULL COMMENT 'sc_plans表的id',
	`detail_type` int(11) DEFAULT NULL COMMENT '工作类型',
	`detail_content` varchar(2000) DEFAULT NULL COMMENT '计划内容',
	`begin_time` datetime DEFAULT NULL COMMENT '开始时间',
	`end_time` datetime DEFAULT NULL COMMENT '结束时间',
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
	`ref_user_id` int(11) DEFAULT NULL COMMENT '责任人',
	`ref_posi_id` int(11) DEFAULT NULL COMMENT '岗位',
	`ref_dept_id` int(11) DEFAULT NULL COMMENT '所属部门',
	`plan_name` varchar(255) DEFAULT NULL COMMENT '计划名称',
	`plan_type` int(11) DEFAULT NULL COMMENT '计划类型',
	`plan_date` datetime DEFAULT NULL COMMENT '计划创建日期',
	`plan_main_user` int(11) DEFAULT NULL COMMENT '执行人',
	`rate_of_progress` varchar(255) DEFAULT NULL COMMENT '计划完成度',
	`progress_info` varchar(500) DEFAULT NULL COMMENT '完成情况',
	`check_user` int(11) DEFAULT NULL COMMENT '审核人',
	`check_time` datetime DEFAULT NULL COMMENT '审核时间',
	`data_state` int(11) DEFAULT NULL COMMENT '0-失效；1-初始；2-待领导审批；3-领导审核通过待执行人执行；4-领导审核不通过；5-执行人执行完成',
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_positions`;
CREATE TABLE `sc_positions` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_dept_id` int(11) DEFAULT NULL COMMENT '所属部门',
	`posi_name` varchar(255) DEFAULT NULL COMMENT '岗位名称',
	`posi_introduce` varchar(255) DEFAULT NULL COMMENT '岗位描述',
	`data_memo` varchar(255) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_user_posi_rel`;
CREATE TABLE `sc_user_posi_rel` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_user_id` int(11) DEFAULT NULL COMMENT '用户id',
	`ref_posi_id` int(11) DEFAULT NULL COMMENT '岗位id',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL COMMENT '标识是否为岗位责任人0-否，1-是',
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_users`;
CREATE TABLE `sc_users` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
	`user_login_pwd` varchar(255) DEFAULT NULL COMMENT '密码',
	`user_id_card` varchar(50) DEFAULT NULL COMMENT '身份证号',
	`user_name` varchar(20) DEFAULT NULL COMMENT '姓名',
	`user_nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
