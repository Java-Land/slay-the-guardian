package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.rollback;
import static com.javaland.stg.common.JDBCTemplate.close;
import static com.javaland.stg.common.JDBCTemplate.commit;

import java.sql.Connection;

import com.javaland.stg.model.dao.CharacterUpdateDAO;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateService {

	private CharacterUpdateDAO characterUpdateDAO = new CharacterUpdateDAO();
	
	public int characterUpdateService(CharacterDTO character) {
		Connection con = getConnection();
		
		int result = characterUpdateDAO.characterUpdateService(con, character);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
}