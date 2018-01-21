ALTER TABLE `sc_users`
 ADD COLUMN `ref_dept` VARCHAR (50) COMMENT '所属部门' AFTER `user_nickname`,
 ADD COLUMN `ref_posi` VARCHAR (50) COMMENT '所属岗位' AFTER `ref_dept`,
 CHANGE COLUMN `data_state` `data_state` INT (11) DEFAULT NULL AFTER `ref_posi`,
 CHANGE COLUMN `data_version` `data_version` INT (11) DEFAULT NULL AFTER `data_state`,
 CHANGE COLUMN `create_user` `create_user` VARCHAR (50) DEFAULT NULL AFTER `data_version`,
 CHANGE COLUMN `update_user` `update_user` VARCHAR (50) DEFAULT NULL AFTER `create_user`,
 CHANGE COLUMN `create_time` `create_time` DATETIME DEFAULT NULL AFTER `update_user`,
 CHANGE COLUMN `update_time` `update_time` DATETIME DEFAULT NULL AFTER `create_time`;
 
 
 
 ALTER TABLE `sc_departments` ADD COLUMN `ref_user_code` VARCHAR (50) COMMENT '部门负责人' AFTER `id`,
 CHANGE COLUMN `ref_company_code` `ref_company_code` VARCHAR (50) DEFAULT NULL AFTER `ref_user_code`,
 CHANGE COLUMN `department_code` `department_code` VARCHAR (50) DEFAULT NULL COMMENT 'code' AFTER `ref_company_code`,
 CHANGE COLUMN `department_name` `department_name` VARCHAR (100) DEFAULT NULL AFTER `department_code`,
 CHANGE COLUMN `department_type` `department_type` VARCHAR (100) DEFAULT NULL COMMENT '类型' AFTER `department_name`,
 CHANGE COLUMN `department_level` `department_level` VARCHAR (100) DEFAULT NULL COMMENT '级别' AFTER `department_type`,
 CHANGE COLUMN `parent_department_code` `parent_department_code` VARCHAR (50) DEFAULT NULL COMMENT '上级部门code' AFTER `department_level`,
 CHANGE COLUMN `data_memo` `data_memo` VARCHAR (1000) DEFAULT NULL COMMENT '备注' AFTER `parent_department_code`,
 CHANGE COLUMN `data_state` `data_state` INT (11) DEFAULT NULL AFTER `data_memo`,
 CHANGE COLUMN `data_version` `data_version` INT (11) DEFAULT NULL AFTER `data_state`,
 CHANGE COLUMN `create_user` `create_user` VARCHAR (50) DEFAULT NULL AFTER `data_version`,
 CHANGE COLUMN `update_user` `update_user` VARCHAR (50) DEFAULT NULL AFTER `create_user`,
 CHANGE COLUMN `create_time` `create_time` DATETIME DEFAULT NULL AFTER `update_user`,
 CHANGE COLUMN `update_time` `update_time` DATETIME DEFAULT NULL AFTER `create_time`;