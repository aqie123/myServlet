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

DROP TABLE IF EXISTS `department`;
CREATE TABLE department(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL DEFAULT '' COMMENT '部门名称',
  leader varchar(30) NOT NULL DEFAULT '' COMMENT '部门负责人',
  function varchar(255) NOT NULL DEFAULT '' COMMENT '部门职能',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO department (name, leader, function) VALUES ("技术部","位志伟","开发app"),
  ("人事部","李向飞","人事调整"),("美工部","史丽美","详情页"),
  ("跟单部","张荣换","跟单"),("监理部","王钊","施工监理");

DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  dpID int(11) unsigned NOT NULL DEFAULT 0 COMMENT '部门id',
  gender TINYINT(1) NOT NULL DEFAULT 1 COMMENT '性别',
  name varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `email` varchar(50) NOT NULL DEFAULT '2924811900@qq.com' COMMENT '邮箱',
  position varchar(50) NOT NULL DEFAULT '' COMMENT '职位',
  salary DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '薪水',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into employee (dpID, name) VALUES (2,"啊切"),(2,"bob"),(3,"tom");
insert into employee (dpID, name) VALUES (1,"aqie"),(3,"john"),(5,"toby");


CREATE TABLE account(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  deposit DECIMAL(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
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

CREATE TABLE student(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
  gender TINYINT(1) NOT NULL DEFAULT 1 COMMENT '性别',
  score DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '分数',
  birth DATE NOT NULL DEFAULT '1011-00-00' COMMENT '日期',
  `create_time` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '添加时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生';

create table chart(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  `topic` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '话题',
  uid VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `create_time` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '添加时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='话题';
insert into chart(topic,uid,create_time) VALUE (1,9,1516087020);
insert into chart(topic,uid,create_time) VALUE (9,1,1516087021);
insert into chart(topic,uid,create_time) VALUE (3,4,1516087020);
insert into chart(topic,uid,create_time) VALUE (4,3,1516087021);

DROP TABLE IF EXISTS `file_list`;
create table file_list(
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50)  DEFAULT '' COMMENT '文件名',
  `size` VARCHAR(50)  DEFAULT '' COMMENT '文件大小',
  `type` VARCHAR(50)  DEFAULT '' COMMENT '文件类型',
  `addTime` DATETIME  DEFAULT '0000-00-00 00:00:00' COMMENT '上传时间',
  `file_path` VARCHAR(255)  DEFAULT '' COMMENT '文件在服务器实际路径',
  `info` VARCHAR(200)  DEFAULT '' COMMENT '文件描述',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件信息表';

# 测试反射注解
DROP TABLE IF EXISTS `lion_list`;
CREATE TABLE lion_list(
  lid int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lname` VARCHAR(50)  DEFAULT '' COMMENT '昵称',
  PRIMARY KEY (`lid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='LION信息表';
INSERT INTO lion_list(lname) VALUES ("a"),("b"),("c");

DROP TABLE IF EXISTS user_list;
CREATE TABLE user_list(
  id varchar(50)  NOT NULL,
  name varchar(30) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '用户密码',
  email varchar(30) NOT NULL DEFAULT '' COMMENT '用户注册邮箱',
  status TINYINT(1) NOT NULL DEFAULT 0 COMMENT '1:激活 2:未激活',
  validateCode  varchar(50) NOT NULL DEFAULT '' COMMENT '随机激活码',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮箱激活用户表';