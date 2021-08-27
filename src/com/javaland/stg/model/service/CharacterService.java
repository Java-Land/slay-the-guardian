package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.rollback;
import static com.javaland.stg.common.JDBCTemplate.close;
import static com.javaland.stg.common.JDBCTemplate.commit;

import java.sql.Connection;

import com.javaland.stg.model.dao.CharacterDAO;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterService {
	
	private CharacterDAO characterDAO = new CharacterDAO();

	public CharacterDTO searchPlayerById(String id) {
		Connection con = getConnection();
		
		CharacterDTO character = characterDAO.searchPlayerById(con, id);
		
		close(con);
		
		return character;
	}

	public int characterInsertById(String id) {
		
		Connection con = getConnection();
		
		int result = characterDAO.characterInsertById(con,id);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
	//주석
		return result;
	}
}
