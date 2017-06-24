/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : mybaits.learn

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 06/24/2017 14:53:26 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL,
  `lob_number` bigint(20) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `tel_number` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('6283667093996965888', '79101', 'oc.mt@hotmail.com', '02988328736', '13088871919'), ('6283667186082910208', '79101', 'oc.mt@hotmail.com', '02988328736', '13088871919'), ('6283667321655398400', '79101', 'oc.mt@hotmail.com', '02988328736', '13088871919');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
