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
	public List<Emp> selectEmp(int input) throws SQLException{
	
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectEmp(conn, input);
		
		close(conn);
		
		return empList;
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
		
		return result;
	}


	/** 사번이 일치하는 사원 퇴직 처리 서비스
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int retireEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
		int result = dao.retireEmp(conn, input);
		if(result >0 ) commit(conn);
		else rollback(conn);
		
		return result;
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

