ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--계정 생성
CREATE USER project IDENTIFIED BY "project1234";
-- 권한 부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO project;
-- 객체 생성 공간 할당
ALTER USER project DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

--------------------------------

DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NICKNAME" VARCHAR2(30) NOT NULL,
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDR"	VARCHAR2(300)		NULL,
	"PROFILE_IMG"	VARCHAR2(300)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호(SEQ_MEMBER_NO';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호(암호화 적용)';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 이름(별명)';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(-없음)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 저장 경로';
COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';
COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N:탈퇴X, Y:탈퇴O)';
COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원권한(1:일반, 2:관리자)';
--기본키
ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);
--탈퇴여부 CEHCK 제약조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_MEMBER_DEL_FL"
CHECK("MEMBER_DEL_FL" IN ('N', 'Y'));
--권한 CEHCK 제약조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_AUTHORITY"
CHECK("AUTHORITY" IN ('1', '2'));

--시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBER" 
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr', 'pass01', '유저일', '01012345678'
, '04540,,서울시 중구 남대문로 120,,2층', NULL, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO "MEMBER" 
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02@kh.or.kr', 'pass02', '이유저', '01087654321'
, '04540,,서울시 중구 남대문로 120,,2층', NULL, DEFAULT, DEFAULT, DEFAULT);

SELECT * FROM "MEMBER";

COMMIT;

-- 로그인 SQL

SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDR, PROFILE_IMG, AUTHORITY
, TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE
FROM "MEMBER"
WHERE MEMBER_DEL_FL ='N'
AND MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_PW = 'pass01'
;


-- user01의 비밀번호 변경
UPDATE "MEMBER"
SET MEMBER_PW ='$2a$10$y5W8D373Vo9/yjKzFjc7heUVcDwLY5kuhfypkpKU6k.92bQ8R4sEq';

DELETE FROM "MEMBER"
WHERE MEMBER_NO IN (2,3,4,5,6,7,1,8);

DROP SEQUENCE SEQ_MEMBER_NO;

UPDATE MEMBER
SET MEMBER_ADDR = REPLACE(MEMBER_ADDR, ',,', '^^^')
WHERE INSTR(MEMBER_ADDR, ',,') > 0;

-- 회원정보수정
UPDATE "MEMBER" SET
MEMBER_NICKNAME =? 
MEMBER_TEL =?
MEMBER_ADDR = ?
WHERE MEMBER_NO = ?
;

-- 회원번호가 일치하는 회원의 비밀번호 조회
SELECT MEMBER_PW
FROM "MEMBER"
WHERE MEMBER_NO = ?
;

--회원번호가 일치하는 회원의 비밀번호 변경
UPDATE "MEMBER" SET MEMBER_PW =?
WHERE MEMBER_NO = ?
;

-- 이메일로 회원 정보 조회
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_TEL, NVL(MEMBER_ADDR, '미작성') AS MEMBER_ADDR 
		,TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE
FROM "MEMBER" 
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_DEL_FL ='N'
;

-- 이메일이 일부라도 일치하는 모든회원 조회
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME 
FROM "MEMBER" 
WHERE MEMBER_DEL_FL ='N'
AND MEMBER_EMAIL LIKE '%user%'
ORDER BY MEMBER_NO 
;

---------------------------------------------------------------
-- 이메일 인증
DROP TABLE "AUTH_KEY";

CREATE TABLE "AUTH_KEY" (
	"AUTH_KEY_NO"	NUMBER		NOT NULL,
	"CODE"	CHAR(6)		NOT NULL,
	"EMAIL"	VARCHAR2(50)		NOT NULL,
	"CREATE_TIME"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "AUTH_KEY"."AUTH_KEY_NO" IS '인증키 구분 번호(SEQ_AUTH_KEY_NO)';

COMMENT ON COLUMN "AUTH_KEY"."CODE" IS '코드';

COMMENT ON COLUMN "AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "AUTH_KEY" ADD CONSTRAINT "PK_AUTH_KEY" PRIMARY KEY (
	"AUTH_KEY_NO"
);


CREATE SEQUENCE SEQ_AUTH_KEY_NO NOCACHE;


UPDATE "AUTH_KEY" SET
CODE = #{authkey},
CREATE_TIME = sysdate
WHERE EMAIL = #{email};

INSERT INTO "AUTH_KEY" VALUES(SEQ_AUTH_KEY_NO.NEXTVAL, #{authkey}, #{email}, DEFAULT);

SELECT * FROM "AUTH_KEY";

SELECT COUNT(*) FROM "AUTH_KEY"
WHERE EMAIL = #{email}
AND CODE = #{inputKey};

----------------------------------------------------------------------------------------

-- 게시판 종류

CREATE TABLE "BOARD_TYPE"(
	"BOARD_CODE" NUMBER CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY,
	"BOARD_NAME" VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CODE" IS '게시판 코드(SEQ_BOARD_CODE)';
COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NAME" IS '게시판 이름';

CREATE SEQUENCE SEQ_BOARD_CODE NOCACHE;

-- 게시판 종류 추가
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '공지사항');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '자유 게시판');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '테스트 게시판');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '질문 게시판');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '점심 게시판');

COMMIT;

SELECT * FROM "BOARD_TYPE";



------------------------------------------

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"B_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"B_UPDATE_DATE"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."B_CREATE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."B_UPDATE_DATE" IS '마지막 수정일(수정 시 UPDATE)';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_DEL_FL" IS '삭제 여부(N : 삭제X , Y : 삭제O)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';

COMMENT ON COLUMN "BOARD"."BOARD_CODE" IS '게시판 코드 번호';

----------------------------------------------------------------------

CREATE TABLE "BOARD_IMG" (
	"IMG_NO"	NUMBER		NOT NULL,
	"IMG_PATH"	VARCHAR2(300)		NOT NULL,
	"IMG_RENAME"	VARCHAR2(30)		NOT NULL,
	"IMG_ORIGINAL"	VARCHAR2(300)		NOT NULL,
	"IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호(SEQ_IMG_NO)';

COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 저장 폴더 경로';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '변경된 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '원본 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORDER" IS '이미지 파일 순서 번호';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '이미지가 첨부된 게시글 번호';


----------------------------------------------------------------------


CREATE TABLE "BOARD_LIKE" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_NO" IS '게시글 번호';

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '좋아요 누른 회원 번호';


----------------------------------------------------------------------


CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"C_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"COMMENT_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PARENT_NO"	NUMBER	
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호(SEQ_COMMENT_NO)';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."C_CREATE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DEL_FL" IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '댓글이 작성된 게시글 번호';

COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '댓글 작성자 회원 번호';

COMMENT ON COLUMN "COMMENT"."PARENT_NO" IS '부모 댓글 번호';

----------------------------------------------------------------------


ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "PK_BOARD_IMG" PRIMARY KEY (
	"IMG_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "PK_BOARD_LIKE" PRIMARY KEY (
	"BOARD_NO",
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "BOARD_TYPE" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMG_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_COMMENT_TO_COMMENT_1" FOREIGN KEY (
	"PARENT_NO"
)
REFERENCES "COMMENT" (
	"COMMENT_NO"
);


CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시글 번호
CREATE SEQUENCE SEQ_IMG_NO NOCACHE; -- 게시글 이미지 번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글 번호


-- BOARD 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1500 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              SEQ_BOARD_NO.CURRVAL || '번째 게시글',
              SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, 18, 
              CEIL(DBMS_RANDOM.VALUE(0,4))
      );
   END LOOP;
END;

COMMIT;

SELECT * FROM "MEMBER"
WHERE  MEMBER_NO =18;

SELECT * FROM "BOARD_TYPE";

SELECT COUNT(*) FROM "BOARD";

-- BOARD CODE가 1(공지사항)인 게시글을 최신순으로 조회
-- 단, 삭제된 글은 제외
SELECT * FROM "BOARD"
WHERE BOARD_CODE = 1
AND BOARD_DEL_FL = 'N'
ORDER BY BOARD_NO DESC;

----------------------------------------------
-- COMMENT 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1000 LOOP
	   INSERT INTO "COMMENT" 
		VALUES(SEQ_COMMENT_NO.NEXTVAL, 
				SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
				DEFAULT, DEFAULT,
				 CEIL(DBMS_RANDOM.VALUE(0,1500)),
				 18, NULL);
   END LOOP;
END;


COMMIT;


SELECT * FROM "COMMENT";

DROP TABLE "COMMENT";
DROP SEQUENCE SEQ_COMMENT_NO;



-- 게시글 샘플 이미지
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00001.png', 'lion1.png', 0, 1495);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00002.png', 'lion2.png', 0, 1493);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00003.png', 'lion3.png', 0, 1487);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00004.png', 'lion4.png', 0, 1486);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00005.png', 'lion5.png', 0, 1485);

COMMIT;	
	
SELECT BOARD_NO FROM "BOARD"
WHERE BOARD_CODE = 1
ORDER BY 1 DESC;

SELECT * FROM "BOARD_IMG";

UPDATE "BOARD_IMG"
SET IMG_ORIGINAL = 'lion5.png'
WHERE BOARD_NO = 1485;

--특정 게시판의 삭제되지 않은 게시글 수 조회
SELECT COUNT(*) FROM "BOARD"
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 4;

-- 특정 게시판 목록 조회
-- 1. 최신 순서
-- 2. 1PAGE(1~10행) 조회
-- 3. 삭제된 글은 제외

-- 마이바티스 O
--> RowBounds 객체 이용
SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME
	, TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD') B_CREATE_DATE
	, READ_COUNT
FROM "BOARD"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1
ORDER BY BOARD_NO DESC
;

-- 마이바티스 X
-- 1~10행 조회
-- ROWNUM은 WHERE절에 사용될 때 1행이 조건에 포함되어야 한다
SELECT * FROM(
	SELECT ROWNUM NUM, A.* FROM(
		SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME
			, TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD') B_CREATE_DATE
			, READ_COUNT
		FROM "BOARD"
		JOIN "MEMBER" USING(MEMBER_NO)
		WHERE BOARD_DEL_FL = 'N'
		AND BOARD_CODE = 1
		ORDER BY BOARD_NO DESC
		) A
)
WHERE NUM BETWEEN 11 AND 20
;

SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME, READ_COUNT, 
	CASE  
		WHEN SYSDATE - B_CREATE_DATE < 1/24/60 /* 1분 미만*/
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60 * 60 ) || '초 전'
		WHEN SYSDATE - B_CREATE_DATE < 1/24 /* 1시간 미만*/
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60) || '분 전'
		WHEN SYSDATE - B_CREATE_DATE < 1 /* 1일 미만*/
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24) || '시간 전'
		ELSE TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD')
	END CREATE_DATE,
	(SELECT COUNT(*) FROM "COMMENT" C
	 WHERE C.BOARD_NO = B.BOARD_NO) COMMENT_COUNT,
	(SELECT COUNT(*) FROM BOARD_LIKE L
	 WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT,
	(SELECT IMG_PATH || IMG_RENAME FROM BOARD_IMG I
	WHERE I.BOARD_NO = B.BOARD_NO
	AND IMG_ORDER = 0) THUMBNAIL
FROM "BOARD" B
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1
ORDER BY BOARD_NO DESC;

-- 게시글 상세 조회
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_CODE, READ_COUNT, MEMBER_NICKNAME, MEMBER_NO, PROFILE_IMG
		, TO_CHAR(B_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') B_CREATE_DATE
		, TO_CHAR(B_UPDATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') B_UPDATE_DATE
		, (SELECT COUNT(*) FROM "BOARD_LIKE" L WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT
FROM "BOARD" B
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1
AND BOARD_NO = 1495
;

SELECT * FROM "BOARD" ORDER BY 1 DESC;

SELECT * FROM "BOARD_LIKE";

-- 게시글 좋아요 샘플데이터 삽입
INSERT INTO "BOARD_LIKE" VALUES(1495, 18);
INSERT INTO "BOARD_LIKE" VALUES(1495, 17);
COMMIT;

-- 특정 게시글의 좋아요 개수 카운트
SELECT COUNT(*)
FROM "BOARD_LIKE" L
WHERE L.BOARD_NO = 1495
;

-- 특정 게시글에 대한 이미지 조회(IMG_ORDER 오름차순)
SELECT * FROM BOARD_IMG
WHERE BOARD_NO = 1495
ORDER BY IMG_ORDER;

INSERT INTO BOARD_IMG 
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/','20230508115013_00002.png', 'lion2.png',1,1495);

INSERT INTO BOARD_IMG 
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/','20230508115013_00003.png', 'lion3.png',2,1495);

COMMIT;

-- 특정 게시글에 대한 댓글 목록 조회(바뀔예정)
SELECT COMMENT_NO, COMMENT_CONTENT,
      TO_CHAR(C_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') C_CREATE_DATE,
      BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
FROM "COMMENT"
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_NO = 1495
ORDER BY COMMENT_NO
;

-- 회원 프로필 이미지 변경
UPDATE "MEMBER" SET
PROFILE_IMG = '/resources/images/member/profile.gif'
WHERE MEMBER_NO = 18;

COMMIT;

SELECT * FROM "BOARD"
WHERE BOARD_NO =1495;

SELECT * FROM BOARD_LIKE ;

-- 좋아요 여부 확인
SELECT COUNT(*) FROM "BOARD_LIKE"
WHERE BOARD_NO = 1495 -- 게시글 번호
AND MEMBER_NO = 18 -- 로그인 회원번호
;

--좋아요 테이블 삽입
INSERT INTO "BOARD_LIKE" 
VALUES (BOARD_NO, MEMBER_NO)
;

--좋아요 테이블 삭제
DELETE FROM "BOARD_LIKE"
WHERE BOARD_NO = 1495
AND MEMBER_NO = 18
;

COMMIT;


-- 한번에 여러개 INSERT 하기

-- INSERT ALL : 여러 테이블에 동시에 INSERT 하는 구문
--> 시퀀스 생성 구문을 작성하지 못함 (탈락)

-- INSERT + SUB QUERY

INSERT INTO "BOARD_IMG"

SELECT SEQ_IMG.NO.NEXTVAL,A.*
FROM(
	SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
		0 IMG_ORDER, 1495 BOARD_NO
	FROM DUAL
	
	UNION ALL
	
	SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
		1 IMG_ORDER, 1495 BOARD_NO
	FROM DUAL
	
	UNION ALL
	
	SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
		2 IMG_ORDER, 1495 BOARD_NO
	FROM DUAL
) A;


ROLLBACK;


-- 게시글 수정
UPDATE "BOARD" SET
BOARD_TITLE = #{boardTitile},
BOARD_CONTENT = #{boardContent},
B_UPDATE_DATE = SYSDATE 
WHERE BOARD_CODE = #{boardCode} 
AND BOARD_NO = #{boardNo}
;


-- 이미지 삭제
DELETE FROM "BOARD_IMG"
WHERE BOARD_NO = #{boardNo}
AND IMG_ORDER IN (${deleteList})
;

-- 이미지 수정
UPDATE "BOARD_IMG" SET
IMG_PATH = #{imagePath},
IMG_ORIGINAL = #{imageOriginal}, 
IMG_RENAME = #{imageReName}
WHERE BOARD_NO = #{boardNo}
AND IMG_ORDER = #{imageOrder}
;

--게시글 삭제
UPDATE "BOARD" SET
BOARD_DEL_FL = 'Y'
WHERE BOARD_NO = #{boardNo}
AND MEMBER_NO =#{memberNo}
;


----------------------------------------------


SELECT * FROM "BOARD_IMG" ORDER BY 1 DESC;


UPDATE "BOARD_IMG" SET
IMG_PATH = '#{imagePath}',
IMG_ORIGINAL = '#{imageOriginal}',
IMG_RENAME = '#{imageReName}'
WHERE BOARD_NO = 1495
AND IMG_ORDER = 0
;


ROLLBACK;





-- 댓글 목록 조회
SELECT COMMENT_NO, COMMENT_CONTENT,
    TO_CHAR(C_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') C_CREATE_DATE,
    BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
FROM "COMMENT"
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_NO = 1495
ORDER BY COMMENT_NO
;

SELECT * FROM "BOARD"
ORDER BY BOARD_NO DESC;

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '부모 댓글 1', DEFAULT, DEFAULT, 1495, 18, NULL);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '부모 댓글 2', DEFAULT, DEFAULT, 1495, 18, NULL);

-- 1001 ,1002

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 1-1', DEFAULT, DEFAULT, 1495, 18, 1001);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 1-2', DEFAULT, DEFAULT, 1495, 18, 1001);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 1-3', DEFAULT, DEFAULT, 1495, 18, 1001);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 2-1', DEFAULT, DEFAULT, 1495, 18, 1002);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 2-2', DEFAULT, DEFAULT, 1495, 18, 1002);

INSERT INTO "COMMENT"									-- 게시글, 회원
VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식의 자식 댓글 2-1-1', DEFAULT, DEFAULT, 1495, 18, 1006);

COMMIT;


/* 계층형 쿼리(START WITH, CONNECT BY, ORDER SIBLINGS BY)  
- 상위 타입과 하위 타입간의 관계를 계층식으로 표현할 수 있게하는 질의어(SELECT)

- START WITH : 상위 타입(최상위 부모)으로 사용될 행을 지정 (서브쿼리로 지정 가능)

- CONNECT BY 
  -> 상위 타입과 하위 타입 사이의 관계를 규정
  -> PRIOR(이전의) 연산자와 같이 사용하여
		현재 행 이전에 상위 타입 또는 하위 타입이 있을지 규정

	1) 부모 -> 자식 계층 구조
		CONNECT BY PRIOR 자식 컬럼 = 부모 컬럼

	2) 자식 -> 부모 계층 구조
		CONNECT BY PRIOR 부모 컬럼 = 자식 컬럼

- ORDER SIBLINGS BY : 계층 구조 정렬


** 계층형 쿼리가 적용 SELECT 해석 순서 **

5 : SELECT
1 : FROM (+JOIN)
4 : WHERE
2 : START WITH
3 : CONNECT BY
6 : ORDER SIBLINGS BY

- WHERE절이 계층형 쿼리보다 해석 순서가 늦기 때문에
먼저 조건을 반영하고 싶은 경우 FROM절 서브쿼리(인라인뷰)를 이용
 * */


-- 댓글 목록 조회(계층형 쿼리 적용)
SELECT LEVEL, C.* FROM
	(SELECT COMMENT_NO, COMMENT_CONTENT,
		TO_CHAR(C_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') C_CREATE_DATE,
		BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
	FROM "COMMENT"
	JOIN MEMBER USING(MEMBER_NO)
	WHERE BOARD_NO = 2011) C
WHERE COMMENT_DEL_FL = 'N'
START WITH PARENT_NO IS NULL
CONNECT BY PRIOR COMMENT_NO = PARENT_NO
ORDER SIBLINGS BY COMMENT_NO
;

--------------------------------------------------------------
-- 채팅
CREATE TABLE "CHATTING_ROOM" (
	"CHATTING_NO"	NUMBER		NOT NULL,
	"CH_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"OPEN_MEMBER"	NUMBER		NOT NULL,
	"PARTICIPANT"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "CHATTING_ROOM"."CHATTING_NO" IS '채팅방 번호';
COMMENT ON COLUMN "CHATTING_ROOM"."CH_CREATE_DATE" IS '채팅방 생성일';
COMMENT ON COLUMN "CHATTING_ROOM"."OPEN_MEMBER" IS '개설자 회원 번호';
COMMENT ON COLUMN "CHATTING_ROOM"."PARTICIPANT" IS '참여자 회원 번호';
ALTER TABLE "CHATTING_ROOM" ADD CONSTRAINT "PK_CHATTING_ROOM" PRIMARY KEY (
	"CHATTING_NO"
);

ALTER TABLE "CHATTING_ROOM"
ADD CONSTRAINT "FK_OPEN_MEMBER"
FOREIGN KEY ("OPEN_MEMBER") REFERENCES "MEMBER";

ALTER TABLE "CHATTING_ROOM"
ADD CONSTRAINT "FK_PARTICIPANT"
FOREIGN KEY ("PARTICIPANT") REFERENCES "MEMBER";

DROP TABLE "MESSAGE";

CREATE TABLE "MESSAGE" (
	"MESSAGE_NO"	NUMBER		NOT NULL,
	"MESSAGE_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"READ_FL"	CHAR	DEFAULT 'N'	NOT NULL,
	"SEND_TIME"	DATE	DEFAULT SYSDATE	NOT NULL,
	"SENDER_NO"	NUMBER		NOT NULL,
	"CHATTING_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "MESSAGE"."MESSAGE_NO" IS '메세지 번호';
COMMENT ON COLUMN "MESSAGE"."MESSAGE_CONTENT" IS '메세지 내용';
COMMENT ON COLUMN "MESSAGE"."READ_FL" IS '읽음 여부';
COMMENT ON COLUMN "MESSAGE"."SEND_TIME" IS '메세지 보낸 시간';
COMMENT ON COLUMN "MESSAGE"."SENDER_NO" IS '보낸 회원의 번호';
COMMENT ON COLUMN "MESSAGE"."CHATTING_NO" IS '채팅방 번호';
ALTER TABLE "MESSAGE" ADD CONSTRAINT "PK_MESSAGE" PRIMARY KEY (
	"MESSAGE_NO"
);

ALTER TABLE "MESSAGE"
ADD CONSTRAINT "FK_CHATTING_NO"
FOREIGN KEY ("CHATTING_NO") REFERENCES "CHATTING_ROOM";

ALTER TABLE "MESSAGE"
ADD CONSTRAINT "FK_SENDER_NO"
FOREIGN KEY ("SENDER_NO") REFERENCES "MEMBER";

-- 시퀀스 생성
CREATE SEQUENCE SEQ_ROOM_NO NOCACHE;
CREATE SEQUENCE SEQ_MESSAGE_NO NOCACHE;


SELECT * FROM BOARD_IMG;

SELECT IMG_RENAME FROM BOARD_IMG;