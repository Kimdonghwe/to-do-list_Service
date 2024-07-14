DROP TABLE PLANS;

CREATE TABLE PLANS (
    PLAN_ID NUMBER PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    PLAN_DATE DATE NOT NULL,
    FOREIGN KEY (MEMBER_ID) REFERENCES MEMBERS(MEMBER_ID)
);

DROP SEQUENCE PLANS_PLAN_ID_SEQ;
CREATE SEQUENCE PLANS_PLAN_ID_SEQ;


CREATE SEQUENCE MEMBERS_MEMBER_ID_SEQ;
