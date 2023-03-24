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
	
	
	
	
	
}
