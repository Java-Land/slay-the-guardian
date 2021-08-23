package com.javaland.stg.model.dao;

import static com.javaland.stg.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.javaland.stg.model.dto.UserDTO;

public class UserDAO {

	private Properties prop = new Properties();
	
	public UserDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/account-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int registPlayer(Connection con, UserDTO userDTO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPlayer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userDTO.getUserId());
			pstmt.setString(2, userDTO.getUserPwd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectPwd(Connection con, UserDTO userDTO) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserId");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userDTO.getUserId());
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				if (rset.getString(1).equals(userDTO.getUserPwd())) {
					return 1;				// 로그인 성공
				} else {
					return 0;				// 비밀번호 불일치
				}
			}
			return -1;						// 아이디가 없음
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return -2;							// DB 오류
	}
	
	public int selectSameId(Connection con, UserDTO userDTO) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectSameUserid");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userDTO.getUserId());
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				if (rset.getString(1).equals(userDTO.getUserId())) {
					return -1;
				} else {
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return -2;
	}

	public int insertPlayerInfo(Connection con, UserDTO userDTO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertLogin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userDTO.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* */
}
