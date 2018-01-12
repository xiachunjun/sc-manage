DROP TABLE IF EXISTS `sc_menus`;
CREATE TABLE `sc_menus` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`menu_code` varchar(50) DEFAULT NULL COMMENT '菜单code',
	`menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名',
	`menu_level` varchar(255) DEFAULT NULL COMMENT '菜单级别：0-顶级，1-一级，2-二级',
	`partent_code` varchar(255) DEFAULT NULL COMMENT '父菜单code',
	`rel_resouce_code` varchar(50) DEFAULT NULL COMMENT '对应sc_resources表中,类型为菜单的res_code',
	`data_memo` varchar(500) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_resources`;
CREATE TABLE `sc_resources` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`res_code` varchar(50) DEFAULT NULL COMMENT '资源code',
	`res_name` varchar(100) DEFAULT NULL COMMENT '资源名称',
	`res_url` varchar(500) DEFAULT NULL COMMENT '资源url',
	`res_type` int(11) DEFAULT NULL COMMENT '资源类型：0-菜单地址，1-操作地址',
	`res_level` int(11) DEFAULT NULL COMMENT '资源级别：0-无需任何权限即可访问，1-需要校验权限',
	`data_memo` varchar(500) DEFAULT NULL COMMENT '备注',
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;


DROP TABLE IF EXISTS `sc_role_resource_rel`;
CREATE TABLE `sc_role_resource_rel` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`rel_role_code` varchar(50) DEFAULT NULL,
	`rel_res_code` varchar(50) DEFAULT NULL,
	`data_memo` varchar(500) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_roles`;
CREATE TABLE `sc_roles` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`role_code` varchar(50) DEFAULT NULL COMMENT '角色代码',
	`role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
	`data_memo` varchar(500) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

DROP TABLE IF EXISTS `sc_user_role_rel`;
CREATE TABLE `sc_user_role_rel` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`rel_user_code` varchar(50) DEFAULT NULL,
	`rel_role_code` varchar(50) DEFAULT NULL,
	`data_memo` varchar(500) DEFAULT NULL,
	`data_state` int(11) DEFAULT NULL,
	`data_version` int(11) DEFAULT NULL,
	`create_user` varchar(50) DEFAULT NULL,
	`update_user` varchar(50) DEFAULT NULL,
	`create_time` datetime DEFAULT NULL,
	`update_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
