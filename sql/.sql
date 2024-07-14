--------------------------------------------------------
--  파일이 생성됨 - 토요일-7월-13-2024   
--------------------------------------------------------
DROP SEQUENCE "C##TODOLIST"."MEMBERS_MEMBER_ID_SEQ";
DROP SEQUENCE "C##TODOLIST"."PLANS_PLAN_ID_SEQ";
DROP SEQUENCE "C##TODOLIST"."TODO_TODO_ID_SEQ";
DROP TABLE "C##TODOLIST"."MEMBERS";
DROP TABLE "C##TODOLIST"."PLANS";
DROP TABLE "C##TODOLIST"."TODO";
--------------------------------------------------------
--  DDL for Sequence MEMBERS_MEMBER_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##TODOLIST"."MEMBERS_MEMBER_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PLANS_PLAN_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##TODOLIST"."PLANS_PLAN_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence TODO_TODO_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##TODOLIST"."TODO_TODO_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table MEMBERS
--------------------------------------------------------

  CREATE TABLE "C##TODOLIST"."MEMBERS" 
   (	"MEMBER_ID" NUMBER, 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PW" VARCHAR2(100 BYTE), 
	"NICKNAME" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table PLANS
--------------------------------------------------------

  CREATE TABLE "C##TODOLIST"."PLANS" 
   (	"PLAN_ID" NUMBER, 
	"MEMBER_ID" NUMBER, 
	"PLAN_DATE" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table TODO
--------------------------------------------------------

  CREATE TABLE "C##TODOLIST"."TODO" 
   (	"TODO_ID" NUMBER, 
	"PLAN_ID" NUMBER, 
	"TODO" VARCHAR2(255 BYTE), 
	"PRIORITY" NUMBER
   ) ;
REM INSERTING into C##TODOLIST.MEMBERS
SET DEFINE OFF;
Insert into C##TODOLIST.MEMBERS (MEMBER_ID,EMAIL,PW,NICKNAME) values (41,'test','1234','kdh');
Insert into C##TODOLIST.MEMBERS (MEMBER_ID,EMAIL,PW,NICKNAME) values (1,'test@example.com','1234','kdh');
REM INSERTING into C##TODOLIST.PLANS
SET DEFINE OFF;
REM INSERTING into C##TODOLIST.TODO
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table PLANS
--------------------------------------------------------

  ALTER TABLE "C##TODOLIST"."PLANS" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."PLANS" MODIFY ("PLAN_DATE" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."PLANS" ADD PRIMARY KEY ("PLAN_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TODO
--------------------------------------------------------

  ALTER TABLE "C##TODOLIST"."TODO" MODIFY ("PLAN_ID" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."TODO" MODIFY ("TODO" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."TODO" MODIFY ("PRIORITY" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."TODO" ADD PRIMARY KEY ("TODO_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBERS
--------------------------------------------------------

  ALTER TABLE "C##TODOLIST"."MEMBERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."MEMBERS" MODIFY ("PW" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."MEMBERS" MODIFY ("NICKNAME" NOT NULL ENABLE);
  ALTER TABLE "C##TODOLIST"."MEMBERS" ADD PRIMARY KEY ("MEMBER_ID")
  USING INDEX  ENABLE;
  ALTER TABLE "C##TODOLIST"."MEMBERS" ADD UNIQUE ("EMAIL")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLANS
--------------------------------------------------------

  ALTER TABLE "C##TODOLIST"."PLANS" ADD FOREIGN KEY ("MEMBER_ID")
	  REFERENCES "C##TODOLIST"."MEMBERS" ("MEMBER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TODO
--------------------------------------------------------

  ALTER TABLE "C##TODOLIST"."TODO" ADD FOREIGN KEY ("PLAN_ID")
	  REFERENCES "C##TODOLIST"."PLANS" ("PLAN_ID") ENABLE;
