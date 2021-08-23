package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.close;
import static com.javaland.stg.common.JDBCTemplate.commit;
import static com.javaland.stg.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.javaland.stg.model.dao.UserDAO;
import com.javaland.stg.model.dto.UserDTO;

public class UserService {
	
	private UserDAO userDAO = new UserDAO();

	public int registPlayer(UserDTO userDTO) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = userDAO.registPlayer(con, userDTO);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int selectPwd(UserDTO userDTO) {
		Connection con = getConnection();
		int result = 0;
		
		result = userDAO.selectPwd(con, userDTO);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	public int selectSameID(UserDTO userDTO) {
		Connection con = getConnection();
		int result = 0;
		
		result = userDAO.selectSameId(con, userDTO);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int insertPlayerInfo(UserDTO userDTO) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = userDAO.insertPlayerInfo(con, userDTO);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	/* */
}