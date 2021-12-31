-- 회원+관리자 테이블 
CREATE SEQUENCE member_seq;
--DROP SEQUENCE member_seq;

SELECT * FROM MEMBER;
--DROP TABLE MEMBER;
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
	memail  VARCHAR(50) UNIQUE NOT NULL,
	mrole   VARCHAR(20) DEFAULT 'MEMBER'
);
-- SQL문
-- 관리자 초기 데이터 입력을 위한 INSERT문
INSERT INTO MEMBER VALUES('EMP'||LPAD(member_seq.NEXTVAL, 3, 0), 'ID 1', '1234', 
	'NAME1', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 'etc', '01011111111', 
	'이메일2', 'ADMIN');
-- 회원 INSERT문
INSERT INTO MEMBER(mno, mid, mpw, mname, mgender, mbirth, maddr_zipcode, maddr_street, 
	maddr_detail, maddr_etc, mtel, memail) VALUES('MEM'||LPAD(member_seq.NEXTVAL, 3, 0),
	'ID 2', '1234', 'NAME2', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 
	'etc', '01022222222', '이메일2');

	
-- 공지사항 테이블 
CREATE SEQUENCE notice_seq; 
--DROP SEQUENCE notice_seq; 

SELECT * FROM notice;
--DROP TABLE notice;
CREATE TABLE notice (
	nidx    NUMBER(5) PRIMARY KEY,
	ntitle  VARCHAR(100) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL, 
	writer  VARCHAR(20) UNIQUE NOT NULL
);


-- 상품 DB 테이블
CREATE SEQUENCE PROD_SEQ;
--DROP SEQUENCE PROD_SEQ;

CREATE TABLE product(
	pno VARCHAR(20) PRIMARY KEY, -- 상품번호 예) 001
	pcode VARCHAR(20),           -- 상품분류 예) 종합비타민, 유산균, 루테인
	pimg_src VARCHAR(2000),      -- 이미지 절대경로
	pbrand VARCHAR(1000),        -- 브랜드
	pname VARCHAR(1000),         -- 상품이름
	pprice NUMBER(10),           -- (할인된)가격
	pdiscount VARCHAR(10),       -- 할인율
	pdetail VARCHAR(2000),       -- 세부사항
	porigin VARCHAR(20),         -- 원산지
	pperiod VARCHAR(20),         -- 유통기한
	psales NUMBER(10) DEFAULT 0, -- 판매량
	pstock NUMBER(10) DEFAULT 0  -- 재고량
);
-- DROP TABLE product;

-- DAO에 넣을 INSERT SQL문
INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) 
VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), ?, ?, ?, ?, ?, ?,
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1, '국내산', 2, '중국산', 3, '미국산', 4, '대만산', 5, '일본산', 6, '독일산', 7, '파푸아뉴기니산'),
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'이미 썩었음'),
ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)));
-- 예제
INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) 
VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), '종합비타민', '이미지 경로.jpg', '브랜드', '상품명', 5, '할인율',
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'국내산',2,'중국산',3,'미국산',4,'대만산',5,'일본산',6,'독일산',7,'파푸아뉴기니산'),
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'이미 썩었음'),
ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)));

SELECT * FROM product;

-- SELECT ROUND(DBMS_RANDOM.VALUE(1, 200)) AS RANDOM FROM DUAL; 
-- SELECT ROUND(DBMS_RANDOM.VALUE()*200)+1 AS RANDOM FROM DUAL; 
        
-- 고객문의 테이블 
CREATE SEQUENCE contact_seq; 
-- DROP SEQUENCE contact_seq; 

-- DROP TABLE contact;
CREATE TABLE contact (
	msgno    NUMBER(5) PRIMARY KEY,
	msgname  VARCHAR(20) NOT NULL,
	msgemail VARCHAR(50) NOT NULL,
	msgtext  VARCHAR(2000) NOT NULL
);


/*
 * (구)상품테이블 
CREATE SEQUENCE prod_seq;
--DROP SEQUENCE prod_seq;

SELECT * FROM PRODUCT;
--DESC PRODUCT;
--DROP TABLE PRODUCT;

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
	pimage  VARCHAR(200)               -- 이미지 테이블(CLOB || VARCHAR)
);--이미지 경로, 사이즈(미정) 넣을 칼럼 추가 
*/


-- 원산지 랜덤 텍스트 DECODE()
SELECT DECODE(ROUND(DBMS_RANDOM.VALUE(1, 5)), 1, '국내산', 2, '중국산', 3, '미국산', 4, '백두산', 5, '일본산') FROM DUAL;
-- 유통기한 랜덤 DECODE() 
SELECT DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)), 1, '2022년 4월', 2, '2022년 9월', 3, '2022년 12월', 4, '2023년 5월', 5, '2023년 7월', 6, '2023년 11월', 7, '이미 썩었음') FROM DUAL;
-- 날짜 월, 일, 연도 랜덤 조합
SELECT TO_DATE(ROUND(DBMS_RANDOM.VALUE(1, 25)) || '-' || ROUND(DBMS_RANDOM.VALUE(1, 12)) 
|| '-' || ROUND(DBMS_RANDOM.VALUE(2022, 2025)), 'DD-MM-YYYY') FROM DUAL;
SELECT TO_DATE(ROUND(DBMS_RANDOM.VALUE(1, 25)) || '-' || ROUND(DBMS_RANDOM.VALUE(1, 12))
|| '-' || ROUND(DBMS_RANDOM.VALUE(2022, 2025)), 'DD-MM-YYYY') FROM DUAL;