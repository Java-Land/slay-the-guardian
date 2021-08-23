package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.close;
import java.sql.Connection;

import com.javaland.stg.model.dao.CharacterDAO;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterService {
	
	private CharacterDAO characterDAO = new CharacterDAO();

	public CharacterDTO characterService(String id) {
		Connection con = getConnection();
		
		CharacterDTO character = characterDAO.characterService(con, id);
		
		close(con);
		
		return character;
	}

}