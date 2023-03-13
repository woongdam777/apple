-- 1번
/*
EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
단, 입사일-오늘의 별칭은 "근무일수1", 
오늘-입사일의 별칭은 "근무일수2"로 하고
모두 정수(내림)처리, 양수가 되도록 처리
*/
--ABS와 FLOOR위치가 바뀌면 음수를 내림 처리하면 숫자가 증가되고 양수를 내림처리하면 숫자가 감소하기 때문에 값의 차이가 있다.
SELECT EMP_NAME 사원명, FLOOR(ABS(HIRE_DATE - SYSDATE)) 근무일수1, FLOOR(SYSDATE - HIRE_DATE) 근무일수2 
FROM EMPLOYEE;

-- 2번
/*
EMPLOYEE 테이블에서 사번이 홀수인 사원의
사번, 이름, 이메일, 전화번호 조회
*/
SELECT EMP_ID , EMP_NAME ,EMAIL ,PHONE 
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2)<>0;
-- WHERE SUBSTR(EMP_id, -1,1) IN(1,3,5,7,9);    -1부터하면 거꾸로 시작됨

-- 3번
/*EMPLOYEE 테이블에서 근무한지 20년 이상인 사원의 모든 정보 조회*/
SELECT *
FROM EMPLOYEE 
WHERE EXTRACT (YEAR FROM SYSDATE)-EXTRACT(YEAR FROM HIRE_DATE) >=20;
--WHERE MONTHS_BETWEEN(SALARY, HIRE_DATE)/12 >=20; 

-- 4번
/*
EMPLOYEE 테이블에서 사원명과 주민번호를 조회
단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
예 : 홍길동 771120-1******
*/
SELECT EMP_NAME , SUBSTR(EMP_NO, 1,8) || '******' AS 주민등록번호
--SELECT EMP_NAME , REPLACE(EMP_NO, SUBSTR(EMP_NO, 9),'******) ' AS 주민등록번호
--RPAD(SUBSTR(EMP_NO, 1, 8),14 , '*') 주민등록번호 //LPAD 왼쪽부터
FROM EMPLOYEE ;

-- 5번
/*
EMPLOYEE 테이블에서 사원명, 직급코드, 연봉(원) 조회
단, 연봉은 보너스가 적용된 1년치 급여 + ￦57,000,000 으로 표시
(급여 + (급여 * 보너스) )* 12
*/
SELECT EMP_NAME , JOB_CODE ,
		TO_CHAR((SALARY+(SALARY*NVL(BONUS,0)))*12,'L999,999,999') AS "연봉(원)"
FROM EMPLOYEE;

-- 6번
/*
EMPLOYEE 테이블에서
부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 사원의
사번 사원명 부서코드 입사일 조회
 */
SELECT EMP_ID ,EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE 
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') AND EXTRACT (YEAR FROM HIRE_DATE) = 2004;
--WHERE DEPT_CODE IN('D5','D9') AND EXTRACT (YEAR FROM HIRE_DATE) = 2004;
--WHERE DEPT_CODE IN('D5','D9') AND TO_CHAR(HIRE_DATE, 'YYYY') = '2004';

-- 7번
/*
 EMPLOYEE 테이블에서 사원명, 입사일, 입사한 달의 근무일수 조회
단, 입사한 날도 근무일수에 포함해서 +1 할 것
*/
SELECT EMP_NAME , HIRE_DATE , EXTRACT (DAY FROM LAST_DAY(HIRE_DATE))-EXTRACT(DAY FROM HIRE_DATE)+1 "입사한 달의 근무 일수"
--SELECT EMP_NAME , HIRE_DATE , LAST_DAY(HIRE_DATE)-HIRE_DATE)+1 "입사한 달의 근무 일수"
--날짜끼리 연산하면 일수로 나온다.
FROM EMPLOYEE ;


-- 8번
/*
EMPLOYEE 테이블에서 사원명, 부서코드, 생년월일, 만 나이 조회
단, 생년월일은 주민번호에서 추출해서 ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산
*/
SELECT EMP_NAME ,DEPT_CODE ,TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6)),'YY"년" MM"월" DD"일"') 생년월일,
--							SUBSTR(EMP_NO, 1, 2) || '년' ||SUBSTR(EMP_NO, 3, 2) || '월' ||SUBSTR(EMP_NO, 5, 2) || '일' 생년월일
--	    FLOOR((TO_DATE(SYSDATE) - TO_DATE(SUBSTR(EMP_NO,1,6)))/365)	"만 나이"
		FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO,1,6)))/12) "만 나이" 
FROM EMPLOYEE; 






