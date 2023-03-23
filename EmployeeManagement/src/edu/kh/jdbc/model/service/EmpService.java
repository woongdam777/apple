package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();
	
	
	/** 재직중인 사원 전체 조회 서비스
	 * @return empList
	 */
	public List<Emp> selectAll() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectAll(conn);
		
		close(conn);
		
		return empList;
	}


	/** 퇴직한 사원 전체 조회 서비스
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectRetire() throws SQLException{

		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		return empList;
	}


	/** 사번이 일치하는 사원 조회 서비스
	 * @param input
	 * @return
	 */
	public Emp selectEmp(int input) throws SQLException{
	
		Connection conn = getConnection();
		
		Emp emp = dao.selectEmp(conn, input);
		
		close(conn);
		
		return emp;
	}


	/** 사원 정보 추가 서비스
	 * @param emp
	 */
	public int empInsert(Emp emp) throws SQLException{

		Connection conn = getConnection();
		
		int result = dao.empInsert(conn,emp);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);

		return result;
	}


	/** 사번으로 사원 정보 수정 서비스
	 * @param input
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmp(int input, Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn,input, emp);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}


	/** 사번으로 사원 정보 삭제 서비스
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(int input) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.deleteEmp(conn, input);
		if(result >0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check (0: 없는 사원, 1:퇴직한 사원, 2:재직중인 사원
	 * @throws SQLException
	 */
	public int checkretireEmp(int input) throws SQLException{

		Connection conn = getConnection();
		int check = dao.checkretireEmp(conn, input);
		close(conn);
		return check;
	}
	
	/** 사번이 일치하는 사원 퇴직 처리 서비스
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public void/*int*/ retireEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
//		int result = dao.retireEmp(conn, input);
//		if(result >0 ) commit(conn);
//		else rollback(conn);
		dao.retireEmp(conn, input);
		// 트랜잭션 처리
		// DB예외 발생시 SQL 수행이 정상적으로 진행되지 않음
		commit(conn);
		close(conn);
//		return result;
	}


	/** 가장 최근 입사한 사원 5명 조회 서비스
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> fiveEmp() throws SQLException{
		
		Connection conn = getConnection();
		List<Emp> empList = dao.fiveEmp(conn);
		
		close(conn);
		
		return empList;
	}


	/** 부서별 통계 조회 서비스
	 * @return
	 * @throws SQLException
	 */
	public List<Object> deptEmp() throws SQLException{

		Connection conn = getConnection();
		List<Object>empList = dao.deptEmp(conn);
		close(conn);
		return empList;
	}


	
	
}

