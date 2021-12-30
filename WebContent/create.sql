CREATE TABLE EXAM (
	EX_NO VARCHAR(20) PRIMARY KEY, 
	EX_NAME VARCHAR(10)
);

CREATE SEQUENCE EX_FOR_SEQ;
-- 표기 예시
INSERT INTO EXAM VALUES('MEM' || EX_FOR_SEQ.NEXTVAL, 'KIM');
INSERT INTO EXAM VALUES(LPAD(EX_FOR_SEQ.NEXTVAL, 3, 0), 'KIM');
INSERT INTO EXAM VALUES('MEM' || LPAD(EX_FOR_SEQ.NEXTVAL, 3, 0), 'KIM');

SELECT * FROM EXAM;
SELECT * FROM USER_SEQUENCES;

ASC EXAM;
DESC EXAM;

DROP TABLE EXAM;
DROP SEQUENCE EX_FOR_SEQ;

drop table member;

select * from member;

CREATE TABLE member (
	mno     varchar(30) PRIMARY KEY,
	mid     VARCHAR(30) UNIQUE NOT NULL,
	mpw     VARCHAR(30) NOT NULL,
	mname   VARCHAR(30) NOT NULL, 
	mgender VARCHAR(30) NOT NULL,
	mbirth  VARCHAR(30) NOT NULL,
	maddr_zipcode VARCHAR(30) NOT NULL,
	maddr_street  VARCHAR(50) NOT NULL,
	maddr_detail  VARCHAR(50) NOT NULL,
	maddr_etc     VARCHAR(50),
	mtel    VARCHAR(30) UNIQUE NOT  NULL,
	memail  VARCHAR(50) UNIQUE NOT NULL
);

--표기 예시 : MEM101~MEM899
CREATE SEQUENCE member_seq
START WITH 101
INCREMENT BY 1
MAXVALUE 899; 

drop table member;
 
INSERT INTO member VALUES ('MEM' || LPAD(member_seq.NEXTVAL, 3, 0),'id1','1234','이름','여','1111','12234','서울시','101동','구갈동','12345','@gmail.com');

CREATE SEQUENCE member_seq;

drop  SEQUENCE member_seq;


--CREATE TABLE emp (
--	eno     VARCHAR(15) PRIMARY KEY 시퀀스로 변경, 삭제 예정(12.18)
--	eid     VARCHAR(15) UNIQUE NOT NULL
--	epw     VARCHAR(15) NOT NULL
--	ename   VARCHAR(15) NOT NULL, 
--	egender VARCHAR(10) NOT NULL,
--	ebirth  VARCHAR(15) NOT NULL,
--	eaddr   VARCHAR(50) NOT NULL,
--	etel    VARCHAR(15) UNIQUE NOT NULL,
--	eemail  VARCHAR(50) UNIQUE NOT NULL,
--);

--표기 예시 : EMP901
--CREATE SEQUENCE emp_seq; 
--START WITH 901
--INCREMENT BY 1
--MAXVALUE 999; 


--CREATE TABLE notice (
--	nidx    NUMBER(2) PRIMARY KEY,
--	nititle VARCHAR(20) NOT NULL,
--	ncont   VARCHAR(2000) NOT NULL, // ncont CLOB NOT NULL,
--	writer  VARCHAR(15) UNIQUE NOT NULL
--);
--CREATE SEQUENCE notice_seq; 
--SELECT * FROM notice;
--DROP TABLE notice;
<<<<<<< HEAD
=======
CREATE TABLE notice (
	nidx    NUMBER(5) PRIMARY KEY,
	ntitle  VARCHAR(100) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL, 
	writer  VARCHAR(20) UNIQUE NOT NULL
);
>>>>>>> refs/remotes/origin/jh

INSERT INTO notice VALUES(notice_seq.NEXTVAL, 'NTITLE1', 'NCONT1', 'WRITER1');
INSERT INTO notice VALUES(notice_seq.NEXTVAL, 'NTITLE2', 'NCONT2', 'WRITER2');
INSERT INTO notice VALUES(notice_seq.NEXTVAL, 'NTITLE3', 'NCONT3', 'WRITER3');
INSERT INTO notice VALUES(notice_seq.NEXTVAL, 'NTITLE4', 'NCONT4', 'WRITER4');
INSERT INTO notice VALUES(notice_seq.NEXTVAL, 'NTITLE5', 'NCONT5', 'WRITER5');

<<<<<<< HEAD
--상품 DB 
--CREATE SEQUENCE prod_seq; -- 시퀀스
--
--CREATE TABLE product(
--	pcode   NUMBER(2) PRIMARY KEY,     -- 상품코드(PK)
--	pclass  VARCHAR(10) NOT NULL,      -- 분류코드(종합비타민[VITA], 유산균[LACT], 눈건강[EYES])
--	pname   VARCHAR(20) NOT NULL,      -- 상품명
--	pprice  NUMBER(10) NOT NULL,       -- 상품가격
--	pdetail VARCHAR(2000) NOT NULL,    -- 상세정보
--	pperiod VARCHAR(10),               -- 유통기한
--	pdate   VARCHAR(10),               -- 제조일자
--	porigin VARCHAR(20),               -- 원산지
--	pmanuf  VARCHAR(20),               -- 제조업체
--	psales  NUMBER NOT NULL DEFAULT 0, -- 판매량
--	pstock  NUMBER NOT NULL            -- 재고량
--	pimage  VARCHAR(50)                -- 이미지 테이블(CLOB || VARCHAR)
--);--이미지 경로, 사이즈(미정) 넣을 칼럼 추가 
=======
SELECT ROW_NUMBER() OVER (ORDER BY nidx DESC) FROM notice ORDER BY ROW_NUMBER() OVER (ORDER BY nidx DESC) DESC;
SELECT ROWNUM, nidx, ntitle, ncont, writer FROM (SELECT * FROM notice ORDER BY nidx DESC) ORDER BY ROWNUM DESC;

SELECT ROW_NUMBER() OVER (ORDER BY nidx DESC) AS ROWNUM FROM notice ORDER BY ROWNUM DESC;

-- 상품 DB 테이블
CREATE SEQUENCE prod_seq;
--DROP SEQUENCE prod_seq;

SELECT * FROM PRODUCT;
>>>>>>> refs/remotes/origin/jh
--DESC PRODUCT;
--SELECT * FROM PRODUCT;
--DROP TABLE PRODUCT;

        
--고객문의 테이블 
--CREATE TABLE contact (
--	msgno    VARCHAR(10) PRIMARY KEY,
--	msgname  VARCHAR(20) NOT NULL,
--	msgemail VARCHAR(50) NOT NULL,
--	msgtext  VARCHAR(2000) NOT NULL
--)