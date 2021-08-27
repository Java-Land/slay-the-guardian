package com.javaland.stg.controller;

import com.javaland.stg.model.dto.CharacterDTO;
import com.javaland.stg.model.dto.UserDTO;
import com.javaland.stg.model.service.CharacterService;

	public class CharacterController {

	private CharacterService characterService = new CharacterService();
	
	public CharacterDTO searchPlayerById(String id) {
		
		CharacterDTO character = characterService.searchPlayerById(id);
		
		return character;
	}
	
	public int characterInsertById(String id) {
		
		int result = characterService.characterInsertById(id);
		
		return result;

	}
}
