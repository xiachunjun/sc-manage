CREATE DATABASE IF NOT EXISTS sc_manage DEFAULT CHARSET utf8 COLLATE utf8_bin;

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

INSERT INTO `sc_companys` (`company_code`, `company_name`, `company_type`, `org_code`, `credit_code`, `legal_person_name`, `legal_person_id_card`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '所部', '1', 'ORG01', 'ZXDM100200300', '张三', '321181199001094000', '备注内容', '1', '1', 'SYS', 'SYS', now(), now());

INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000001', '所办公室', '1', '1', '00000001', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000002', '经营计划部', '1', '1', '00000002', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000003', '科技质量部', '1', '1', '00000003', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000004', '产业发展部', '1', '1', '00000004', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000005', '条件保障部', '1', '1', '00000005', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000006', '人力资源部', '1', '1', '00000006', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000007', '财务部', '1', '1', '00000007', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000008', '党群工作部', '1', '1', '00000008', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000009', '审计部', '1', '1', '00000009', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000010', '监察部', '1', '1', '00000010', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000011', '所保密办公室', '1', '1', '00000011', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000012', '战略研究部', '2', '1', '00000012', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000013', '战斗舰艇研究设计事业部', '2', '1', '00000013', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000014', '辅助舰船研究设计事业部', '2', '1', '00000014', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000015', '民用船舶研究设计事业部', '2', '1', '00000015', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000016', '海洋工程及工程船研究设计事业部', '2', '1', '00000016', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000017', '船舶推进事业部', '2', '1', '00000017', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000018', '基础研究部', '2', '1', '00000018', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000019', '档案信息部', '2', '1', '00000019', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000020', '信息技术部', '2', '1', '00000020', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000021', '喷水推进技术重点实验', '3', '1', '00000021', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000022', '上海市船舶工程重点实验室', '3', '1', '00000022', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000023', '上海中船船舶设计技术国家工程研究中心有限公司', '4', '1', '00000023', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000024', '上海海迅机电工程有限公司', '4', '1', '00000024', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000025', '上海海勤物业管理有限公司', '4', '1', '00000025', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000026', '上海船舶及海洋设计研究有限公司', '4', '1', '00000026', null, '1', '1', 'SYS', 'SYS', null, null);
INSERT INTO `sc_departments` (`ref_company_code`, `department_code`, `department_name`, `department_type`, `department_level`, `parent_department_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ( '00000001', '00000027', '上海淞园船舶科技学术交流中心', '4', '1', '00000027', null, '1', '1', 'SYS', 'SYS', null, null);

INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000001', null, 'DEPT', '1', '负责部门职能范围内的规章制度的编制与维护', '负责部门职能范围内的规章制度的编制与维护', '00000001', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000002', '00000001', null, 'DEPT', '1', '归口管理全所日常保密工作', '归口管理全所日常保密工作', '00000002', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000003', '00000001', null, 'DEPT', '1', '负责制度的建设和体系维护', '负责制度的建设和体系维护', '00000003', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000004', '00000001', null, 'DEPT', '2', '组织编制完善', '组织编制完善', '00000003', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000005', '00000001', '', 'DEPT', '2', '负责安全保密', '负责安全保密', '00000003', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000006', '', '00000001', 'POSI', '1', '【岗位职责】负责岗位职能范围内的规章制度的编制与维护', '【岗位职责】负责岗位职能范围内的规章制度的编制与维护', '00000001', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000007', '', '00000001', 'POSI', '1', '归口管理全所日常保密工作', '【岗位职责】归口管理全所日常保密工作', '00000002', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000008', '', '00000001', 'POSI', '1', '负责制度的建设和体系维护', '【岗位职责】负责制度的建设和体系维护', '00000008', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000009', '', '00000001', 'POSI', '2', '组织编制完善', '【岗位职责】组织编制完善', '00000008', null, '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_duty` (`duty_code`, `ref_department_code`, `ref_position_code`, `duty_type`, `duty_level`, `duty_name`, `duty_introduce`, `parent_code`, `data_memo`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000010', '', '00000001', 'POSI', '2', '负责安全保密', '【岗位职责】负责安全保密', '00000008', null, '1', '1', 'SYS', 'SYS', now(), now());

INSERT INTO `sc_positions` (`ref_department_code`, `position_code`, `position_name`, `position_introduce`, `data_memo`, `ref_user_code`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000001', '保密员A', '保密工作A部分', null, '00000003', '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_positions` (`ref_department_code`, `position_code`, `position_name`, `position_introduce`, `data_memo`, `ref_user_code`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000002', '保密员B', '保密工作B部分', null, '00000001', '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_positions` (`ref_department_code`, `position_code`, `position_name`, `position_introduce`, `data_memo`, `ref_user_code`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000001', '00000003', '保密员C', '保密工作C部分', null, '00000002', '1', '1', 'SYS', 'SYS',now(), now());
INSERT INTO `sc_positions` (`ref_department_code`, `position_code`, `position_name`, `position_introduce`, `data_memo`, `ref_user_code`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000007', '00000004', '材料员', '会计材料处理', null, '00000004', '1', '1', 'SYS', 'SYS', now(), now());
INSERT INTO `sc_positions` (`ref_department_code`, `position_code`, `position_name`, `position_introduce`, `data_memo`, `ref_user_code`, `data_state`, `data_version`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('00000012', '00000005', '战略规划总监', '领导战略规划组工作', null, '00000004', '1', '1', 'SYS', 'SYS', now(), now());




