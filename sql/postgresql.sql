/*
Navicat PGSQL Data Transfer

Source Server         : local-PostgreSQL
Source Server Version : 90603
Source Host           : localhost:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90603
File Encoding         : 65001

Date: 2017-09-20 10:15:26
*/


-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_info";
CREATE TABLE "public"."user_info" (
"id" int8 NOT NULL,
"lob_number" int8,
"email_address" varchar(255) COLLATE "default",
"tel_number" varchar(255) COLLATE "default",
"phone_number" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO "public"."user_info" VALUES ('6283667093996965888', '79101', 'oc.mt@hotmail.com', '02988328736', '13088871919');

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_info
-- ----------------------------
ALTER TABLE "public"."user_info" ADD PRIMARY KEY ("id");
