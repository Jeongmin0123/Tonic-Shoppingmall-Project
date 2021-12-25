CREATE TABLE EXAM (
	EX_NO VARCHAR(20) PRIMARY KEY, 
	EX_NAME VARCHAR(10)
);

CREATE SEQUENCE EX_FOR_SEQ;
-- 표기 예시
--INSERT INTO EXAM VALUES('MEM' || EX_FOR_SEQ.NEXTVAL, 'KIM');
--INSERT INTO EXAM VALUES(LPAD(EX_FOR_SEQ.NEXTVAL, 3, 0), 'KIM');
--INSERT INTO EXAM VALUES('MEM' || LPAD(EX_FOR_SEQ.NEXTVAL, 3, 0), 'KIM');

SELECT * FROM EXAM;
SELECT * FROM USER_SEQUENCES;

ASC EXAM;
DESC EXAM;

DROP TABLE EXAM;
DROP SEQUENCE EX_FOR_SEQ;


CREATE TABLE member (
	mno     VARCHAR(30) PRIMARY KEY,
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
--START WITH 101
--INCREMENT BY 1
--MAXVALUE 899; 


CREATE TABLE emp (
	eno     VARCHAR(30) PRIMARY KEY,
	eid     VARCHAR(30) UNIQUE NOT NULL
	epw     VARCHAR(30) NOT NULL
	ename   VARCHAR(30) NOT NULL, 
	egender VARCHAR(30) NOT NULL,
	ebirth  VARCHAR(30) NOT NULL,
	eaddr   VARCHAR(99) NOT NULL,
	etel    VARCHAR(15) UNIQUE NOT NULL,
	eemail  VARCHAR(50) UNIQUE NOT NULL,
);

--표기 예시 : EMP901
CREATE SEQUENCE emp_seq; 
--START WITH 901
--INCREMENT BY 1
--MAXVALUE 999; 


CREATE TABLE notice (
	nidx    NUMBER(2) PRIMARY KEY,
	nititle VARCHAR(20) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL, // ncont CLOB NOT NULL,
	writer  VARCHAR(15) UNIQUE NOT NULL
);
CREATE SEQUENCE notice_seq; 

SELECT * FROM notice;
--DROP TABLE notice;


--상품 DB 
CREATE SEQUENCE prod_seq; -- 시퀀스

CREATE TABLE product(
	pcode   NUMBER(2) PRIMARY KEY,     -- 상품코드(PK)
	pclass  VARCHAR(10) NOT NULL,      -- 분류코드(종합비타민[VITA], 유산균[LACT], 눈건강[EYES])
	pname   VARCHAR(20) NOT NULL,      -- 상품명
	pprice  NUMBER(10) NOT NULL,       -- 상품가격
	pdetail VARCHAR(2000) NOT NULL,    -- 상세정보
	pperiod VARCHAR(10),               -- 유통기한
	pdate   VARCHAR(10),               -- 제조일자
	porigin VARCHAR(20),               -- 원산지
	pmanuf  VARCHAR(20),               -- 제조업체
	psales  NUMBER NOT NULL DEFAULT 0, -- 판매량
	pstock  NUMBER NOT NULL            -- 재고량
	pimage  VARCHAR(200)                -- 이미지 테이블(CLOB || VARCHAR)
);--이미지 경로, 사이즈(미정) 넣을 칼럼 추가 
DESC PRODUCT;
SELECT * FROM PRODUCT;
DROP TABLE PRODUCT;

        
--고객문의 테이블 
CREATE TABLE contact (
	msgno    VARCHAR(10) PRIMARY KEY,
	msgname  VARCHAR(20) NOT NULL,
	msgemail VARCHAR(50) NOT NULL,
	msgtext  VARCHAR(2000) NOT NULL
)
        
