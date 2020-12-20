/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : wtumap

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-12-18 00:33:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `student_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '吴锴', '1804280405', '湖北省武汉市黄陂区盘龙城经济开发区巨龙大道日月山水小区');
INSERT INTO `t_student` VALUES ('2', '王近云', '1804280318', '湖北省随州市应山街道');
INSERT INTO `t_student` VALUES ('3', '梁渊', '1804280436', '湖北省天门市皂市镇');
INSERT INTO `t_student` VALUES ('4', '李瑞', '1804280430', '湖北省十堰市竹溪县');
INSERT INTO `t_student` VALUES ('5', '刘波', '1804280401', '浙江省杭州市');
INSERT INTO `t_student` VALUES ('6', '王大治', '1804280402', '湖南省长沙市雨花区');
INSERT INTO `t_student` VALUES ('7', '李静', '1804280403', '江苏省南京市鼓楼区');
INSERT INTO `t_student` VALUES ('8', '黄蓉', '1804280404', '河南省郑州市');
INSERT INTO `t_student` VALUES ('9', '郭襄', '1804280407', '河北省保定区');
INSERT INTO `t_student` VALUES ('10', '杨洋', '1804280408', '河南省开封市');
INSERT INTO `t_student` VALUES ('11', '杨幂', '1804280409', '江西省南昌市');
INSERT INTO `t_student` VALUES ('12', '王大嘴', '1804280410', '贵州省贵阳市');
INSERT INTO `t_student` VALUES ('13', '李大钊', '1804280411', '贵州省遵义市');
INSERT INTO `t_student` VALUES ('14', '金星', '1804280412', '四川省成都市');
INSERT INTO `t_student` VALUES ('15', '包太保', '1804280413', '四川省自贡市');
INSERT INTO `t_student` VALUES ('16', '爱迪生', '1804280414', '陕西省西安市');
INSERT INTO `t_student` VALUES ('17', '王力宏', '1804280415', '山西省太原市');
INSERT INTO `t_student` VALUES ('18', '吴尊', '1804280416', '山西省大同市');
INSERT INTO `t_student` VALUES ('19', '吴亦凡', '1804280417', '山东省济南市');
INSERT INTO `t_student` VALUES ('20', '张雨生', '1804280418', '辽宁省沈阳市');
