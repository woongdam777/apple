package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {

	private MainDAO dao = new MainDAO();

	/** 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return
	 * @throws SQLException
	 */
	public Member login(String memberId, String memberPw) throws SQLException{

		// 1. connection 생성
		Connection conn = getConnection();
		// 2. DAO 호출
		Member member = dao.login(conn, memberId, memberPw);
		// 3. Connection 반환
		close(conn);
		// 4. 결과 반환
		return member;
	}

	/** 아이디 중복 검사 서비스
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	public int idDuplicateCheck(String memberId) throws SQLException{
		Connection conn = getConnection();
		int result = dao.idDuplicateCheck(conn, memberId);
		close(conn);
		return result;
	}

	/** 회원가입 서비스
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public int signUp(Member member) throws SQLException{
		Connection conn = getConnection();
		// DAO호출
		int result = dao.signup(conn, member);
		// 트랜잭션 처리
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	
}
