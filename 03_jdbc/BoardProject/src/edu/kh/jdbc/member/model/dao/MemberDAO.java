package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// xml에 작성된 SQL을 읽어봐 저장할 객체 참조 변수
	private Properties prop;
	
	/**
	 * 내 정보 조회
	 */
	public MemberDAO() { // 기본 생성자로 객체 생성시 XML 읽어오기
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 회원 정보 조회
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Member> selectMemberList(Connection conn) throws SQLException{
		List<Member> memlist = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMemberList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String memberId = rs.getString(1);
				String memberName = rs.getString(2);
				String memberGender = rs.getString(3);
				
				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				memlist.add(member);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return memlist;
	}

	/** 내 정보 수정 SQL
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	public int updateMember(Connection conn, String memberName, String memberGender, int memberNo) throws SQLException{
		// 1. 결과 저장용 변수 선언
		int result = 0;
		
		try {
			// 2. SQL 작성, 수행
			String sql = prop.getProperty("updateMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			// 3. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 4. 결과 반환
		return result;
	}

	/** 비밀번호 변경 SQL
	 * @param conn
	 * @param curPass
	 * @param newPass
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String curPass, String newPass, int memberNo) throws Exception{

		int result = 0;
		try {
			String sql = prop.getProperty("updatePassword");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, curPass);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int unregisterMember(Connection conn, String memberPw, int memberNo) throws SQLException{
		int result = 0;
		try {
			String sql = prop.getProperty("unregisterMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPw);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
}
