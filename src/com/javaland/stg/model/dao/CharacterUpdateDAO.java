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
		ResultSet rset = null;
		
		String query = prop.getProperty("characterUpdateService");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, character.getId());
			pstmt.setInt(2, character.getCode());
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				character.setCode(rset.getInt("PLAYER_CODE"));
				character.setId(rset.getString("PLAYER_ID"));
				character.setHp(rset.getInt("PLAYER_HP"));
				character.setMaxHp(rset.getInt("PLAYER_MAX_HP"));
				character.setSp(rset.getInt("PLAYER_SP"));
				character.setDp(rset.getInt("PLAYER_DP"));
				character.setGold(rset.getInt("PLAYER_GOLD"));
				character.setExp(rset.getInt("PLAYER_EXP"));
				character.setLevel(rset.getInt("PLAYER_Level"));
				character.setPlayTime(rset.getDate("PLAY_TIME"));
				character.setLiveYN(rset.getString("PLAYER_LIVE_YN"));
				character.setStage1ClearYN(rset.getString("STAGE1_CLEAR_YN"));
				character.setStage2ClearYN(rset.getString("STAGE2_CLEAR_YN"));
			}
			result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
}
