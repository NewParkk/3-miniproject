package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DBUtil;
import noticeBoard.dto.NoticeBoardDTO;

public class BoardDAO {
	
	// get notice board List (��� �� ��� �˻�)
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
		
		
		// get notice board By user_id (���� ���̵�� �ۼ� �� ��� �˻�)
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
	
	// getBoardByBoardId (�� �ϳ� �˻�)
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		// insertBoard(�� �� ����)
		
		
		
		
		
		
		
		
		
		//updateBoard (�� ����)
		
		
		// deleteBoard (�� ����)
		
	
}