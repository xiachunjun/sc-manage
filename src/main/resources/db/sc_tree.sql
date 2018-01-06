CREATE TABLE `sc_tree` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父节点id, 如果为根节点则为0',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `is_parent` tinyint(1) DEFAULT NULL COMMENT '文件夹则为1，非文件夹则为0',
  `data_state` int(1) DEFAULT NULL COMMENT '状态：1正常，0无效',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


--初始数据
INSERT INTO `sc_tree` VALUES ('1', '0', '责任晒版', null, '1', '1');
INSERT INTO `sc_tree` VALUES ('2', '0', '任务晒版', null, '1', '1');
INSERT INTO `sc_tree` VALUES ('3', '0', '数据晒版', null, '1', '1');
INSERT INTO `sc_tree` VALUES ('4', '1', '责任清单', 'duty.html', '0', '1');
INSERT INTO `sc_tree` VALUES ('5', '1', '规则制度', 'bylaws.html', '0', '1');
INSERT INTO `sc_tree` VALUES ('6', '1', '计划完成情况', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('7', '1', '绩效考核', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('8', '2', '任务新建', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('9', '2', '任务执行', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('10', '2', '任务归档', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('11', '2', '任务统计', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('12', '3', '总体经营数据', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('13', '3', '部门监管数据', null, '0', '1');
INSERT INTO `sc_tree` VALUES ('14', '3', '数据填报', null, '0', '1');


