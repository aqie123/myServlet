CREATE TABLE attachments(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL DEFAULT '' COMMENT '附件名称',
  file blob,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  author varchar(255) NOT NULL DEFAULT '' COMMENT '附件作者',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

DROP TABLE IF EXISTS `auth_admin`;
CREATE TABLE `auth_admin` (
  `admin_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) NOT NULL DEFAULT '',
  `password` char(32) NOT NULL DEFAULT '',
  `avatar` varchar(200) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '2924811900@qq.com',
  `mobile` varchar(20) NOT NULL DEFAULT '13207145531',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  `salt` varchar(20) NOT NULL DEFAULT '',
  `content` text,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='aqie';

CREATE TABLE department(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL DEFAULT '' COMMENT '部门名称',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE employee(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  dpID int(11) unsigned NOT NULL DEFAULT 0 COMMENT '部门id',
  name varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE account(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  deposit DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '姓名',
  name varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contact(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
  gender TINYINT(1) NOT NULL DEFAULT 1 COMMENT '性别',
  emial varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `mobile` char(11) NOT NULL DEFAULT '' COMMENT '手机',
  address varchar(50) NOT NULL DEFAULT '' COMMENT '地址',
  `create_time` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '添加时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系人';