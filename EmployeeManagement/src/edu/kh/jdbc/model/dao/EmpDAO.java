package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/** 재직중인 사원 전체 조회 SQL
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException{

		List<Emp> empList = new ArrayList<>();
		try {
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp emp = new Emp();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				
				empList.add(emp);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/** 퇴직한 사원 전체 조회 SQL
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectRetire(Connection conn) throws SQLException{

		List<Emp> empList = new ArrayList<>();
		try {
			
			String sql = "SELECT EMP_ID , EMP_NAME , PHONE, EMAIL, ENT_DATE \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDay = rs.getString(5);
				
				Emp emp = new Emp();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setEntDate(entDay);
				
				empList.add(emp);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/** 사번이 일치하는 사원 조회 SQL
	 * @param conn
	 * @param input
	 * @return
	 */
	public Emp selectEmp(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		try {
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, HIRE_DATE \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				
				emp = new Emp();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setHireDate(hireDate);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}


	/** 사원 정보 추가 SQL
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int empInsert(Connection conn, Emp emp) throws SQLException{
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?, SYSDATE, NULL, 'N')";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,emp.getEmpName());
			pstmt.setString(2,emp.getEmpNo());
			pstmt.setString(3,emp.getEmail());
			pstmt.setString(4,emp.getPhone());
			pstmt.setString(5,emp.getDeptCode());
			pstmt.setString(6,emp.getJobCode());
			pstmt.setString(7,emp.getSalLevel());
			pstmt.setInt(8,emp.getSalary());
			pstmt.setDouble(9,emp.getBonus());
			pstmt.setInt(10,emp.getManagerId());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/**사번으로 사원 정보 수정 SQL
	 * @param conn
	 * @param input
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmp(Connection conn, int input, Emp emp) throws SQLException{
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL =?,PHONE =?,SALARY =?, BONUS =?\r\n"
					+ "WHERE EMP_ID = " + input;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 사번으로 사원 정보 삭제 SQL
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(Connection conn, int input) throws SQLException{
		int result = 0;
		try {
			String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환 SQL
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int checkretireEmp(Connection conn, int input) throws SQLException{

		int check = 0;
		try {
			String sql = "SELECT CASE \r\n"
					+ "      -- 존재하지 않는 사원?\r\n"
					+ "      WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0\r\n"
					+ "      THEN 0\r\n"
					+ "      -- 존재하지만 퇴직한 사원?\r\n"
					+ "      WHEN (SELECT COUNT(*) FROM EMPLOYEE \r\n"
					+ "           WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "      THEN 1\r\n"
					+ "      -- 존재는 하지만 퇴직하지 않은 사원!\r\n"
					+ "      ELSE 2\r\n"
					+ "   END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return check;
	}
	
	/** 사번이 일치하는 사원 퇴직 처리 SQL
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public /*int*/ void retireEmp(Connection conn, int input) throws SQLException{
//		int result = 0;
		try {
			String sql = "UPDATE EMPLOYEE SET ENT_YN = 'Y',ENT_DATE = SYSDATE WHERE EMP_ID = ? AND ENT_YN = 'N'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
//			result = pstmt.executeUpdate();
			pstmt.executeQuery();
		}finally {
			close(pstmt);
		}
		
//		return result;
	}


	/** 가장 최근 입사한 사원 5명 조회 SQL
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> fiveEmp(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<>();
		try {
			String sql = "SELECT *\r\n"
					+ "FROM (SELECT EMP_ID ,EMP_NAME, DEPT_TITLE, HIRE_DATE \r\n"
					+ "		FROM EMPLOYEE \r\n"
					+ "		LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "		ORDER BY HIRE_DATE DESC)\r\n"
					+ "WHERE ROWNUM <= 5";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				Date hireDate = rs.getDate(4);
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setHireDate(hireDate);
				
				empList.add(emp);
			}			
		}finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}


	/** 부서별 통계 조회 SQL
	 * @param <empMap>
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Object> deptEmp(Connection conn) throws SQLException{
		
		List<Object> empList = new ArrayList<>();		
		
		
		try {
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE,'부서없음') 부서명, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균 \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_TITLE, DEPT_CODE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String deptTitle = rs.getString("부서명");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<Integer,Object> map = new LinkedHashMap(); // 입력 순서가 유지되는 Map
				map.put(1, deptTitle);
				map.put(2, count);
				map.put(3, avg);
				
				empList.add(map);
			}
			
			System.out.println();
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}






}
