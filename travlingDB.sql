/*
 Navicat Premium Data Transfer

 Source Server         : difu
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : travling

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 17/10/2022 11:58:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `carNum` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '车牌号 ， 是该表的主键',
  `price` double DEFAULT 1 COMMENT '价格，出租价格，不同城市里可能不同的价格',
  `cityName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所在城市，外键',
  `driver` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '车主，外键 类型为3 的customer',
  PRIMARY KEY (`carNum`) USING BTREE,
  INDEX `carcityName`(`cityName`) USING BTREE,
  INDEX `carDriver`(`driver`) USING BTREE,
  CONSTRAINT `carcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `carDriver` FOREIGN KEY (`driver`) REFERENCES `customer` (`custName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('B1011', 50, '北京', 'ahmed');
INSERT INTO `car` VALUES ('C10135', 35, '北京', '王迪夫');
INSERT INTO `car` VALUES ('HZ1002', 100, '杭州', '王迪夫');
INSERT INTO `car` VALUES ('S1001', 100, '上海', '王迪夫');
INSERT INTO `car` VALUES ('S1002', 100, '上海', '王迪夫');
INSERT INTO `car` VALUES ('SY1001', 40, '沈阳', '王迪夫');
INSERT INTO `car` VALUES ('SY1002', 40, '沈阳', '王迪夫');
INSERT INTO `car` VALUES ('SZ1001', 100, '深圳', '王迪夫');
INSERT INTO `car` VALUES ('SZ1002', 100, '深圳', '王迪夫');
INSERT INTO `car` VALUES ('T1001', 100, '天津', '王迪夫');
INSERT INTO `car` VALUES ('T1002', 100, '天津', '王迪夫');
INSERT INTO `car` VALUES ('XA1001', 80, '西安', '王迪夫');
INSERT INTO `car` VALUES ('XA1002', 80, '西安', '王迪夫');
INSERT INTO `car` VALUES ('XM1001', 50, '厦门', '王迪夫');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `cityName` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '城市名，是该表的主键',
  PRIMARY KEY (`cityName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('上海');
INSERT INTO `city` VALUES ('北京');
INSERT INTO `city` VALUES ('南京');
INSERT INTO `city` VALUES ('厦门');
INSERT INTO `city` VALUES ('哈尔滨');
INSERT INTO `city` VALUES ('大连');
INSERT INTO `city` VALUES ('天津');
INSERT INTO `city` VALUES ('宁波');
INSERT INTO `city` VALUES ('广州');
INSERT INTO `city` VALUES ('成都');
INSERT INTO `city` VALUES ('无锡');
INSERT INTO `city` VALUES ('杭州');
INSERT INTO `city` VALUES ('武汉');
INSERT INTO `city` VALUES ('沈阳');
INSERT INTO `city` VALUES ('济南');
INSERT INTO `city` VALUES ('深圳');
INSERT INTO `city` VALUES ('苏州');
INSERT INTO `city` VALUES ('西安');
INSERT INTO `city` VALUES ('重庆');
INSERT INTO `city` VALUES ('长春');
INSERT INTO `city` VALUES ('青岛');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `custName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '顾客或管理员名,是该表的主键',
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '111111' COMMENT '密码',
  `type` int(0) DEFAULT 1 COMMENT '用户类型表示是否管理员， 1 表示管理员，2表示为顾客',
  `custPhone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '顾客联系方式---手机号',
  PRIMARY KEY (`custName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('admin', '1234', 1, '18194265810');
INSERT INTO `customer` VALUES ('ahmed', '111111', 2, '181646564');
INSERT INTO `customer` VALUES ('Ali', '1234', 2, '1545484564');
INSERT INTO `customer` VALUES ('峰', '44444', 2, '45465');
INSERT INTO `customer` VALUES ('李建国', '111111', 2, '15465465');
INSERT INTO `customer` VALUES ('王迪夫', '1234', 1, NULL);
INSERT INTO `customer` VALUES ('阿格', '111111', 2, NULL);

-- ----------------------------
-- Table structure for flight
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight`  (
  `flightNum` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '航班号，是该表的主键',
  `price` double DEFAULT 200 COMMENT '价格，默认200.0',
  `numSeats` int(0) DEFAULT 30 COMMENT '座位数 ，默认30',
  `fromCity` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '出发城市名 ， 外键',
  `fromDate` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '出发时间 ， 年-月-日 点：种',
  `arivCity` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '目的城市名 ， 外键',
  `arivDate` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '到达时间，年-月-日 点：种',
  PRIMARY KEY (`flightNum`) USING BTREE,
  INDEX `fromCity`(`fromCity`) USING BTREE,
  INDEX `arivCity`(`arivCity`) USING BTREE,
  CONSTRAINT `arivCity` FOREIGN KEY (`arivCity`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fromCity` FOREIGN KEY (`fromCity`) REFERENCES `city` (`cityName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flight
-- ----------------------------
INSERT INTO `flight` VALUES ('BJ-HZ10A1', 200, 3, '北京', '2022-01-16 02:24', '杭州', '2022-01-16 03:04');
INSERT INTO `flight` VALUES ('BJ-SH10A1', 200, 0, '北京', '2022-01-16 11:04', '上海', '2022-01-16 13:04');
INSERT INTO `flight` VALUES ('BJ-SH10A2', 200, 28, '北京', '2022-01-16 07:04', '上海', '2022-01-16 09:04');
INSERT INTO `flight` VALUES ('BJ-SY10A1', 200, 30, '北京', '2022-01-15 15:04', '沈阳', '2022-01-15 17:04');
INSERT INTO `flight` VALUES ('BJ-SY10A2', 200, 30, '北京', '2022-01-16 14:04', '沈阳', '2022-01-16 15:04');
INSERT INTO `flight` VALUES ('BJHZ10A2', 200, 30, '北京', '2022-01-16 09:04', '杭州', '2022-01-16 10:44');
INSERT INTO `flight` VALUES ('SH-BJ10A1', 200, 30, '上海', '2022-01-17 08:04', '北京', '2022-01-17 09:04');
INSERT INTO `flight` VALUES ('SH-BJ10A2', 200, 30, '上海', '2022-01-18 07:02', '北京', '2022-01-18 08:54');
INSERT INTO `flight` VALUES ('SH-HZ10A1', 200, 28, '上海', '2022-01-17 03:04', '杭州', '2022-01-17 04:04');
INSERT INTO `flight` VALUES ('SH-HZ10A2', 200, 30, '上海', '2022-01-18 10:04', '杭州', '2022-01-18 12:04');
INSERT INTO `flight` VALUES ('SH-TJ10A1', 200, 2, '上海', '2022-01-15 01:04', '天津', '2022-01-15 02:04');
INSERT INTO `flight` VALUES ('SH-TJ10A2', 200, 30, '上海', '2022-01-14 12:04', '天津', '2022-01-14 14:04');
INSERT INTO `flight` VALUES ('TJ-XA10A1', 200, 30, '天津', '2022-01-18 16:04', '西安', '2022-01-18 17:04');
INSERT INTO `flight` VALUES ('TJ-XA10A2', 200, 30, '天津', '2022-01-19 08:04', '西安', '2022-01-19 10:04');
INSERT INTO `flight` VALUES ('XA-SY10A1', 200, 30, '西安', '2022-01-14 05:04', '沈阳', '2022-01-14 07:04');
INSERT INTO `flight` VALUES ('XA-SY10A2', 200, 30, '西安', '2022-01-15 03:04', '沈阳', '2022-01-15 04:24');
INSERT INTO `flight` VALUES ('XA-SY10A3', 200, 30, '西安', '2022-01-15 03:04', '沈阳', '2022-01-15 04:24');
INSERT INTO `flight` VALUES ('XA-XM10A1', 200, 30, '西安', '2022-01-18 04:04', '厦门', '2022-01-18 06:04');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `hotelName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '宾馆名，是该表的主键',
  `price` double DEFAULT 100 COMMENT '价格，默认100.0',
  `numRooms` int(0) DEFAULT 10 COMMENT '房间数量，默认10',
  `cityName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所在的城市名 ，外键',
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`hotelName`) USING BTREE,
  INDEX `hotelcityName`(`cityName`) USING BTREE,
  CONSTRAINT `hotelcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('B-HotelA2', 100, 4, '北京', '本地地址qqq');
INSERT INTO `hotel` VALUES ('HZ-HotelA1', 100, 10, '杭州', '本地地址');
INSERT INTO `hotel` VALUES ('HZ-HotelA2', 100, 5, '杭州', '本地地址');
INSERT INTO `hotel` VALUES ('SY-HotelA1', 100, 10, '沈阳', '本地地址');
INSERT INTO `hotel` VALUES ('SY-HotelA2', 100, 10, '沈阳', '本地地址');
INSERT INTO `hotel` VALUES ('SZ-HotelA1', 100, 10, '深圳', '本地地址');
INSERT INTO `hotel` VALUES ('SZ-HotelA2', 100, 4, '深圳', '本地地址');
INSERT INTO `hotel` VALUES ('TJ-HotelA1', 100, 10, '天津', '本地地址');
INSERT INTO `hotel` VALUES ('TJ-HotelA2', 100, 10, '天津', '本地地址');
INSERT INTO `hotel` VALUES ('XA-HotelA1', 100, 10, '西安', '本地地址');
INSERT INTO `hotel` VALUES ('北京AAA', 50, 19, '北京', '显示反对广泛');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `resvKey` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '预定号，表示预定的航班号，车牌号，或宾馆名',
  `custName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '顾客名',
  `type` int(0) NOT NULL COMMENT '预定类型，1表示航班预定，2表示出租车预定，3表示宾馆预定',
  `resDate` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '预定日期，年-月-日 点：分钟',
  `number` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '号，表示座位号或房间号',
  INDEX `reservationkey`(`resvKey`, `custName`, `type`, `resDate`) USING BTREE,
  INDEX `reservationcust`(`custName`) USING BTREE,
  CONSTRAINT `reservationcust` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('BJ-HZ10A1', '王迪夫', 1, '2022-01-10', 'A1-B');
INSERT INTO `reservation` VALUES ('HZ1001', '王迪夫', 2, '2022-01-10', '05');
INSERT INTO `reservation` VALUES ('B-HotelA1', '王迪夫', 3, '2022-01-10', '1204');
INSERT INTO `reservation` VALUES ('BJ-HZ10A1', '李建国', 1, '2022-01-10', 'A1-B');
INSERT INTO `reservation` VALUES ('HZ1001', '李建国', 2, '2022-01-10', '01');
INSERT INTO `reservation` VALUES ('B-HotelA1', '李建国', 3, '2022-01-10', '504');
INSERT INTO `reservation` VALUES ('XA-SY10A2', '阿格', 1, '2022-01-10', 'A1-B');
INSERT INTO `reservation` VALUES ('SY1002', '阿格', 2, '2022-01-10', '12');
INSERT INTO `reservation` VALUES ('SY-HotelA1', '阿格', 3, '2022-01-10', '203');
INSERT INTO `reservation` VALUES ('BJ-HZ10A1', '峰', 1, '2022-01-10', 'A1-B');
INSERT INTO `reservation` VALUES ('HZ1001', '峰', 2, '2022-01-10', '03');
INSERT INTO `reservation` VALUES ('B-HotelA1', '峰', 3, '2022-01-10', '205');
INSERT INTO `reservation` VALUES ('SY1002', '王迪夫', 1, '2022-01-10', 'A1-A');
INSERT INTO `reservation` VALUES ('景点北京B', '王迪夫', 4, '2022-01-14', 'H-20');
INSERT INTO `reservation` VALUES ('景点北京C', '王迪夫', 4, '2022-01-05', 'J-14');
INSERT INTO `reservation` VALUES ('SH-HZ10A1', '王迪夫', 1, '2022-01-14', 'J 30');
INSERT INTO `reservation` VALUES ('SH-HZ10A1', '王迪夫', 1, '', 'G 22');
INSERT INTO `reservation` VALUES ('BJ-SH10A1', '王迪夫', 1, '', 'K 24');
INSERT INTO `reservation` VALUES ('B-HotelA2', '王迪夫', 3, '2022-01-14', '3001');
INSERT INTO `reservation` VALUES ('景点天津B', '王迪夫', 4, '2022-01-14', 'K-13');
INSERT INTO `reservation` VALUES ('景点天津C', '王迪夫', 4, '2022-01-14', 'K-25');
INSERT INTO `reservation` VALUES ('景点北京B', '王迪夫', 4, '2022-01-14', 'G-24');
INSERT INTO `reservation` VALUES ('B-HotelA2', '王迪夫', 3, '2022-01-14', '8004');
INSERT INTO `reservation` VALUES ('B1011', '王迪夫', 2, '2022-01-05', 'B2');
INSERT INTO `reservation` VALUES ('BJ-SH10A1', '王迪夫', 1, '2022-01-13', 'H 21');
INSERT INTO `reservation` VALUES ('B-HotelA2', '王迪夫', 3, '2022-01-13', '5001');
INSERT INTO `reservation` VALUES ('景点上海B', 'Ali', 4, '2022-01-13', 'D-17');
INSERT INTO `reservation` VALUES ('B-HotelA2', 'Ali', 3, '2022-01-14', '9005');
INSERT INTO `reservation` VALUES ('B1011', 'Ali', 2, '2022-01-14', 'B2');
INSERT INTO `reservation` VALUES ('BJ-HZ10A1', 'Ali', 1, '2022-01-13', 'K 29');
INSERT INTO `reservation` VALUES ('B-HotelA2', 'Ali', 3, '2022-01-13', '5001');
INSERT INTO `reservation` VALUES ('景点天津B', '王迪夫', 4, '2022-01-14', 'H-7');
INSERT INTO `reservation` VALUES ('BJ-SH10A2', '王迪夫', 1, '2022-01-15', 'H 15');
INSERT INTO `reservation` VALUES ('B1011', '王迪夫', 2, '2022-01-14', 'A2');
INSERT INTO `reservation` VALUES ('北京AAA', '王迪夫', 3, '2022-01-14', '5003');
INSERT INTO `reservation` VALUES ('景点杭州E', '王迪夫', 4, '2022-01-21', 'K-13');
INSERT INTO `reservation` VALUES ('BJ-SH10A2', '王迪夫', 1, '2022-01-16', 'A 25');
INSERT INTO `reservation` VALUES ('BJ-SH10A1', '王迪夫', 1, '2022-01-19', 'C 10');
INSERT INTO `reservation` VALUES ('景点上海B', 'admin', 4, '2022-06-22', 'H-25');
INSERT INTO `reservation` VALUES ('BJ-HZ10A1', 'admin', 1, '2022-06-21', 'K 19');
INSERT INTO `reservation` VALUES ('B1011', 'admin', 2, '', 'B1');
INSERT INTO `reservation` VALUES ('B-HotelA2', 'admin', 3, '', '9001');
INSERT INTO `reservation` VALUES ('景点北京B', 'admin', 4, '', 'D-30');

-- ----------------------------
-- Table structure for scenicspots
-- ----------------------------
DROP TABLE IF EXISTS `scenicspots`;
CREATE TABLE `scenicspots`  (
  `spotName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '景点名，也是该表的主键',
  `price` double DEFAULT 50 COMMENT '价格，表示门票',
  `cityName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '所在城市，外键',
  `address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '景点详细地址',
  `ticketNum` int(0) DEFAULT 200 COMMENT '门票数量',
  `photo` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '旅游景点照片',
  `descSpot` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '景点描述',
  PRIMARY KEY (`spotName`) USING BTREE,
  INDEX `spotcityName`(`cityName`) USING BTREE,
  CONSTRAINT `spotcityName` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenicspots
-- ----------------------------
INSERT INTO `scenicspots` VALUES ('景点上海B', 50, '上海', '详细地址', 198, 'static/img/p16.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点北京B', 70, '北京', '详细地址', 79, 'static/img/p1.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点北京C', 78, '北京', '详细地址', 49, 'static/img/p2.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点南京', 50, '南京', '详细地址', 200, 'static/img/p21.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点南京A', 50, '南京', '详细地址', 200, 'static/img/p20.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点厦门A', 50, '厦门', '详细地址', 200, 'static/img/p14.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点厦门B', 50, '厦门', '详细地址', 200, 'static/img/p6.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点天津A', 77, '天津', '详细地址', 41, 'static/img/p3.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点天津B', 70, '天津', '详细地址', 8, 'static/img/p4.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点天津C', 70, '天津', '详细地址', 25, 'static/img/p5.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点宁波A', 50, '宁波', '详细地址', 200, 'static/img/p9.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点广州A', 50, '广州', '详细地址', 200, 'static/img/p18.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州A', 74, '杭州', '详细地址', 4, 'static/img/p6.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州B', 50, '杭州', '详细地址', 10, 'static/img/p7.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州C', 100, '杭州', '详细地址', 8, 'static/img/p8.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州D', 50, '杭州', '详细地址', 200, 'static/img/p17.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州E', 50, '杭州', '详细地址', 199, 'static/img/p18.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点杭州F', 50, '杭州', '详细地址', 200, 'static/img/p19.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点深圳A', 70, '深圳', '详细地址', 14, 'static/img/p9.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点深圳B', 70, '深圳', '详细地址', 10, 'static/img/p10.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点深圳C', 70, '深圳', '详细地址', 40, 'static/img/p11.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点深圳E', 50, '深圳', '详细覅在', 200, 'static/img/p4.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点西安A', 90, '西安', '详细地址', 8, 'static/img/p12.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点西安B', 180, '西安', '详细地址', 10, 'static/img/p13.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');
INSERT INTO `scenicspots` VALUES ('景点西安C', 70, '西安', '详细地址', 80, 'static/img/p14.jpg', '万里长城\r\n\r\n是举世闻名的旅游胜地，是中国最有名的旅游景点');

SET FOREIGN_KEY_CHECKS = 1;
