/*
Navicat MySQL Data Transfer

Source Server         : hlx
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : myschool

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-11-27 12:26:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cards
-- ----------------------------
DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '123456',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cards
-- ----------------------------
INSERT INTO `cards` VALUES ('1', 'A111089', '林坤', '123456');
INSERT INTO `cards` VALUES ('2', 'T101033', '楼挺号', '123456');
