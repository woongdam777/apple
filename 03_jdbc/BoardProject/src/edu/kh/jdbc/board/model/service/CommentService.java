package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;
import oracle.net.nt.ConnectDescription;

public class CommentService {
	
	private CommentDAO commentDao = new CommentDAO();

	/** 댓글 등록 서비스
	 * @param boardNo
	 * @param memberNo
	 * @param sb
	 * @return
	 * @throws Exception
	 */
	public int insertComment(int boardNo, int memberNo, StringBuffer sb) throws Exception{

		Connection conn = getConnection();
		
		int result = commentDao.insertComment(conn, boardNo, memberNo,sb);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int commentCheck(int input, int memberNo, int boardNo) throws Exception{

		Connection conn = getConnection();
		
		int check = commentDao.commentCheck(conn, input, memberNo, boardNo);
		
		close(conn);
		
		return check;
	}

	public int updateComment(int input, int boardNo, int memberNo,  StringBuffer sb) throws Exception{

		Connection conn = getConnection();
		
		int result = commentDao.updateComment(conn, input, boardNo, memberNo,sb);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteComment(int input, int boardNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = commentDao.deleteComment(conn, input, boardNo, memberNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}
