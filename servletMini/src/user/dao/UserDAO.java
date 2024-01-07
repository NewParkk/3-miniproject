package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DBUtil;
import user.dto.UserDTO;

public class UserDAO {
	public static UserDTO getUserByUserId(String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		UserDTO user = null;
		
		String sql = "SELECT * FROM user WHERE user_id = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				user = new UserDTO(rset.getString("user_id"),
									rset.getString("user_name"),
									rset.getString("password"));
			}
			return user;
			
		} finally {
			DBUtil.close(rset, pstmt, con);
		}
	}
	
	public static boolean insertUser(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql = "INSERT INTO user VALUES (?, ?, ?)";
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			
			result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		}finally {
			DBUtil.close(pstmt, con);
		}
		
		return false;
	}

	public static UserDTO getUserByUserIdandPassword(String userId, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		UserDTO user = null;
		
		String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				user = new UserDTO(rset.getString("user_id"),
									rset.getString("user_name"),
									rset.getString("password"));
			}
			return user;
			
		} finally {
			DBUtil.close(rset, pstmt, con);
		}
	
	}
		
}
	
	
