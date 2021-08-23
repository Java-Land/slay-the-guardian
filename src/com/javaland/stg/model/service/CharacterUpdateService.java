package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.close;

import java.sql.Connection;

import com.javaland.stg.model.dao.CharacterUpdateDAO;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateService {

	private CharacterUpdateDAO characterUpdateDAO = new CharacterUpdateDAO();
	
	public CharacterDTO characterUpdateService(String id, int code) {
		Connection con = getConnection();
		
		CharacterDTO character = characterUpdateDAO.characterUpdateService(con, id, code);
		
		close(con);
		
		return character;
	}
}
