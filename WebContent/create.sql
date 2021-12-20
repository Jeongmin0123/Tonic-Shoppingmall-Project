DROP TABLE EXAM;

CREATE TABLE EXAM (
	EX_NO VARCHAR(20) PRIMARY KEY, 
	EX_NAME VARCHAR(10)
);

CREATE SEQUENCE EX_FOR_SEQ2;

INSERT INTO EXAM VALUES('MEM' || mem_seq.NEXTVAL, 'KIM');
INSERT INTO EXAM VALUES(LPAD(EX_FOR_SEQ2.NEXTVAL, 3, 0), 'KIM');
INSERT INTO EXAM VALUES('MEM' || LPAD(EX_FOR_SEQ2.NEXTVAL, 3, 0), 'KIM');

SELECT * FROM EXAM;

--CREATE TABLE member (
--		 mno     VARCHAR(15) PRIMARY KEY 시퀀스로 변경, 삭제 예정(12.18)
--       mname   VARCHAR(15) NOT NULL, 
--       mgender VARCHAR(10) NOT NULL,
--       mbirth  VARCHAR(15) NOT NULL,
--       maddr   VARCHAR(20),
--       mtel    VARCHAR(15) UNIQUE NOT  NULL,
--       memail  VARCHAR(40) UNIQUE NOT NULL,
--       id      VARCHAR(15) UNIQUE NOT NULL
--);

--CREATE SEQUENCE member_seq
--START WITH 101
--INCREMENT BY 1
--MAXVALUE 899; 


--CREATE TABLE emp (
--		 eno     VARCHAR(15) PRIMARY KEY 시퀀스로 변경, 삭제 예정(12.18)
--       ename   VARCHAR(15) NOT NULL, 
--       egender VARCHAR(10) NOT NULL,
--       ebirth  VARCHAR(15) NOT NULL,
--       eaddr   VARCHAR(30),
--       etel    VARCHAR(15) UNIQUE NOT NULL,
--       eemail  VARCHAR(40) UNIQUE NOT NULL,
--       id      VARCHAR(15) UNIQUE NOT NULL
--);

--CREATE SEQUENCE emp_seq; 
--START WITH 901
--INCREMENT BY 1
--MAXVALUE 999; 


--CREATE TABLE loginfo (
--		log_code VARCHAR(10) PRIMARY KEY,
--		id       VARCHAR(15) UNIQUE NOT NULL,
--		pw       VARCHAR(15) UNIQUE NOT NULL
--);


--CREATE TABLE notice (
--		nidx    VARCHAR(10) PRIMARY KEY,
--		nititle VARCHAR(20) NOT NULL,
--		ncont   VARCHAR(50) NOT NULL
--		id      VARCHAR(15) UNIQUE NOT NULL,
--);
--CREATE SEQUENCE notice_seq; 


--상품 DB 
--CREATE TABLE vita (
--		v_no      VARCHAR(10) PRIMARY KEY,
--		v_name    VARCHAR(20) UNIQUE NOT NULL,
--		v_price   NUMBER(10)  NOT NULL,
--		v_details VARCHAR(30) NOT NULL,
--		v_period  VARCHAR(10) NOT NULL,
--		v_date    VARCHAR(10) NOT NULL,
--		v_origin  VARCHAR(10) NOT NULL,
--		v_manuf   VARCHAR(10) NOT NULL,
--		v_sales   NUMBER(10)  NOT NULL,
--		v_stock   NUMBER(10)  NOT NULL,
--      상품이미지 추가 칼럼?
--);

--CREATE TABLE lact (
--		l_no      VARCHAR(10) PRIMARY KEY,
--		l_name    VARCHAR(20) UNIQUE NOT NULL,
--		l_price   NUMBER(10)  NOT NULL,
--		l_details VARCHAR(30) NOT NULL,
--		l_period  VARCHAR(10) NOT NULL,
--		l_date    VARCHAR(10) NOT NULL,
--		l_origin  VARCHAR(10) NOT NULL,
--		l_manuf   VARCHAR(10) NOT NULL,
--		l_sales   NUMBER(10)  NOT NULL,
--		l_stock   NUMBER(10)  NOT NULL,
--      상품이미지 추가 칼럼?
--);

--CREATE TABLE eyes (
--		e_no      VARCHAR(10) PRIMARY KEY,
--		e_name    VARCHAR(20) UNIQUE NOT NULL,
--		e_price   NUMBER(10)  NOT NULL,
--		e_details VARCHAR(30) NOT NULL,
--		e_period  VARCHAR(10) NOT NULL,
--		e_date    VARCHAR(10) NOT NULL,
--		e_origin  VARCHAR(10) NOT NULL,
--		e_manuf   VARCHAR(10) NOT NULL,
--		e_sales   NUMBER(10)  NOT NULL,
--		e_stock   NUMBER(10)  NOT NULL,
--      상품이미지 추가 칼럼?
--);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
