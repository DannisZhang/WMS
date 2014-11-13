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
	`name` VARCHAR (64) NOT NULL,
	`code` VARCHAR (16) NOT NULL,
	`parent_id` INT (16) UNSIGNED NOT NULL,
	`remark` VARCHAR (255) NULL,
	`status` VARCHAR (16) NOT NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`created_by` INT NOT NULL,
	`modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
	`modified_by` INT NULL,
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
	`modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
	`modified_by` INT NULL,
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
	`code` VARCHAR (16) NOT NULL,
	`remark` VARCHAR (255) NULL,
	`status` VARCHAR (16) NOT NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`created_by` INT NULL,
	`modified_on` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
	`modified_by` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT = 1;