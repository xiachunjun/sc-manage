ALTER TABLE `sc_users`
 ADD COLUMN `ref_dept` VARCHAR (50) COMMENT '所属部门' AFTER `user_nickname`,
 ADD COLUMN `ref_posi` VARCHAR (50) COMMENT '所属岗位' AFTER `ref_dept`,
 CHANGE COLUMN `data_state` `data_state` INT (11) DEFAULT NULL AFTER `ref_posi`,
 CHANGE COLUMN `data_version` `data_version` INT (11) DEFAULT NULL AFTER `data_state`,
 CHANGE COLUMN `create_user` `create_user` VARCHAR (50) DEFAULT NULL AFTER `data_version`,
 CHANGE COLUMN `update_user` `update_user` VARCHAR (50) DEFAULT NULL AFTER `create_user`,
 CHANGE COLUMN `create_time` `create_time` DATETIME DEFAULT NULL AFTER `update_user`,
 CHANGE COLUMN `update_time` `update_time` DATETIME DEFAULT NULL AFTER `create_time`;