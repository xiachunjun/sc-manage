DROP TABLE IF EXISTS `sc_articles`;
CREATE TABLE `sc_articles` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`article_link_user` varchar(50) DEFAULT NULL COMMENT '联系人',
	`link_user_check_state` int(50) DEFAULT NULL COMMENT '联系人审核状态（0-初始，1-通过，2-拒绝）',
	`article_link_user_phone` varchar(50) DEFAULT NULL COMMENT '联系人手机号',
	`article_sign_user` varchar(50) DEFAULT NULL COMMENT '签发人',
	`sign_user_check_state` varchar(50) DEFAULT NULL COMMENT '签发状态（0-初始，1-通过，2-拒绝）',
	`secrecy_level` varchar(50) DEFAULT NULL COMMENT '保密级别',
	`article_time` datetime DEFAULT NULL COMMENT '文章时间',
	`article_title` varchar(500) DEFAULT NULL COMMENT '标题',
	`article_content` longtext DEFAULT NULL COMMENT '内容',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;


DROP TABLE IF EXISTS `sc_bylaws`;
CREATE TABLE `sc_bylaws` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`bylaws_code` varchar(50) DEFAULT NULL COMMENT 'code',
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
	`ref_company_code` varchar(50) DEFAULT NULL,
	`department_code` varchar(50) DEFAULT NULL COMMENT 'code',
	`department_name` varchar(100) DEFAULT NULL,
	`department_type` varchar(100) DEFAULT NULL COMMENT '类型',
	`department_level` varchar(100) DEFAULT NULL COMMENT '级别',
	`parent_department_code` varchar(50) DEFAULT NULL COMMENT '上级部门code',
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
	`duty_code` varchar(50) DEFAULT NULL,
	`ref_department_code` varchar(50) DEFAULT NULL,
	`ref_position_code` varchar(50) DEFAULT NULL,
	`duty_type` varchar(50) DEFAULT NULL COMMENT '职责类型（DEPT-部门职责，POSI-岗位职责）',
	`duty_level` varchar(50) DEFAULT NULL COMMENT '级别（1-一级职责，2-二级职责）',
	`duty_name` varchar(100) DEFAULT NULL COMMENT '名称',
	`duty_introduce` varchar(500) DEFAULT NULL COMMENT '描述',
	`parent_code` varchar(50) DEFAULT NULL COMMENT '父code',
	`data_memo` varchar(255) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_positions`;
CREATE TABLE `sc_positions` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`ref_department_code` varchar(50) DEFAULT NULL COMMENT '所属部门',
	`position_code` varchar(50) DEFAULT NULL,
	`position_name` varchar(255) DEFAULT NULL,
	`position_introduce` varchar(255) DEFAULT NULL,
	`data_memo` varchar(255) DEFAULT NULL,
	`ref_user_code` varchar(50) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_users`;
CREATE TABLE `sc_users` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_code` varchar(50) DEFAULT NULL COMMENT '用户代码',
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
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;




