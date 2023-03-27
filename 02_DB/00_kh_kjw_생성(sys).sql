-- 한 줄 주석

/*
범위
주석
*/

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- CTRL + ENTER : 선택한 SQL 수행

-- 사용자 계정 생성
CREATE USER kh_kjw IDENTIFIED BY "oracle_kjw123A";

-- 사용자 계정에 권환 부여
GRANT RESOURCE, CONNECT TO kh_kjw;

-- 객체가 생성될 수 잇는 공간 할당량 지정
ALTER USER kh_kjw DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

