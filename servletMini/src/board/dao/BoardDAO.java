package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DBUtil;
import noticeBoard.dto.NoticeBoardDTO;

public class BoardDAO {
	
	// get notice board List (모든 글 목록 검색)
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
		
		
		// get notice board By user_id (유저 아이디로 작성 글 목록 검색)
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
	
	// getBoardByBoardId (글 하나 검색)
	
	
		
	// insertBoard(새 글 생성)
		
		
		
	//updateBoard (글 수정)
		public static boolean updateBoard(NoticeBoardDTO board) throws SQLException {
		    Connection con = null;
		    PreparedStatement pstmt = null;

		    int result = 0;

		    String sql = "UPDATE notice_board SET notice_title = ?, notice_date = ?, notice_content = ? WHERE notice_id = ?";

		    try {
		        con = DBUtil.getConnection();

		        pstmt = con.prepareStatement(sql);

		        pstmt.setString(1, board.getNoticeTitle());    
		        pstmt.setString(2, board.getNoticeDate());     
		        pstmt.setString(3, board.getNoticeContent()); 
		        pstmt.setInt(4, board.getNoticeId());           

		        result = pstmt.executeUpdate();

		        if (result != 0) {
		            return true;
		        }

		    } finally {
		        DBUtil.close(pstmt, con);
		    }

		    return false;
		}
		
		
		
	// deleteBoard  (글 삭제)
		
	
}
