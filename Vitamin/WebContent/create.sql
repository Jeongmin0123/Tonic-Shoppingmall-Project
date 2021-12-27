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
	maddr_etc     VARCHAR(50),
	mtel    VARCHAR(30) UNIQUE NOT  NULL,
	memail  VARCHAR(50) UNIQUE NOT NULL,
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

SELECT * FROM notice;
DROP TABLE notice;
CREATE TABLE notice (
	nidx    NUMBER(5) PRIMARY KEY,
	ntitle  VARCHAR(100) NOT NULL,
	ncont   VARCHAR(2000) NOT NULL,
	writer  VARCHAR(20) NOT NULL
);

insert into NOTICE values (notice_seq.NEXTVAL, '결제 관련 공지사항','결제 관련 공지사항입니다.','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목2','내용2','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목3','내용3','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목4','내용4','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목5','내용5','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목6','내용6','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목7','내용7','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목8','내용8','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목9','내용9','관리자');
insert into NOTICE values (notice_seq.NEXTVAL, '제목10','내용10','관리자');


-- 상품 DB 테이블
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


        
-- 고객문의 테이블 
CREATE SEQUENCE contact_seq; 
--DROP SEQUENCE contact_seq; 

--DROP TABLE contact;
CREATE TABLE contact (
	msgno    NUMBER(2) PRIMARY KEY,
	msgname  VARCHAR(20) NOT NULL,
	msgemail VARCHAR(50) NOT NULL,
	msgtext  VARCHAR(2000) NOT NULL
);