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


--CREATE TABLE member (
--	mno     VARCHAR(15) PRIMARY KEY 시퀀스로 변경, 삭제 예정(12.18)
--	mid     VARCHAR(15) UNIQUE NOT NULL
--	mpw     VARCHAR(15) NOT NULL
--	mname   VARCHAR(15) NOT NULL, 
--	mgender VARCHAR(10) NOT NULL,
--	mbirth  VARCHAR(15) NOT NULL,
--	maddr_zipcode VARCHAR(15) NOT NULL,
--	maddr_street  VARCHAR(30) NOT NULL,
--	maddr_detail  VARCHAR(30) NOT NULL,
--	maddr_etc     VARCHAR(30),
--	mtel    VARCHAR(15) UNIQUE NOT  NULL,
--	memail  VARCHAR(50) UNIQUE NOT NULL,
--);

--CREATE SEQUENCE member_seq
--START WITH 101
--INCREMENT BY 1
--MAXVALUE 899; 


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

--CREATE SEQUENCE emp_seq; 
--START WITH 901
--INCREMENT BY 1
--MAXVALUE 999; 

--삭제 예정
--CREATE TABLE loginfo (
--	log_code VARCHAR(10) PRIMARY KEY,
--	id       VARCHAR(15) UNIQUE NOT NULL,
--	pw       VARCHAR(15) UNIQUE NOT NULL
--);

--CREATE TABLE notice (
--	nidx    NUMBER PRIMARY KEY,
--	nititle VARCHAR(20) NOT NULL,
--	ncont   VARCHAR(2000) NOT NULL, // ncont CLOB NOT NULL,
--	writer  VARCHAR(15) UNIQUE NOT NULL
--);
--CREATE SEQUENCE notice_seq; 
--SELECT * FROM notice;
--DROP TABLE notice;


--상품 DB 
CREATE SEQUENCE prod_seq; -- 시퀀스

CREATE TABLE product(
	prod_code   VARCHAR(10) PRIMARY KEY, -- 상품코드(PK)
	prod_class  VARCHAR(10) NOT NULL,    -- 분류코드(종합비타민[VITA], 유산균[LACT], 눈건강[EYES])
	prod_name   VARCHAR(20) NOT NULL,    -- 상품명
	prod_price  NUMBER(10) NOT NULL,     -- 상품가격
	prod_detail VARCHAR(2000) NOT NULL,  -- 상세정보
	prod_period VARCHAR(10),             -- 유통기한
	prod_date   VARCHAR(10),             -- 제조일자
	prod_origin VARCHAR(20),             -- 원산지
	prod_manuf  VARCHAR(20),             -- 제조업체
	prod_sales  NUMBER NOT NULL,         -- 판매량
	prod_stock  NUMBER NOT NULL          -- 재고량
);--이미지 경로, 사이즈? 넣을 칼럼 추가 예정
DESC PRODUCT;
SELECT * FROM PRODUCT;
DROP TABLE PRODUCT;

        
--고객문의 테이블 
--CREATE TABLE contact (
--	msgno    VARCHAR(10) PRIMARY KEY,
--	msgname  VARCHAR(20) NOT NULL,
--	msgemail VARCHAR(50) NOT NULL,
--	msgtext  VARCHAR(2000) NOT NULL
--)
        
