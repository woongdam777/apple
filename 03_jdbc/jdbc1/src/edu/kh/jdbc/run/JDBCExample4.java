package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		SelectJobNameDAO dao = new SelectJobNameDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명 : ");
		String input = sc.nextLine();
		
		// DAO 생성 후 메서드 호출
		List<Employee2> empList = dao.select(input);
		
		if(empList.isEmpty()) {
			System.out.println("입력된 직급명과 일치하는 사원이 없습니다.");
			return;
		}		
		
		for(Employee2 e : empList) {
			System.out.printf("%s / %s / %s / %s \n",
							e.getDeptName(),
							e.getJobName(),
							e.getEmpName(),
							e.getEmail());
		}
		
	}
}

/*
직급명을 입력 받아 일치하는 사원의
부서명, 직급명, 이름, 이메일을  이름 오름 차순으로 조회

[요구사항]
--실행용 클래스--
JDBCExample4 클래스


--부서명, 직급명, 이름, 이메일을 저장할 수 있는 DTO 클래스--
Employee2 클래스

-- DB와 연결하여 SQL을 수행하는 클래스 --
SelectJobNameDAO 클래스
-> select() 메서드 작성


---조회 결과가 있을 경우 ---
(부서명이 NULL인 경우 "부서없음" 으로 조회)

기술지원부 / 대리 / 이태림 / lee_tr@or.kr
기술지원부 / 대리 / 장쯔위 / jang_zw@or.kr
인사관리부 / 대리 / 전지연 / jun_jy@or.kr
기술지원부 / 대리 / 전형돈 / jun_hd@or.kr
인사관리부 / 대리 / 차태연 / cha_ty@or.kr
부서없음 / 대리 / 하동운 / ha_dh@or.kr


---조회 결과가 없을 경우 ---
입력된 직급명과 일치하는 사원이 없습니다.

*/


/*
java.lang.ClassNotFoundException
- Class.forName("oracle.jdbc.driver.OracleDriver"); 
  구문에 오타가 있는 경우
  
java.sql.SQLException: ORA-01017: 
사용자명/비밀번호가 부적합, 로그온할 수 없습니다
- 아이디 또는 비밀번호 오타

java.sql.SQLRecoverableException: IO 오류: 
The Network Adapter could not establish the connection 
- DB 연결을 위한 URL (type, ip, port, dbName)에 오타


java.sql.SQLSyntaxErrorException
- SQL 문법이 잘못됨

java.sql.SQLSyntaxErrorException: ORA-00933: 
SQL 명령어가 올바르게 종료되지 않았습니다
- SQL에 세미콜론이 포함됨


java.sql.SQLException: 실행할 SQL 문은 비어 있거나 널일 수 없음
- Statement를 이용해서 SQL 수행 시 SQL이 ""(빈문자열) 또는 NULL인 경우


java.sql.SQLException: 부적합한 열 이름
- rs.get자료형("컬럼명") 구문에서 "컬럼명"을 잘못 작성한 경우
*/
