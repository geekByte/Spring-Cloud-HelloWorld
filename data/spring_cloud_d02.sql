CREATE DATABASE IF NOT EXISTS `spring_cloud_d02`;
USE spring_cloud_d02;
CREATE TABLE `dept`
(
    `dept_no`   BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '部门编号',
    `name`      VARCHAR(60) DEFAULT NULL COMMENT '部门名称',
    `db_source` VARCHAR(60) NOT NULL COMMENT '数据来源'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `dept` (name, db_source)
VALUES ('开发部', DATABASE()),
       ('人事部', DATABASE()),
       ('市场部', DATABASE()),
       ('财务部', DATABASE()),
       ('运维部', DATABASE());