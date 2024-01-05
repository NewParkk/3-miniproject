package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import common.util.DBUtil;
import noticeBoard.dto.NoticeBoardDTO;

public class BoardDAO {
	
	// get notice board List ()
	public static ArrayList<NoticeBoardDTO> getBoardList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeBoardDTO> boardList = null;
		
		String sql = "select * from notice_board";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			boardList = new ArrayList<NoticeBoardDTO>();
			
			while(rset.next()) {
				boardList.add(new NoticeBoardDTO(rset.getInt("notice_id"),
												rset.getString("notice_title"),
												rset.getString("notice_date"),
												rset.getString("notice_content"),
												rset.getString("user_id")));
			}
			return boardList;
			
		} finally {
			DBUtil.close(rset, pstmt, con);
		}
	}
		
		
		// get notice board By user_id ()
		public static ArrayList<NoticeBoardDTO> getBoardListByUserId(String user_id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<NoticeBoardDTO> boardList = null;
			
			String sql = "select * from notice_board where user_id = ?";
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "user_id");
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					boardList.add(new NoticeBoardDTO(rset.getInt("notice_id"),
													rset.getString("notice_title"),
													rset.getString("notice_date"),
													rset.getString("notice_content"),
													rset.getString("user_id")));
				}
				return boardList;
				
			} finally {
				DBUtil.close(rset, pstmt, con);
			}
	}
	
	// getBoardByBoardId ()

		public static NoticeBoardDTO getBoardByBoardId(String board_id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			NoticeBoardDTO board = null;
			
			String sql = "select * from notice_board where notice_id = ?";
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board_id);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					board = new NoticeBoardDTO(rset.getInt("notice_id"),
													rset.getString("notice_title"),
													rset.getString("notice_date"),
													rset.getString("notice_content"),
													rset.getString("user_id"));
				}
				return board;
				
			} finally {
				DBUtil.close(rset, pstmt, con);
			}
}
	// insertBoard()

	
	public static boolean insertBoard(String boardtitle, String boardcontent, String userid) throws SQLException {	
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql =  "INSERT INTO notice_board(notice_title, notice_date, notice_content, user_id)"
					+ "VALUES (?, CURRENT_TIMESTAMP, ?, ?)";
		
		try {
			con = DBUtil.getConnection();
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardtitle);
			pstmt.setString(2, boardcontent);
			pstmt.setString(3, userid);
		
		result = pstmt.executeUpdate();
		if (result != 0) {
			return true;
		}
	}finally {
		DBUtil.close(pstmt, con);
	}
		return false;
	}
		
	
	// deleteBoard  (글 삭제)
		public static boolean deleteBoardByUserId(String user_id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			int result = 0;
				
			String sql = "DELETE FROM notice_board WHERE user_id = ?";
				
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
					
				pstmt.setString(1, user_id);
					
				result = pstmt.executeUpdate();
					
				if(result != 0) {
					return true;
				}
					
			}finally {
				DBUtil.close(pstmt, con);
			}
				
			return false;
		}
	

	
	
	
	
	
	
	
	
	
}
