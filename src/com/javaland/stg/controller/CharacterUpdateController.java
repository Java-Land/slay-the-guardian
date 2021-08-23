package com.javaland.stg.controller;

import com.javaland.stg.model.service.CharacterUpdateService;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateController {

	private CharacterUpdateService characterUpdateService = new CharacterUpdateService();
	
	public int updatePlayer(CharacterDTO character) {
		
		int result = characterUpdateService.characterUpdateService(character);
		
		return result;
	}
}
