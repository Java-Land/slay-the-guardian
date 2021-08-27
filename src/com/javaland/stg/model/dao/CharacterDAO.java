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
import com.javaland.stg.model.service.CharacterService;

public class CharacterDAO {
	
	private Properties prop = new Properties();
	
	public CharacterDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/character-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CharacterDTO searchPlayerById(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("characterService");
		
		CharacterDTO character = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			character = new CharacterDTO();
			
			while(rset.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return character;
	}

	public int characterInsertById(Connection con, String id) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("characterInsertById");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
