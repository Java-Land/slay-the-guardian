package com.javaland.stg.model.service;

import static com.javaland.stg.common.JDBCTemplate.getConnection;
import static com.javaland.stg.common.JDBCTemplate.close;


import java.sql.Connection;
import java.util.List;

import com.javaland.stg.model.dao.UserListDAO;
import com.javaland.stg.model.dto.UserListDTO;

public class UserListService {
	
	private UserListDAO userListDAO = new UserListDAO();

	public List<UserListDTO> selectUserList() {
		
		Connection con = getConnection();
		
		List<UserListDTO> userList = userListDAO.selectUserList(con);

		close(con);
		
		return userList;
		
	}
	
	

}
