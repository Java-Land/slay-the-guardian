package com.javaland.stg.model.dao;

import static com.javaland.stg.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.javaland.stg.model.dto.UserListDTO;

public class UserListDAO {

	private Properties prop = new Properties();

	public UserListDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/userList-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserListDTO> selectUserList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		List<UserListDTO> userList = null;
		
		String query = prop.getProperty("selectUserList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			userList = new ArrayList<>();

			while(rset.next()) {
				UserListDTO user = new UserListDTO();
				user.setId(rset.getString("PLAYER_ID"));
				user.setPlayTime(rset.getDate("PLAY_TIME"));
				user.setLevel(rset.getInt("PLAYER_LEVEL"));
				user.setExp(rset.getInt("PLAYER_EXP"));
				user.setGold(rset.getInt("PLAYER_GOLD"));
				user.setMaxHp(rset.getInt("PLAYER_MAX_HP"));
				user.setSp(rset.getInt("PLAYER_SP"));
				user.setDp(rset.getInt("PLAYER_DP"));
				user.setBlackListYN(rset.getString("USER_BL_YN"));
				
				userList.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return userList; 
	
	}
	

	
}
