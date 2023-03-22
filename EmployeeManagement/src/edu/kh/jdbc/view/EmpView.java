package edu.kh.jdbc.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Emp;
import edu.kh.jdbc.model.service.EmpService;

public class EmpView {
  
	private Scanner sc = new Scanner(System.in);
	
	private EmpService service = new EmpService();
	
	//** 모든 기능에는 예외상황에 따른 출력 구문 필수 작성 **
	//** 필요에 따라 DTO에 생성자 추가 **
	//** 메서드명, 출력 화면은 자유롭게 작성 **
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n*****************************\n");
				System.out.println("***** 사원 관리 프로그램*****");
				
				System.out.println("1. 재직중인 사원 전체 조회"); 
				// 현재 재직중인 사원의
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회
				
				
				System.out.println("2. 퇴직한 사원 전체 조회"); 
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				
				
				System.out.println("3. 사번이 일치하는 사원 조회"); 
				// 사번을 입력 받아 일치하는 사원의  
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("4. 사원 정보 추가(INSERT)");
				// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
				
				
				System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
				// 이메일, 전화번호, 급여, 보너스 수정
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력

				
				System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
				// 사번을 입력 받아 일치하는 사원 삭제
				// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 삭제, N인 경우 취소
				// - 사번이 일치하는 사원이 없으면
				//   "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
				// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
				// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 퇴직 처리, N인 경우 취소
				
				// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
				//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
				
				System.out.println("8. 가장 최근 입사한 사원 5명 조회");
				
				// 가장 최근(입사일이 늦은) 사원 5명의
				// 사번, 이름, 부서명, 입사일을
				// 입사일 내림차순으로 조회
				
				
				System.out.println("9. 부서별 통계 조회"); 
				// 각 부서별
				// 부서명, 인원 수, 급여 평균
				// 부서코드 오름차순 조회
				
				// HINT.
				// - 별도의 DTO 작성 또는 
				//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
				
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1: selectAll(); break;
				case 2: selectRetire(); break;
				case 3: selectEmp(); break;
				case 4: empInsert(); break;
				case 5: updateEmp(); break;
				case 6: deleteEmp(); break;
				case 7: retireEmp(); break;
				case 8: fiveEmp(); break;
				case 9: deptEmp(); break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}

	/**
	 * 1. 재직중인 사원 전체 조회
	 */
	private void selectAll() {
		System.out.println("\n----재직중인 사원 전체 조회----\n");
		try {
			List<Emp> empList = service.selectAll();
			for(Emp e : empList) {
				System.out.printf("%d, %s, %s, %s, %d, %s, %s\n",
						e.getEmpId(),e.getEmpName(),e.getDepartmentTitle(),e.getJobName(),e.getSalary(),e.getPhone(),e.getEmail());
			}
		} catch (SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	/**
	 * 2. 퇴직한 사원 전체 조회
	 */
	private void selectRetire() {
		System.out.println("\n----퇴직한 사원 전체 조회----\n");
		
		try {
			List<Emp> empList = service.selectRetire();
			for(Emp e : empList) {
				System.out.printf("%d, %s, %s, %s, %s\n",
						e.getEmpId(),e.getEmpName(),e.getPhone(),e.getEmail(),e.getEntDate());
			}
		}catch(SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 3. 사번이 일치하는 사원 조회
	 */
	private void selectEmp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n----사번이 일치하는 사원 조회----\n");
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		try {
			List<Emp> empList = service.selectEmp(input);
			if(empList.isEmpty()) {
				System.out.println("[사번이 일치하는 사원이 없습니다]");
			}
			for(Emp e : empList) {
				System.out.printf("%d, %s, %s, %s, %d, %s, %s, %s\n",
						e.getEmpId(),e.getEmpName(),e.getDepartmentTitle(),e.getJobName(),e.getSalary(),e.getPhone(),e.getEmail(),e.getHireDate());
			}
		} catch (SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}

	
	/**
	 * 4.사원 정보 추가
	 */
	private void empInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n----사원 정보 추가----\n");
		
	      System.out.print("이름 : ");
	      String empName = sc.next();
	      
	      System.out.print("주민등록번호 : ");
	      String empNo = sc.next();
	      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("전화번호(-제외) : ");
	      String phone = sc.next();
	      
	      System.out.print("부서코드(D1~D9) : ");
	      String deptCode = sc.next();
	      
	      System.out.print("직급코드(J1~J7) : ");
	      String jobCode = sc.next();
	      
	      System.out.print("급여등급(S1~S6) : ");
	      String salLevel = sc.next();
	      
	      System.out.print("급여 : ");
	      int salary = sc.nextInt();
	      
	      System.out.print("보너스 : ");
	      double bonus = sc.nextDouble();
	      
	      System.out.print("사수번호 : ");
	      int managerId = sc.nextInt();
	      sc.nextLine(); 
		
	      Emp emp = new Emp(empName, empNo, email, phone, salary, deptCode, jobCode, salLevel, bonus, managerId);
	      
	      try {
			int result = service.empInsert(emp);
			String sys = "";
		      if(result>0) sys = "[사원 정보가 추가 되었습니다.]";
		      else sys = "[실패하였습니다.]";
		      System.out.println(sys);
		} catch (SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 5.사번으로 사원 정보 수정
	 */
	private void updateEmp() {
		System.out.println("\n----사번으로 사원 정보 수정----\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이메일 : ");
	    String email = sc.next();
	      
	    System.out.print("전화번호(-제외) : ");
	    String phone = sc.next();
	    
	    System.out.print("급여 : ");
	    int salary = sc.nextInt();
	      
	    System.out.print("보너스 : ");
	    double bonus = sc.nextDouble();
		
	    Emp emp = new Emp();
	    emp.setEmail(email);
	    emp.setPhone(phone);
	    emp.setSalary(salary);
	    emp.setBonus(bonus);

	    try {
			int result = service.updateEmp(input, emp);
			String sys = "";
			if(result>0) sys = "[수정 되었습니다.]";
		    else sys = "[사번이 일치하는 사원이 없습니다.]";
		    System.out.println(sys);
		}catch(SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 6.사번으로 사원 정보 삭제
	 */
	private void deleteEmp() {
		System.out.println("\n----사번으로 사원 정보 삭제----\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		System.out.print("정말 삭제하시겠습니까(Y/N)");
		char yn = sc.next().toUpperCase().charAt(0);
		
		if(yn == 'N') {
			System.out.println("취소");
			return;
		}
		try {
			int result = service.deleteEmp(input);
			String sys = "";
			if(result>0) sys = "[삭제 되었습니다.]";
		    else sys = "[사번이 일치하는 사원이 없습니다.]";
		    System.out.println(sys);
		}catch(SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 7. 사번이 일치하는 사원 퇴직 처리
	 */
	private void retireEmp() {
		System.out.println("\n----사번으로 사원 퇴직 처리----\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("퇴직처리할 사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		System.out.print("정말 퇴직처리하시겠습니까(Y/N)");
		char yn = sc.next().toUpperCase().charAt(0);
		
		if(yn == 'N') {
			System.out.println("취소");
			return;
		}
		try {
			int result = service.retireEmp(input);
			String sys = "";
			if(result>0) sys = "[처리 되었습니다.]";
		    else sys = "[사번이 일치하는 않거나, 이미 퇴직된 사원입니다.]";
		    System.out.println(sys);
		}catch(SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 8. 가장 최근 입사한 사원 5명 조회
	 */
	private void fiveEmp() {
		System.out.println("\n----가장 최근 입사한 사원 5명 조회----\n");
		try {
			List<Emp> empList = service.fiveEmp();
			for(Emp e : empList) {
				System.out.printf("%d, %s, %s, %s\n",e.getEmpId(),e.getEmpName(),e.getDepartmentTitle(),e.getHireDate().toString());
			}
		}catch(SQLException e) {
			System.out.println("[잘못 입력하셨습니다.]");
			e.printStackTrace();
		}
	}
	
	/**
	 * 9. 부서별 통계 조회
	 */
	private void deptEmp() {
		System.out.println("\n----부서별 통계 조회----\n");
		try {
			List<Object> empList = service.deptEmp();
			for(Object empMap : empList) {
				Map<Integer,Object> k = (Map<Integer, Object>) empMap;
				System.out.printf("%s,%s,%s\n",k.get(1),k.get(2), k.get(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
