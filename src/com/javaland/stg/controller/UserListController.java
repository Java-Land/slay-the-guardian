package com.javaland.stg.controller;

import java.util.List;

import com.javaland.stg.model.dto.UserListDTO;
import com.javaland.stg.model.service.UserListService;

public class UserListController {
	
	private UserListService userListService = new UserListService();
	
	public List<UserListDTO> selectUserList() {
		List<UserListDTO> userList = userListService.selectUserList();
		
		return userList;
	}
	
	
	

}
