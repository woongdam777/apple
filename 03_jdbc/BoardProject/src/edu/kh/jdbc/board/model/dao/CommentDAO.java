package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.common.Session;

public class CommentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception{
		List<Comment> commentList = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectCommentList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				commentList.add(c);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	}

	/** 댓글 등록 SQL 수행
	 * @param conn
	 * @param boardNo
	 * @param memberNo
	 * @param sb
	 * @return
	 * @throws Exception
	 */
	public int insertComment(Connection conn, int boardNo, int memberNo, StringBuffer sb) throws Exception{

		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sb.toString());
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int commentCheck(Connection conn, int input, int memberNo, int boardNo) throws Exception{
		int check = 0;
		
		try {
			String sql = prop.getProperty("commentCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}

	public int updateComment(Connection conn, int input, int boardNo, int memberNo, StringBuffer sb) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sb.toString());
			pstmt.setInt(2, input);
			pstmt.setInt(3, memberNo);
			pstmt.setInt(4, boardNo);
			
			result = pstmt.executeUpdate();
		
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteComment(Connection conn, int input, int boardNo, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}
