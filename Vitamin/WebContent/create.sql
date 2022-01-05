-- 회원+관리자 테이블 
CREATE SEQUENCE member_seq;
DROP SEQUENCE member_seq;

SELECT * FROM MEMBER;
DROP TABLE MEMBER;
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
	maddr_etc     VARCHAR(50) NOT NULL,
	mtel    VARCHAR(30) NOT NULL,
	memail  VARCHAR(50) NOT NULL,
	mrole   VARCHAR(20) DEFAULT 'MEMBER'
);
--SQL문
--관리자 초기 데이터 입력을 위한 INSERT문
INSERT INTO MEMBER VALUES('EMP'||LPAD(member_seq.NEXTVAL, 3, 0), 'admin', '1234', 
	'관리자', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 'etc', '01011111111', 
	'이메일2', 'ADMIN');
--회원 INSERT문
INSERT INTO MEMBER(mno, mid, mpw, mname, mgender, mbirth, maddr_zipcode, maddr_street, 
	maddr_detail, maddr_etc, mtel, memail) VALUES('MEM'||LPAD(member_seq.NEXTVAL, 3, 0),
	'ID 2', '1234', 'NAME2', 'GENDER', 'BIRTH', '우편번호 입력', '도로명 입력', '상세주소 입력', 
	'etc', '01022222222', '이메일2');

	
	
-- 공지사항 테이블 
CREATE SEQUENCE notice_seq; 
DROP SEQUENCE notice_seq; 
SELECT ROWNUM, nidx, ntitle, ncont, writer FROM (SELECT * FROM notice ORDER BY nidx DESC) ORDER BY ROWNUM DESC;
SELECT * FROM notice;
DROP TABLE notice;
CREATE TABLE notice (
	nidx    NUMBER(5) PRIMARY KEY,
	ntitle  VARCHAR(100) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL,
	writer  VARCHAR(20) NOT NULL
);

insert into NOTICE values (notice_seq.NEXTVAL, '결제 관련 공지사항','결제 관련 공지사항입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '판매상품 관련 공지사항','판매상품 관련 공지사항입니다','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '이벤트 관련 공지사항','이벤트 관련 공지사항입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '멤버십 관련 공지사항','멤버십 관련 공지사항입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '택배 관련 공지사항','택배 관련 공지사항입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '준비중','준비중입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '준비중','준비중입니다','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '준비중','준비중입니다','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '준비중','준비중입니다','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '준비중','준비중입니다','관리자');



        
-- 고객문의 테이블 
CREATE SEQUENCE contact_seq; 
--DROP SEQUENCE contact_seq; 


select * from CONTACT;
DROP TABLE contact;
CREATE TABLE contact (
	msgno    NUMBER(2) PRIMARY KEY,
	msgname  VARCHAR(20) NOT NULL,
	msgemail VARCHAR(50) NOT NULL,
	msgtext  VARCHAR(2000) NOT NULL
);


CREATE SEQUENCE PROD_SEQ;

drop SEQUENCE PROD_SEQ;

drop table product;
truncate table product;
select * from product;
SELECT * FROM product WHERE pcode = 'EYES';
CREATE TABLE product(
	pno VARCHAR(20) PRIMARY KEY, -- 상품번호 예) 001
	pcode VARCHAR(50),           -- 상품분류 예) 종합비타민, 유산균, 루테인
	pimg_src VARCHAR(2000),      -- 이미지 절대경로
	pbrand VARCHAR(1000),        -- 브랜드
	pname VARCHAR(1000),         -- 상품이름
	pprice VARCHAR(50),           -- (할인된)가격
	pdiscount VARCHAR(50),       -- 할인율
	pdetail VARCHAR(2000),       -- 세부사항
	porigin VARCHAR(50),         -- 원산지
	pperiod VARCHAR(50),         -- 유통기한
	psales NUMBER(20) DEFAULT 0, -- 판매량
	pstock NUMBER(20) DEFAULT 0  -- 재고량
);

INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, pdetail, porigin, pperiod, psales, pstock) 
VALUES(1,'종합비타','https://www.uppear.co.kr/data/goods/20/08/32/1000000464/1000000464_main_088.jpg', '브랜드','비타민','10000','30%','소개설명글','미국','20221020','100','100');

INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount,pdetail,porigin, pperiod, psales, pstock) 
VALUES(2,'유산균','https://www.uppear.co.kr/data/goods/20/08/32/1000000464/1000000464_main_088.jpg', '브랜드2','비타민2','10000','30%','소개설명글','미국','20221020','100','100');


INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, pdetail,porigin, pperiod, psales, pstock) 
VALUES(3,'눈건강','https://www.uppear.co.kr/data/goods/20/08/32/1000000464/1000000464_main_088.jpg', '브랜드3','비타민3','10000','30%','소개설명글','미국','20221020','100','100');


select * from product;
