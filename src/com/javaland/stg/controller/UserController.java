package com.javaland.stg.controller;

import java.util.Map;

import com.javaland.stg.model.dto.UserDTO;
import com.javaland.stg.model.service.UserService;

public class UserController {
	
	private UserService userService = new UserService();

	public void registPlayer(Map<String, String> requestmap) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(requestmap.get("ID"));
		userDTO.setUserPwd(requestmap.get("PW"));
		
		int registResult = userService.registPlayer(userDTO);
		
	}

	public int loginSuccess(Map<String, String> requestmap) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(requestmap.get("ID"));
		userDTO.setUserPwd(requestmap.get("PW"));
		
		int result = userService.selectPwd(userDTO);
		
		return result;
	}
	

	public int registInfo(Map<String, String> requestmap) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(requestmap.get("ID"));
		userDTO.setUserPwd(requestmap.get("PW"));
		
		int result = userService.insertPlayerInfo(userDTO);
		
		return result;
	}

	public int selectSameId(String id) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(id);
		
		int result = userService.selectSameID(userDTO);
		
		return result;
	}

	/* */
}