package com.javaland.stg.model.dao;

import static com.javaland.stg.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateDAO {
	
	private Properties prop = new Properties();
	
	public CharacterUpdateDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/character-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int characterUpdateService(Connection con, CharacterDTO character) {
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("characterUpdateService");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, character.getHp());
			pstmt.setInt(2, character.getMaxHp());
			pstmt.setInt(3, character.getSp());
			pstmt.setInt(4, character.getDp());
			pstmt.setInt(5, character.getGold());
			pstmt.setInt(6, character.getExp());
			pstmt.setInt(7, character.getLevel());
			pstmt.setDate(8, character.getPlayTime());
			pstmt.setString(9, character.getLiveYN());
			pstmt.setString(10, character.getStage1ClearYN());
			pstmt.setString(11, character.getStage2ClearYN());
			pstmt.setString(12, character.getId());
			pstmt.setInt(13, character.getCode());
			
			result = pstmt.executeUpdate();
						
			result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}