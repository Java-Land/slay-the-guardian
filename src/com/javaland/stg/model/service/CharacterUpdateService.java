package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.close;

import java.sql.Connection;

import com.javaland.stg.model.dao.CharacterUpdateDAO;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateService {

	private CharacterUpdateDAO characterUpdateDAO = new CharacterUpdateDAO();
	
	public int characterUpdateService(CharacterDTO character) {
		Connection con = getConnection();
		
		int result = characterUpdateDAO.characterUpdateService(con, character);
		
		close(con);
		
		return 0;
	}
}