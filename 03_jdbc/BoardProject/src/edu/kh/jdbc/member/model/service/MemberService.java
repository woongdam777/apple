package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 회원 정보 조회 서비스
	 * @return
	 * @throws SQLException
	 */
	public List<Member> selectMemberList() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Member> memlist = dao.selectMemberList(conn);
		
		close(conn);
		return memlist;
	}
}
