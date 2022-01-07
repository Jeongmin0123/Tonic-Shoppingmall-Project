-- 회원+관리자 테이블  
CREATE SEQUENCE member_seq;
--DROP SEQUENCE member_seq;

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
--DROP TABLE MEMBER;
SELECT * FROM MEMBER;

-- 관리자 초기 데이터 입력을 위한 INSERT문
INSERT INTO MEMBER VALUES('EMP'||LPAD(member_seq.NEXTVAL, 3, 0), 'ID 1', '1234', 
	'NAME1', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 'etc', '01011111111', 
	'이메일2', 'ADMIN');

	
	
	
-- 공지사항 테이블 
CREATE SEQUENCE notice_seq; 
--DROP SEQUENCE notice_seq; 

CREATE TABLE notice (
	nidx    NUMBER(5) PRIMARY KEY,
	ntitle  VARCHAR(100) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL, 
	writer  VARCHAR(20) UNIQUE NOT NULL
);
--DROP TABLE notice;
SELECT * FROM notice;




-- 상품 테이블
CREATE SEQUENCE PROD_SEQ;
--DROP SEQUENCE PROD_SEQ;

CREATE TABLE product(
	pno VARCHAR(20) PRIMARY KEY,        -- 상품번호 예) 001
	pcode VARCHAR(20),                  -- 상품분류 예) 종합비타민, 유산균, 루테인
	pimg_src VARCHAR(2000),             -- 이미지 절대경로
	pbrand VARCHAR(1000),               -- 브랜드
	pname VARCHAR(1000),                -- 상품이름
	pprice NUMBER(20),                  -- (할인된)가격, 크롤링 문제로 replace()를 사용해 ,와 '원'을 지워버리거나 타입을 변경하기.
	pdiscount VARCHAR(10) DEFAULT '0%', -- 할인율
	pdetail VARCHAR(2000),              -- 세부사항
	porigin VARCHAR(20),                -- 원산지
	pperiod VARCHAR(20),                -- 유통기한
	psales NUMBER(10) DEFAULT 0,        -- 판매량
	pstock NUMBER(10) DEFAULT 0         -- 재고량
);
-- DROP TABLE product;
SELECT * FROM product;

SELECT * FROM (SELECT * FROM product ORDER BY psales DESC) WHERE ROW NUM <= 6;



-- 고객문의 테이블 
CREATE SEQUENCE contact_seq; 
-- DROP SEQUENCE contact_seq; 

CREATE TABLE contact (
	msgno    NUMBER(5) PRIMARY KEY,
	msgname  VARCHAR(20) NOT NULL,
	msgemail VARCHAR(50) NOT NULL,
	msgtext  VARCHAR(2000) NOT NULL
);
SELECT * FROM contact;
-- DROP TABLE contact;










--ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
-- 회원 INSERT문
INSERT INTO MEMBER(mno, mid, mpw, mname, mgender, mbirth, maddr_zipcode, maddr_street, 
	maddr_detail, maddr_etc, mtel, memail) VALUES('MEM'||LPAD(member_seq.NEXTVAL, 3, 0),
	'ID 2', '1234', 'NAME2', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 
	'etc', '01022222222', '이메일2');
-- 1~200 랜덤으로 받아올 함수 
-- SELECT ROUND(DBMS_RANDOM.VALUE(1, 200)) AS RANDOM FROM DUAL; 
-- SELECT ROUND(DBMS_RANDOM.VALUE()*200)+1 AS RANDOM FROM DUAL; 
-- 원산지 랜덤 텍스트 DECODE()
SELECT DECODE(ROUND(DBMS_RANDOM.VALUE(1, 5)), 1, '국내산', 2, '중국산', 3, '미국산', 4, '백두산', 5, '일본산') FROM DUAL;
-- 유통기한 랜덤 DECODE() 
SELECT DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)), 1, '2022년 4월', 2, '2022년 9월', 3, '2022년 12월', 4, '2023년 5월', 5, '2023년 7월', 6, '2023년 11월', 7, '이미 썩었음') FROM DUAL;
-- 날짜 월, 일, 연도 랜덤 조합
SELECT TO_DATE(ROUND(DBMS_RANDOM.VALUE(1, 25)) || '-' || ROUND(DBMS_RANDOM.VALUE(1, 12)) 
|| '-' || ROUND(DBMS_RANDOM.VALUE(2022, 2025)), 'DD-MM-YYYY') FROM DUAL;
SELECT TO_DATE(ROUND(DBMS_RANDOM.VALUE(1, 25)) || '-' || ROUND(DBMS_RANDOM.VALUE(1, 12))
|| '-' || ROUND(DBMS_RANDOM.VALUE(2022, 2025)), 'DD-MM-YYYY') FROM DUAL;
-- 상품테이블 입력 예제
INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) 
VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), 'VITA', '이미지 경로.jpg', '브랜드', '상품명', 5, '할인율 0%',
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'국내산',2,'중국산',3,'미국산',4,'대만산',5,'일본산',6,'독일산',7,'파푸아뉴기니산'),
DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'유통기한만료'),
ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)));

