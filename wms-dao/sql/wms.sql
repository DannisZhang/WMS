/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2014-11-10 16:10:55
*/
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE
IF EXISTS `t_dept`;

CREATE TABLE `t_dept` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name_cn` VARCHAR (64) NOT NULL,
	`name_en` VARCHAR (64) NOT NULL,
	`code` VARCHAR (16) NOT NULL,
	`location` VARCHAR (128) NOT NULL,
	`established_date` TIMESTAMP NULL,
	`parent_id` INT (16) UNSIGNED NOT NULL,
	`remark` VARCHAR (255) NULL,
	`status` VARCHAR (16) NOT NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`created_by` INT NOT NULL,
	`modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
	`last_modified_by` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

-- ----------------------------
-- Table structure for t_dept_emp
-- ----------------------------
DROP TABLE
IF EXISTS `t_dept_emp`;

CREATE TABLE `t_dept_emp` (
	`dept_id` INT (11) NOT NULL,
	`emp_id` INT (11) NOT NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE
IF EXISTS `t_emp`;

CREATE TABLE `t_emp` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR (64) NOT NULL,
	`code` VARCHAR (16) NOT NULL,
	`gender` VARCHAR (8) NOT NULL DEFAULT 'unknown',
	`age` TINYINT NULL,
	`birthday` TIMESTAMP NULL,
	`mobile` VARCHAR (16) NULL,
	`office` VARCHAR (16) NULL,
	`email` VARCHAR (64) NULL,
	`address` VARCHAR (128) NULL,
	`remark` VARCHAR (255) NULL,
	`status` VARCHAR (16) NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`created_by` INT NOT NULL,
	`last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
	`last_modified_by` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

-- ----------------------------
-- Table structure for t_emp_post
-- ----------------------------
DROP TABLE
IF EXISTS `t_emp_post`;

CREATE TABLE `t_emp_post` (
	`emp_id` INT (11) DEFAULT NULL,
	`position_id` INT (11) DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE
IF EXISTS `t_post`;

CREATE TABLE `t_post` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR (64) NOT NULL,
	`code` VARCHAR (32) NOT NULL,
	`remark` VARCHAR (255) NULL,
	`status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_action` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNIQUE NOT NULL,
  `value` VARCHAR (64) NOT NULL,
  `menu_code` VARCHAR (16) NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_menu` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNIQUE NOT NULL,
  `value` VARCHAR (64) NOT NULL,
  `module_code` VARCHAR (16) NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_module` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNICODE NOT NULL,
  `order` TINYINT NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_permission` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNIQUE NOT NULL,
  `module_code` VARCHAR (16) NOT NULL,
  `menu_code` VARCHAR (16) NOT NULL,
  `action_code` VARCHAR (16) NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_role` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNIQUE NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_role_permission` (
  `role_code` VARCHAR (32) NOT NULL,
  `permission_code` VARCHAR (32) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `t_user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (64) NOT NULL,
  `code` VARCHAR (32) UNIQUE NOT NULL,
  `login_name` VARCHAR (64) UNIQUE NOT NULL,
  `gender` VARCHAR (16) UNIQUE NOT NULL,
  `mobilephone` VARCHAR (32) UNIQUE NOT NULL,
  `telephone` VARCHAR (32) UNIQUE NOT NULL,
  `email` VARCHAR (64) UNIQUE NOT NULL,
  `remark` VARCHAR (255) NULL,
  `status` VARCHAR (16) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;

CREATE TABLE `t_user_role` (
  `user_code` VARCHAR (32) NOT NULL,
  `role_code` VARCHAR (32) NOT NULL,
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(32) NULL,
  `last_modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modified_by` VARCHAR(32) NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;