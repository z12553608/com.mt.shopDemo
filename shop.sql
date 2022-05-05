/*
 Navicat Premium Data Transfer

 Source Server         : Harresion
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 05/05/2022 16:39:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for prefix
-- ----------------------------
DROP TABLE IF EXISTS `prefix`;
CREATE TABLE `prefix`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prefix` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连锁店前缀',
  `fullname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连锁店全名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prefix
-- ----------------------------
INSERT INTO `prefix` VALUES (1, 'TX', '通宵烧烤');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `tenantId` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户号，连锁店共用一个',
  `businessNo` bigint(10) NOT NULL COMMENT '商户号，不可修改，全局唯一',
  `shopName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '门店唯一命名',
  `businessType` tinyint(1) NOT NULL COMMENT '主营业态，(正餐、快餐、火锅、烧烤、西餐)',
  `managementType` tinyint(1) NOT NULL COMMENT '直营、加盟',
  `contact` json NOT NULL COMMENT '门店联系方式',
  `openingHours` json NOT NULL COMMENT '营业时间',
  `businessArea` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '营业面积',
  `comment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '门店备注',
  `enabled` tinyint(1) UNSIGNED ZEROFILL NOT NULL COMMENT '门店状态，true或false',
  PRIMARY KEY (`businessNo`) USING BTREE,
  UNIQUE INDEX `uk_businessNo`(`businessNo`) USING BTREE COMMENT '商户号，全局唯一，自动生成'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('AL20220425', 1650850472, '创艺时光', 1, 2, '{\"name\": \"王露\", \"address\": \"四川省成都市\", \"cellphone\": \"17844540093\", \"telephone\": \"5223618\"}', '{\"end\": \"22:00\", \"start\": \"9:00\"}', '99平米', '专注于创意开发软件', 0);
INSERT INTO `shop` VALUES ('TX2101023051', 2101023051, '小张烧烤店', 1, 1, '{\"name\": \"张诗禹\", \"address\": \"四川省成都市\", \"cellphone\": \"17844540093\", \"telephone\": \"5223618\"}', '{\"end\": \"24:00\", \"start\": \"08:00\"}', '120平米', '小张烧烤', 1);
INSERT INTO `shop` VALUES ('TX20220424', 3113552765, '小李蛋糕店', 5, 1, '{\"name\": \"张诗禹\", \"address\": \"四川省成都市\", \"cellphone\": \"17844540093\", \"telephone\": \"5223618\"}', '{\"end\": \"24:00\", \"start\": \"08:00\"}', '100平米', '小李蛋糕直营店', 0);

SET FOREIGN_KEY_CHECKS = 1;
